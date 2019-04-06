package com.example.akshay.PollingApp.group_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.akshay.PollingApp.R;
import com.example.akshay.PollingApp.group_model.Group;

import java.util.ArrayList;

public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.MyViewHolder> {

    private Context  context;
    private ArrayList<Group> list;

    public GroupListAdapter(Context context,ArrayList<Group>list){
        this.context = context;
        this.list=list;
    }

    @Override
    public  MyViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View view = LayoutInflater.from(context).inflate(R.layout.group_list_card, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int i){
        Group  group =  list.get(i);

        holder.groupname.setText(group.getGroupname());
    }
    @Override
    public  int getItemCount(){
        return list.size();
    }
class MyViewHolder extends RecyclerView.ViewHolder{
    TextView groupname;
    ImageView avatar, delete;

    MyViewHolder (View view){
        super(view);

        groupname = view.findViewById(R.id.groupName);
        avatar = view.findViewById(R.id.image);
        delete = view.findViewById(R.id.deleteImage);
    }

}
}
