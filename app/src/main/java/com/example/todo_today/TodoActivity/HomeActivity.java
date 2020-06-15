package com.example.todo_today.TodoActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.todo_today.TodoActivity.adapters.TodoListAdapter;
import com.example.todo_today.TodoActivity.entities.Todo;
import com.example.todo_today.TodoActivity.todo_database.*;

import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.*;

import com.example.todo_today.Dashboard.DashboardActivity;
import com.example.todo_today.R;


public class HomeActivity extends AppCompatActivity {

    private ListView listview_todo;
    TodoDB todoDB;
    private Button buttonBack;
    private Button button_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //logout button function
        this.buttonBack = (Button) findViewById(R.id.buttonBack);
        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HomeActivity.this, DashboardActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        //add to-do button function..
        this.button_add = (Button) findViewById(R.id.button_add);
        this.button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Add To-dos", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, AddTodoActivity.class);
                startActivity(intent1);
            }
        });

        //list view of to-do from database..
        todoDB = new TodoDB(this);
        this.listview_todo = (ListView) findViewById(R.id.listview_todo);
        TextView empty=(TextView)findViewById(R.id.empty);
        listview_todo.setEmptyView(empty);
        this.listview_todo.setAdapter(new TodoListAdapter(this, todoDB.findAll()));
        this.listview_todo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Todo todo = todoDB.findAll().get(i);
                Intent intent1 = new Intent(HomeActivity.this, TodoDetailActivity.class);
                intent1.putExtra("todo", todo);
                startActivity(intent1);
            }
        });
    }

    //life cycle components

    protected void onStart(){
        super.onStart();
        Log.i("testlifecycle", "on create event" );
    }

    protected void onResume(){
        super.onResume();
        Log.i("testlifecycle", "on resume event" );
    }

    protected void onPause(){
        super.onPause();
        Log.i("testlifecycle", "on pause event" );
    }

    protected void onStop(){
        super.onStop();
        Log.i("testlifecycle", "on stop event" );
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i("testlifecycle", "on destroy event" );
    }
}
