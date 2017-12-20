package com.nextstyle.ICAI.casansaar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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


public class Event extends Fragment {
    RecyclerView eventsList;
    private DatabaseReference mdatabase;
    FirebaseRecyclerAdapter<DTO,user_view_holder> firebaseRecyclerAdapter;

    public Event() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_event, container, false);
        mdatabase= FirebaseDatabase.getInstance().getReference().child("Events");
        eventsList=view.findViewById(R.id.events_list);
        eventsList.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<DTO, user_view_holder>(DTO.class,
                R.layout.single_event,
                user_view_holder.class,
                mdatabase) {
            @Override
            public long getItemId(int position) {
                return super.getItemId(position);
            }

            @Override
            protected void populateViewHolder(user_view_holder viewHolder, DTO model, int position) {

                viewHolder.setDate(model.getDate());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setTime(model.getTime());
                viewHolder.setLocation(model.getLocation());

//                final String uid=getRef(position).getKey();
//                viewHolder.mview.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent profile_intent = new Intent(getActivity(), profile_activity.class);
//                        profile_intent.putExtra("uid", uid);
//                        profile_intent.putExtra("type","Committee");
//                        startActivity(profile_intent);
//                    }
//                });
            }
        };

        firebaseRecyclerAdapter.setHasStableIds(true);
        firebaseRecyclerAdapter.notifyDataSetChanged();

        eventsList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class  user_view_holder extends RecyclerView.ViewHolder{
        View mview;


        public user_view_holder(View itemView) {
            super(itemView);
            mview=itemView;
        }
        public  void setTitle(String title)
        {
            TextView mTitle=mview.findViewById(R.id.event_title);
            mTitle.setText(title);
        }
        public  void setDate(String date)
        {
            TextView mDate=mview.findViewById(R.id.event_date);
            mDate.setText(date);
        }

        public  void setTime(String time)
        {
            TextView mTime=mview.findViewById(R.id.event_time);
            mTime.setText(time);
        }
        public  void setLocation(String location)
        {
            TextView mLocation=mview.findViewById(R.id.event_location);
            mLocation.setText(location);
        }
    }
}
