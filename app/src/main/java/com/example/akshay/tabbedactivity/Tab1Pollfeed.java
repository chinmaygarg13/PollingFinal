package com.example.akshay.tabbedactivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.akshay.tabbedactivity.R;

import com.example.akshay.tabbedactivity.adapters.OptionListAdapter;
import com.example.akshay.tabbedactivity.adapters.PollListAdapter;
import com.example.akshay.tabbedactivity.model.Opt;
import com.example.akshay.tabbedactivity.model.Poll;

import java.util.ArrayList;
import java.util.List;


public class Tab1Pollfeed extends Fragment {
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1pollfeed, container, false);
        FloatingActionButton fab = rootView.findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddPollPage.class));
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.tab1RecyclerView);


        getData(recyclerView);
    }

    private void getData(RecyclerView recyclerView) {
        ArrayList<Poll> list = new ArrayList<>();
        ArrayList<Opt> opts = new ArrayList<>();
        Opt opt = new Opt(false, "This is an Option");
        opts.add(opt);
        opts.add(opt);

        Poll poll = new Poll("Group name", "Question", opts, "timestamp", "expiry date");
        list.add(poll);
        list.add(poll);
        list.add(poll);
        list.add(poll);
        list.add(poll);

        PollListAdapter adapter = new PollListAdapter(getContext(), list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setHasFixedSize(true);


    }
}
