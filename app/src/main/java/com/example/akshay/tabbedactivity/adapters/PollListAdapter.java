package com.example.akshay.tabbedactivity.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshay.tabbedactivity.R;
import com.example.akshay.tabbedactivity.model.Opt;
import com.example.akshay.tabbedactivity.model.Poll;

import java.util.ArrayList;

public class PollListAdapter extends RecyclerView.Adapter<PollListAdapter.MyViewHolder> {

    public Context context;
    private ArrayList<Poll> list;

    public PollListAdapter(Context context, ArrayList<Poll> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.poll_list_card, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        Poll poll = list.get(i);
        holder.groupname.setText(poll.getGroupName());

        final int index = i;
        holder.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "OnClick " + index, Toast.LENGTH_SHORT).show();
            }
        });

        OptionListAdapter adapter = new OptionListAdapter(context, poll.getOptions());
        holder.recyclerView.setAdapter(adapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView groupname;
        ImageView avatar, delete;
        RecyclerView recyclerView;

        MyViewHolder(@NonNull View view) {
            super(view);

            groupname = view.findViewById(R.id.groupName);
            avatar = view.findViewById(R.id.image);
            delete = view.findViewById(R.id.deleteImage);
            recyclerView = view.findViewById(R.id.option_recycleview);
        }
    }

    public Context getContext() {
        return context;
    }
}
