package com.nextstyle.ICAI.casansaar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class profile_activity extends AppCompatActivity {
    private static final int REQUEST_INVITE =101 ;
    private static final String TAG = "sending invitation";
    private TextView mdisplay_name;
private TextView mdesignation;
private TextView mphone;
private TextView memail;
private TextView mweb;
private TextView morg;
private TextView moffice;
private TextView mDOB;
private ImageView profile_image;
private DatabaseReference muserDatabase;
private ImageView image_view;
private String uid;
    int displayHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);
        mDOB= (TextView) findViewById(R.id.profile_DOB);
        moffice= (TextView) findViewById(R.id.profile_office);
        mdisplay_name= (TextView) findViewById(R.id.profile_name);
        mdesignation= (TextView) findViewById(R.id.profile_designation);
        mphone= (TextView) findViewById(R.id.profile_phone);
        memail= (TextView) findViewById(R.id.profile_email);
        profile_image= (ImageView) findViewById(R.id.profile_imageView);
        mweb= (TextView) findViewById(R.id.profile_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        displayHeight = getWindowManager().getDefaultDisplay().getHeight()/2;
        profile_image.getLayoutParams().height = displayHeight;
        profile_image.requestLayout();

        morg= (TextView) findViewById(R.id.profile_org);

        uid = getIntent().getStringExtra("uid");

            muserDatabase = FirebaseDatabase.getInstance().getReference().child(getIntent().getStringExtra("type")).child(uid);

            muserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            {
                        mDOB.setText(dataSnapshot.child("DOB").getValue().toString());
                        moffice.setText(dataSnapshot.child("OfficeAddress").getValue().toString());
                        mdesignation.setText(dataSnapshot.child("Designation").getValue().toString());
                        mdisplay_name.setText(dataSnapshot.child("Name").getValue().toString());
                        memail.setText(dataSnapshot.child("Email").getValue().toString());
                        morg.setText(dataSnapshot.child("Organization").getValue().toString());
                        mphone.setText(dataSnapshot.child("PPhone").getValue().toString());
                        mweb.setText(dataSnapshot.child("OPhone").getValue().toString());
                        final String image=dataSnapshot.child("profileImage").getValue().toString();
                        Picasso.with(getApplicationContext()).load(image).networkPolicy(NetworkPolicy.OFFLINE).resize(getWindowManager().getDefaultDisplay().getWidth(),displayHeight).placeholder(R.drawable.if_unknown_403017).into(profile_image, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
                                Picasso.with(profile_activity.this).load(image).placeholder(R.drawable.if_unknown_403017).into(profile_image);
                            }
                        });
               }
               }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        FloatingActionButton fab= (FloatingActionButton) findViewById(R.id.profile_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                muserDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Intent intent = new AppInviteInvitation.IntentBuilder(mdisplay_name.getText())
                                .setMessage("Contact Sent using CA Sansaar:\n" +mweb.getText()+"\n"+
                                        mdisplay_name.getText()+"\n"
                                        +memail.getText()+"\n"
                                         +mphone.getText())
                                .setDeepLink(Uri.parse("https://icainotes-10d80.firebaseio.com/"+uid))
                                .build();
                        setResult(RESULT_OK,intent);
                        startActivityForResult(intent, REQUEST_INVITE);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode);

        if (requestCode == REQUEST_INVITE) {
            if (resultCode == RESULT_OK) {
                // Get the invitation IDs of all sent messages
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
                for (String id : ids) {
                    Log.d(TAG, "onActivityResult: contact shared " + id);
                }
            } else {
                // Sending failed or it was canceled, show failure message to the user
                // ...
            }
        }
    }
}
