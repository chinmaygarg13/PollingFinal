package com.example.akshay.tabbedactivity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.akshay.tabbedactivity.group_adapter.GroupListAdapter;
import com.example.akshay.tabbedactivity.group_model.Group;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Tab2Groups extends Fragment {
    public interface OnFragmentInteractionListener{
        public void onFragmentInteraction(Uri uri);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2groups, container, false);

        return rootView;
    }
    @Override
    public  void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.tab2groupRecyclerView);
        getData(recyclerView);

    }

    private void getData(RecyclerView recyclerView){
        ArrayList<Group> list = new ArrayList<>();
        Group group = new Group("Group Name");

        list.add(group);
        list.add(group);
        list.add(group);
        list.add(group);
        list.add(group);


        GroupListAdapter adapter = new GroupListAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

    }
}
