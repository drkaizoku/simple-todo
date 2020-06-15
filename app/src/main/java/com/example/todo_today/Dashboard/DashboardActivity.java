package com.example.todo_today.Dashboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.todo_today.AppInfo.AppInfoActivity;
import com.example.todo_today.AppDetails.AboutActivity;
import com.example.todo_today.AppDetails.ContactActivity;
import com.example.todo_today.AppDetails.ProfileActivity;
import com.example.todo_today.LoginSignup.MainActivity;
import com.example.todo_today.OrmMvvm.MvvmMainActivity;
import com.example.todo_today.R;
import com.example.todo_today.TodoActivity.HomeActivity;
import com.example.todo_today.fragment.FragmentActivity;

public class DashboardActivity extends AppCompatActivity {


    private Button button_add, button_logout, buttonGmail, buttonSettings, buttonOrm, buttonProfile, buttonContact,
            buttonAbout, buttonAppInfo, buttonFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        //add to-do button function..
        this.button_add = (Button) findViewById(R.id.button_add);
        this.button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Add To-dos", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(DashboardActivity.this, HomeActivity.class);
                startActivity(intent1);
            }
        });


        this.button_logout = (Button) findViewById(R.id.button_logout);
        this.button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Do you want to logout ??");
                builder.setPositiveButton("Take me away!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DashboardActivity.this, "Logged out Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);

                        finish();

                    }
                });

                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        //similar apps button function
        this.buttonGmail = (Button) findViewById(R.id.buttonGmail);
        this.buttonGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Logged out Successfully!", Toast.LENGTH_SHORT).show();
                Toast.makeText(DashboardActivity.this, "Opening Gmail.", Toast.LENGTH_SHORT).show();
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                startActivity(intent);
                finish();
            }
        });

        //settings apps button function
        this.buttonSettings = (Button) findViewById(R.id.buttonSettings);
        this.buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Logged out Successfully!", Toast.LENGTH_SHORT).show();
                Toast.makeText(DashboardActivity.this, "Opening Settings.", Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                finish();
            }
        });

        //orm button function..
        this.buttonOrm = (Button) findViewById(R.id.buttonMvvmTodo);
        this.buttonOrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Opening Todo Orm Android Architecture.", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(DashboardActivity.this, MvvmMainActivity.class);
                startActivity(intent1);
            }
        });

        //User Profile button function..
        this.buttonProfile = (Button) findViewById(R.id.buttonProfile);
        this.buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Opening your Profile..", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(intent1);
            }
        });

        //User contact button function..
        this.buttonContact = (Button) findViewById(R.id.buttonContact);
        this.buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DashboardActivity.this, ContactActivity.class);
                startActivity(intent1);
            }
        });

        //User about button function..
        this.buttonAbout = (Button) findViewById(R.id.buttonAbout);
        this.buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DashboardActivity.this, AboutActivity.class);
                startActivity(intent1);
            }
        });

        //fragment activity..
        this.buttonFragments = (Button) findViewById(R.id.buttonFragment);
        this.buttonFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DashboardActivity.this, FragmentActivity.class);
                startActivity(intent1);
            }
        });

        //User AppInfo button function..
        this.buttonAppInfo = (Button) findViewById(R.id.button_app_info);
        this.buttonAppInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "App Info", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(DashboardActivity.this, AppInfoActivity.class);
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
