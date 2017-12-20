package com.nextstyle.ICAI.casansaar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class Gallery_ImageView extends AppCompatActivity {

    ImageView gallery;
    DatabaseReference gdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery__image_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Ca Sansaar");
        setSupportActionBar(toolbar);
        String uid=getIntent().getStringExtra("uid");
        gallery=findViewById(R.id.imageView5);
        gdatabase=FirebaseDatabase.getInstance().getReference().child("Gallery").child(uid);

        gdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final String image=dataSnapshot.child("url").getValue().toString();
                Picasso.with(getApplicationContext()).load(image).networkPolicy(NetworkPolicy.OFFLINE).fit().placeholder(R.drawable.gallery_default).into(gallery, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Picasso.with(Gallery_ImageView.this).load(image).placeholder(R.drawable.gallery_default).into(gallery);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
