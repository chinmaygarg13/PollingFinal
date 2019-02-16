package com.example.akshay.tabbedactivity;


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

import com.example.akshay.tabbedactivity.send_adapter.SendListAdapter;
import  com.example.akshay.tabbedactivity.send_model.send;
import java.util.ArrayList;
import java.util.List;

public class Tab2Send extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2send, container, false);

        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fabsend);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.tab2sendRecyclerView);


        getData(recyclerView);
    }

    private void getData(RecyclerView recyclerView) {
        ArrayList<send> list = new ArrayList<>();





        send poll = new send("Group name");
        list.add(poll);
        list.add(poll);
        list.add(poll);
        list.add(poll);
        list.add(poll);


        SendListAdapter adapter = new SendListAdapter(getContext(), list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setHasFixedSize(true);
}
}
