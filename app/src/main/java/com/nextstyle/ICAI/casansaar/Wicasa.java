package com.nextstyle.ICAI.casansaar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class Wicasa extends Fragment {
RecyclerView wicasaList;
private DatabaseReference mdatabase;
FirebaseRecyclerAdapter<DTO,user_view_holder> firebaseRecyclerAdapter;

    public Wicasa() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_wicasa, container, false);
        mdatabase= FirebaseDatabase.getInstance().getReference().child("Wicasa");
        wicasaList=view.findViewById(R.id.wicasa_list);
       wicasaList.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<DTO, user_view_holder>(DTO.class,
                R.layout.user_single_layout,
                user_view_holder.class,
                mdatabase) {
            @Override
            public long getItemId(int position) {
                return super.getItemId(position);
            }

            @Override
            protected void populateViewHolder(user_view_holder viewHolder, DTO model, int position) {

                viewHolder.setName(model.getName());
                viewHolder.setEmail(model.getEmail());
                viewHolder.setorg(model.getDesignation());
                viewHolder.setMnumber(model.getMnumber());
                viewHolder.setthumb_image(model.getProfileImage(),getContext());
                final String uid=getRef(position).getKey();
                viewHolder.mview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent profile_intent = new Intent(getActivity(), profile_activity.class);
                        profile_intent.putExtra("uid", uid);
                        profile_intent.putExtra("type","Wicasa");
                        startActivity(profile_intent);
                    }
                });
            }
        };

        firebaseRecyclerAdapter.setHasStableIds(true);
        firebaseRecyclerAdapter.notifyDataSetChanged();

        wicasaList.setAdapter(firebaseRecyclerAdapter);
    }
// TODO: Rename method, update argument and hook method into UI event
public static class  user_view_holder extends RecyclerView.ViewHolder{
    View mview;


    public user_view_holder(View itemView) {
        super(itemView);
        mview=itemView;
    }
    public void setName(String name){
        TextView musername=mview.findViewById(R.id.user_single__name);
        musername.setText(name);
    }

    public void setEmail(String email) {
        TextView memail=mview.findViewById(R.id.user_single_email);
        memail.setText(email);
    }

    public void setorg(String org) {
        TextView morg=mview.findViewById(R.id.user_single_org);
        morg.setText(org);
    }
    public  void setMnumber(String Mnumber)
    {
        TextView mnum=mview.findViewById(R.id.Mnumber);
        mnum.setText("("+Mnumber+")");
    }
    public void setthumb_image(final String thumb_image, final Context c) {
        final CircleImageView userimageview=mview.findViewById(R.id.user_single_image);
        Picasso.with(c).load(thumb_image).networkPolicy(NetworkPolicy.OFFLINE).placeholder(R.drawable.if_unknown_403017).into(userimageview, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                Picasso.with(c).load(thumb_image).placeholder(R.drawable.if_unknown_403017).into(userimageview);
            }
        });
    }
}
}

