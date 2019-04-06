package com.example.akshay.PollingApp;


import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.akshay.PollingApp.send_adapter.SendListAdapter;
import  com.example.akshay.PollingApp.send_model.send;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tab2Send extends Fragment {
    DatabaseReference dbrefergroup;
    DatabaseReference dbreferuser;
    String username = LoginActivity.returnemail();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(com.example.akshay.PollingApp.R.layout.tab2send, container, false);

        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(com.example.akshay.PollingApp.R.id.fabsend);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(com.example.akshay.PollingApp.R.id.tab2sendRecyclerView);

        dbreferuser = FirebaseDatabase.getInstance().getReference("User");
        dbrefergroup = FirebaseDatabase.getInstance().getReference("group");
        getData(recyclerView);
    }

    private void getData(RecyclerView recyclerView) {
       final  ArrayList<send> list = new ArrayList<>();




        final SendListAdapter adapter = new SendListAdapter(getContext(), list);

        send poll = new send("Group name");


        dbreferuser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot i :   dataSnapshot.getChildren()){




                    UserDB  userobj = i.getValue(UserDB.class);
                    // Log.d("asdf",userobj.toString());
                    if(userobj.username.equals(username)){
                        for(String str : userobj.listofgroups){

                            send tempgrp = new send(str);


                            list.add(tempgrp);

                            adapter.notifyDataSetChanged();
                        }
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        list.add(poll);
//        list.add(poll);
//        list.add(poll);
//        list.add(poll);
//        list.add(poll);



        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setHasFixedSize(true);
}
}
