package com.example.todo_today.LoginSignup;

//imports
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todo_today.Dashboard.DashboardActivity;
import com.example.todo_today.R;
import com.example.todo_today.mvvm.AdminLoginActivity;

public class MainActivity extends AppCompatActivity {

    //using and calling edit-text, button and text-view
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("testlifecycle", "on create event" );

        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mTextViewRegister = (TextView) findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerIntent);

            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get username and password in string...
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);


                //empty fields validation...
                if(TextUtils.isEmpty(user)) {
                    mTextUsername.setError("Username Field cannot be blank");
                    Toast.makeText( MainActivity.this, "User name field is blank. ", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(pwd)) {
                    mTextPassword.setError("Password Field cannot be blank");
                    Toast.makeText( MainActivity.this, "Password field is blank. ", Toast.LENGTH_SHORT).show();
                    return;
                }


                //notifying user through toast message
                if(res == true)
                {
                    Toast.makeText(MainActivity.this, "You are Successfully LoggedIn", Toast.LENGTH_SHORT).show();
                    Intent HomePage = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(HomePage);
                }
                //for admin login
                else if(mTextUsername.getText().toString().equals("admin@user") && mTextPassword.getText().toString().equals("@user123")) {

                    Toast.makeText(MainActivity.this, "Welcome Admin, Good Day.", Toast.LENGTH_SHORT).show();
                    Intent AdminPage = new Intent(MainActivity.this, AdminLoginActivity.class);
                    startActivity(AdminPage);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Error!!", Toast.LENGTH_SHORT).show();
                }
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
