package com.nextstyle.ICAI.casansaar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class Motto extends Fragment {

    DatabaseReference mdatabase;
   public Motto()
   {
   }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Runtime.getRuntime().gc();
       final View view=inflater.inflate(R.layout.fragment_motto,container,false);
       final ImageView imageView=view.findViewById(R.id.imageView);
       mdatabase= FirebaseDatabase.getInstance().getReference().child("Motto");
        android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        final Display display = getActivity().getWindowManager().getDefaultDisplay();
        layoutParams.width = display.getWidth();
        layoutParams.height =  (display.getHeight());
        imageView.setLayoutParams(layoutParams);
        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final String path=dataSnapshot.child("mottoImage").getValue().toString();
                Picasso.with(getContext()).load(path).networkPolicy(NetworkPolicy.OFFLINE).placeholder(R.drawable.gallery_default).into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Picasso.with(getContext()).load(path).placeholder(R.drawable.gallery_default).into(imageView);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

       return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
