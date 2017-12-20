package com.nextstyle.ICAI.casansaar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class Gallery extends Fragment {


    DatabaseReference mdatabase;
    RecyclerView committeeList;
    FirebaseRecyclerAdapter<DTO,user_view_holder> firebaseRecyclerAdapter;


    public Gallery() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Runtime.getRuntime().gc();
        View view=inflater.inflate(R.layout.fragment_committee, container, false);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Gallery");
        committeeList = view.findViewById(R.id.committee_list);
        committeeList.setLayoutManager(new GridLayoutManager(getContext(),3));
        committeeList.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<DTO, user_view_holder>(DTO.class,
                R.layout.gallery_thumbnail,
                user_view_holder.class,
                mdatabase) {
            @Override
            public long getItemId(int position) {
                return super.getItemId(position);
            }

            @Override
            protected void populateViewHolder(user_view_holder viewHolder, DTO model, int position) {

                viewHolder.setthumb_image(model.getUrl(),getContext());
                final String uid=getRef(position).getKey();
                viewHolder.mview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent gallery_intent = new Intent(getActivity(), Gallery_ImageView.class);
                        gallery_intent.putExtra("uid", uid);
                        startActivity(gallery_intent);
                    }
                });
            }
        };

        firebaseRecyclerAdapter.setHasStableIds(true);
        firebaseRecyclerAdapter.notifyDataSetChanged();

        committeeList.setAdapter(firebaseRecyclerAdapter);
    }
    public static class  user_view_holder extends RecyclerView.ViewHolder{
        View mview;


        public user_view_holder(View itemView) {
            super(itemView);
            mview=itemView;
        }
        public void setthumb_image(final String thumb_image, final Context c) {
            final ImageView userimageview=mview.findViewById(R.id.imageView8);
            Picasso.with(c).load(thumb_image).networkPolicy(NetworkPolicy.OFFLINE).resize(240, 120).placeholder(R.drawable.gallery_default).into(userimageview, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError() {
                    Picasso.with(c).load(thumb_image).placeholder(R.drawable.gallery_default).into(userimageview);
                }
            });
        }
    }
}
