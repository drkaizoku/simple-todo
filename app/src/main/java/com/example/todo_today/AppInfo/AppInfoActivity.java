package com.example.todo_today.AppInfo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo_today.AppInfo.model.AppListItem;
import com.example.todo_today.AppInfo.view.AppInfoAdapter;
import com.example.todo_today.R;

import java.util.ArrayList;
import java.util.List;

//setting adapter to recyclerView..
public class AppInfoActivity extends AppCompatActivity {

    //a list to store all the products
    private List<AppListItem> listItemList;

    //the recyclerview
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the app info list
        listItemList = new ArrayList<>();

        listItemList.add(
                new AppListItem(
                        "App Name","Todo Today"
                ));

        listItemList.add(
                new AppListItem(
                        "Version","2.0"
                ));
        listItemList.add(
                new AppListItem("Developer","Sujan Aryal")
        );
        listItemList.add(
                new AppListItem("App Signature","Todo Today All Rights Reserved")
        );
        listItemList.add(
                new AppListItem("App Feature","Add Daily Todo and with Beautiful Design")
        );


        //creating recyclerview adapter
        AppInfoAdapter adapter = new AppInfoAdapter(listItemList, this);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);


    }
}
