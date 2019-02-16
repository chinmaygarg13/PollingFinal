package com.example.akshay.tabbedactivity.send_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshay.tabbedactivity.send_model.send;
import com.example.akshay.tabbedactivity.R;

import java.util.ArrayList;

public class SendListAdapter extends RecyclerView.Adapter<SendListAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<send> list;

    public SendListAdapter(Context context, ArrayList<send> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.send_list_card, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        send poll = list.get(i);
        holder.groupname.setText(poll.getGroupName());

        final int index = i;

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView groupname;
        ImageView avatar;
        CheckBox cb;

        MyViewHolder(@NonNull View view) {
            super(view);

            groupname = view.findViewById(R.id.groupName);
            avatar = view.findViewById(R.id.image);
            cb = view.findViewById(R.id.checkBox);
        }
    }
}
