package com.example.akshay.PollingApp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
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

import com.example.akshay.PollingApp.adapters.PollListAdapter;
import com.example.akshay.PollingApp.group_model.Group;
import com.example.akshay.PollingApp.model.Opt;
import com.example.akshay.PollingApp.model.Poll;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.UnknownServiceException;
import java.util.ArrayList;


public class Tab1Pollfeed extends Fragment {
    String currentuser;
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }
    String userid = LoginActivity.returnemail();
    DatabaseReference dbrefergroup;
    DatabaseReference dbreferuser;
    static  ArrayList<String> listofgroups = new ArrayList<>();

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

        dbrefergroup = FirebaseDatabase.getInstance().getReference("group");
        dbreferuser = FirebaseDatabase.getInstance().getReference("User");
        getData(recyclerView);
    }

    private void getData(RecyclerView recyclerView) {
        final ArrayList<Poll> list = new ArrayList<>();
        final ArrayList<Opt> opts = new ArrayList<>();
        final Opt opt = new Opt(false, "This is an Option");
        opts.add(opt);
        opts.add(opt);
        opts.add(opt);


//        Poll poll = new Poll("Group name", "Question", opts, "timestamp", "expiry date");
//
//        final String groupname = "CS321";
//        final ArrayList<String> listofusers = new ArrayList<>();
//        ArrayList<String> listofoptions = new ArrayList<>();
//        listofoptions.add("dubai");
//        listofoptions.add("india");
//        listofoptions.add("japan");
//        listofoptions.add("america");
//        listofusers.add("malav2");
//        listofusers.add("garg2");
//
//        PollDB poll = new PollDB("malav.2", "Which is the highest building in the world ",listofoptions,"10:00 pm","11:00 pm" );
//        ArrayList<PollDB> polllist = new ArrayList<>();
//        polllist.add(poll);
////        for(int it=0;it<polllist.size();it++){
////            Log.d("aajabeta", polllist.get(it).listofoptions.get(0));
////        }
//        ArrayList<String> listofoptions1 = new ArrayList<>();
//
//        listofoptions1.add("china");
//        listofoptions1.add("iran");
//        listofoptions1.add("israel");
//        listofoptions1.add("canada");
//        PollDB poll2 = new PollDB("garg.2", "Which is the highest building in the world ",listofoptions1,"10:00 pm","11:00 pm" );
//        polllist.add(poll2);
//
////        for(int it=0;it<polllist.size();it++){
////            Log.d("aajabeta", polllist.get(it).listofoptions.get(0));
////        }
//
//
//
//        GroupDB group = new GroupDB(groupname,listofusers,polllist);
//        dbrefer.child(groupname).setValue(group);
//
//        String groupname1 = "HS311";
//        GroupDB group1 = new GroupDB(groupname1,listofusers,polllist);
//        dbrefer.child(groupname1).setValue(group1);
//
//        String groupname2 = "CS322";
//        GroupDB group2 = new GroupDB(groupname1,listofusers,polllist);
//        dbrefer.child(groupname2).setValue(group2);
//
//        String groupname3 = "MA312";
//        GroupDB group3 = new GroupDB(groupname3,listofusers,polllist);
//        dbrefer.child(groupname3).setValue(group3);




        final PollListAdapter adapter = new PollListAdapter(getContext(), list);
        dbreferuser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot i :  dataSnapshot.getChildren()){
                        UserDB userobj =  i.getValue(UserDB.class);



                        if(userobj.username.equals(userid)){

                            listofgroups = userobj.listofgroups;
                        }
                    }

                dbrefergroup.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for(DataSnapshot i : dataSnapshot.getChildren()){
                            GroupDB groudb = i.getValue(GroupDB.class);
                            for(int var=0;var<listofgroups.size();var++){

                                if(groudb.gid.equals(listofgroups.get(var))) {
                                    Log.d("ramukaka", "onDataChange: "+listofgroups.toString());
                                    for (int it = 0; it < groudb.listofpolls.size(); it++) {
                                        ArrayList<Opt> optionlist = new ArrayList<>();
                                        for (int it1 = 0; it1 < groudb.listofpolls.get(it).listofoptions.size(); it1++) {
                                            Opt optn = new Opt(false, groudb.listofpolls.get(it).listofoptions.get(it1));
                                            optionlist.add(optn);
                                        }
                                        Poll temppoll = new Poll(groudb.gid, groudb.listofpolls.get(it).Questions, optionlist, groudb.listofpolls.get(it).Askedtime, groudb.listofpolls.get(it).Expirytime, groudb.listofpolls.get(it).Asker);
                                       if(!list.contains(temppoll))
                                        list.add(temppoll);
                                        adapter.notifyDataSetChanged();
                                    }
                                }

                            }

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
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
    public  static  ArrayList<String> getListofgroups(){
        return listofgroups;
    }
}
