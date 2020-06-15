package com.example.todo_today.AppInfo.view;
//recycler view adapter class

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todo_today.AppInfo.model.AppListItem;
import com.example.todo_today.R;

import java.util.List;

public class AppInfoAdapter extends RecyclerView.Adapter<AppInfoAdapter.ViewHolder>{

    //we are storing all the products in a list
    private List<AppListItem> listItemList;

    //this context we will use to inflate the layout
    private Context context;


    //getting the context and product list with constructor
    public AppInfoAdapter(List<AppListItem> listItemList, Context context) {
        this.listItemList = listItemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //getting the item of the specified position
        final AppListItem listItem = listItemList.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,listItem.getHead(),Toast.LENGTH_SHORT).show();
                Toast.makeText(context,listItem.getDesc(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead,textViewDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView)itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView)itemView.findViewById(R.id.textViewDes);
        }
    }
}
