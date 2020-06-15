package com.example.todo_today.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todo_today.R;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    //password pattern
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=\\S+$)" +           //no white spaces
                    ".{5,}" +               //at least 5 characters
                    "$");


    //adding database helper..
    DatabaseHelper db;

    //using and calling edit-text, button and text-view
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    EditText mTextEmail;
    EditText mTextFullName;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //using database...
        db = new DatabaseHelper(this);



        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextEmail = (EditText) findViewById(R.id.edittext_email);
        mTextFullName = (EditText) findViewById(R.id.edittext_full_name);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText) findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(LoginIntent);
            }
        });

        //function to register user after clicking register button...
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = mTextUsername.getText().toString().trim();
                String email = mTextEmail.getText().toString().trim();
                String fullname = mTextFullName.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                //empty fields validation...

                if (TextUtils.isEmpty(fullname)) {
                    mTextFullName.setError("Name Field cannot be blank");
                    Toast.makeText(RegisterActivity.this, "Name field is blank. ", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mTextEmail.setError("Please enter a valid email address.");
                    return;
                }  else if (TextUtils.isEmpty(user)) {
                    mTextUsername.setError("Username Field cannot be blank");
                    Toast.makeText(RegisterActivity.this, "Username field is blank. ", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(email)) {
                    mTextEmail.setError("Email Field cannot be blank");
                    Toast.makeText(RegisterActivity.this, "Email field is blank. ", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(pwd)) {
                    mTextPassword.setError("Password Field cannot be blank");
                    Toast.makeText(RegisterActivity.this, "Password field is blank. ", Toast.LENGTH_SHORT).show();
                    return;
                }  else if (TextUtils.isEmpty(cnf_pwd)) {
                    mTextCnfPassword.setError("Cnf-Password Field cannot be blank");
                    Toast.makeText(RegisterActivity.this, "Cnf_Password field is blank. ", Toast.LENGTH_SHORT).show();
                    return;
                }

                //checking password and confirm password fields...
                if (pwd.equals(cnf_pwd)) {

                    long val = db.addUser(user, email, pwd, fullname); //adding user and passing the parameter...

                    //checking user password before adding...
                    if (val > 0 && PASSWORD_PATTERN.matcher(pwd).matches() ) {

                        Toast.makeText(RegisterActivity.this, "Successfully Registered!!", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(moveToLogin);
                    } else if (val > 0 && !PASSWORD_PATTERN.matcher(pwd).matches()) {
                        mTextPassword.setError("Password is too weak (no white space at least 5 char)");
                        mTextCnfPassword.setError("Password is too weak (no white space at least 5 char)");

                    } else {

                        Toast.makeText(RegisterActivity.this, "Error in Registration!!", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    mTextPassword.setError("Password do not match! ");
                    mTextCnfPassword.setError("Password do not match!");
                    Toast.makeText(RegisterActivity.this, "Both Password fields Should match!!", Toast.LENGTH_SHORT).show();
                }

            } //ends public void onClick(View view)
        }); // ends  mButtonRegister.setOnClickListener(new View.OnClickListener()
    }

    //life cycle components

    protected void onStart() {
        super.onStart();
        Log.i("testlifecycle", "on create event");
    }

    protected void onResume() {
        super.onResume();
        Log.i("testlifecycle", "on resume event");
    }

    protected void onPause() {
        super.onPause();
        Log.i("testlifecycle", "on pause event");
    }

    protected void onStop() {
        super.onStop();
        Log.i("testlifecycle", "on stop event");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("testlifecycle", "on destroy event");
    }
}
