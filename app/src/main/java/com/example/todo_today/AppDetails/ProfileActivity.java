package com.example.todo_today.AppDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.todo_today.LoginSignup.DatabaseHelper;
import com.example.todo_today.R;

public class ProfileActivity extends AppCompatActivity {

    private Button buttonContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //object of database helper class.
        DatabaseHelper DbHelper = new DatabaseHelper(this);

        //getting text view
        TextView  textView = findViewById(R.id.username);

        //creating cursor object and calling method..
        //returns entire data from database..
        Cursor cursor = DbHelper.ViewData();

        //creating string builder..
        StringBuilder stringBuilder = new StringBuilder();

        //while loop
        //calling cursor object.. calling method move to next
        //run till there is data in cursor..
        while (cursor.moveToNext()) {

//            stringBuilder.append("\nFull Name : " + cursor.getString(4) + "\nUser Name : " + cursor.getString(1) + "\nEmail : " + cursor.getString(3));
            stringBuilder.append("@" + cursor.getString(1) + "\n");
           //showing string builder in text-view ..
            textView.setText(stringBuilder);
        }

        //add to-do button function..
        this.buttonContact = (Button) findViewById(R.id.buttonContact);
        this.buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ProfileActivity.this, ContactActivity.class);
                startActivity(intent1);
            }
        });

    }
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
