package com.example.todo_today.TodoActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.todo_today.TodoActivity.entities.Todo;
import com.example.todo_today.TodoActivity.todo_database.*;

import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.*;

import com.example.todo_today.R;

import java.util.regex.Pattern;

public class AddTodoActivity extends AppCompatActivity {

    // custom input pattern
    private static final Pattern CUSTOM_INPUT_PATTERN =
            Pattern.compile("^" +
                    ".{6,200}"  +
                    "$");
//     CUSTOM_INPUT_PATTERN.matcher((CharSequence) editText_title).matches() && CUSTOM_INPUT_PATTERN.matcher((CharSequence) editText_description).matches()

    private Button buttonBack;
    private Button buttonSave;
    private EditText editText_title;
    private EditText editText_description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        //edit text title and description...
        this.editText_title = (EditText) findViewById(R.id.editText_title);
        this.editText_description = (EditText) findViewById(R.id.editText_description);

        //back button Onclick_listener function..
        this.buttonBack = (Button) findViewById(R.id.buttonBack);
        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddTodoActivity.this, "Todo Home Page", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(AddTodoActivity.this, HomeActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        //save button function...
        this.buttonSave = (Button) findViewById(R.id.buttonSave);
        this.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TodoDB todoDB = new TodoDB(getBaseContext());
                Todo todo = new Todo();
                todo.setTitle(editText_title.getText().toString().trim());
                todo.setDescription(editText_description.getText().toString().trim());

                //validation ....
                //Empty fields validation ....
                if(editText_title.getText().toString().isEmpty()) {
                    editText_title.setError("Title Field cannot be empty");
                    Toast.makeText(AddTodoActivity.this, "Title Field is blank", Toast.LENGTH_SHORT).show();
                    return;
                } if(editText_description.getText().toString().isEmpty()) {
                    editText_description.setError("Description Field cannot be empty");
                    Toast.makeText(AddTodoActivity.this, "Description Field is blank", Toast.LENGTH_SHORT).show();
                    return;
                }

//                if(todoDB.create(to-do) && !CUSTOM_INPUT_PATTERN.matcher((CharSequence) editText_title).matches() && !CUSTOM_INPUT_PATTERN.matcher((CharSequence) editText_description).matches() ){
////                    Toast.makeText(AddTodoActivity.this, "Failed to add to-do", Toast.LENGTH_SHORT).show();
////                    Intent intent1 = new Intent(AddTodoActivity.this, HomeActivity.class);
////                    startActivity(intent1);
////                }


                 if(todoDB.create(todo)){
                    Toast.makeText(AddTodoActivity.this, "New Todo Added", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(AddTodoActivity.this, HomeActivity.class);
                    startActivity(intent1);
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Failed to Add Todo!!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {

                            dialogInterface.cancel();
                        }
                    });
                    builder.create().show();
                }
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
