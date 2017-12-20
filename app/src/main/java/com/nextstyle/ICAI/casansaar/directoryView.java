package com.nextstyle.ICAI.casansaar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class directoryView extends Fragment {

    RecyclerView directoryList;
    private DatabaseReference mdatabase;
    FirebaseRecyclerAdapter<DTO,Committee.user_view_holder> firebaseRecyclerAdapter;
    String myValue="";

    public directoryView() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_directory_view, container, false);
        myValue=this.getArguments().getString("arg");
        mdatabase= FirebaseDatabase.getInstance().getReference().child("Committee");
        directoryList=view.findViewById(R.id.directory_list);
        directoryList.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<DTO, Committee.user_view_holder>(DTO.class,
                R.layout.user_single_layout,
                Committee.user_view_holder.class,
                mdatabase.orderByChild("Name").startAt(myValue).endAt(myValue+"\uf8ff")) {
            @Override
            public long getItemId(int position) {
                return super.getItemId(position);
            }

            @Override
            protected void populateViewHolder(Committee.user_view_holder viewHolder, DTO model, int position) {

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
                        profile_intent.putExtra("type","Committee");
                        startActivity(profile_intent);
                    }
                });
            }
        };

        firebaseRecyclerAdapter.setHasStableIds(true);
        firebaseRecyclerAdapter.notifyDataSetChanged();

        directoryList.setAdapter(firebaseRecyclerAdapter);
    }

}
