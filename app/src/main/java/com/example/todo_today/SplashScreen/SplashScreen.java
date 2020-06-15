package com.example.todo_today.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.todo_today.R;

public class SplashScreen extends AppCompatActivity {

    ProgressBar progressBar;
    TextView loading_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progress_bar);
        loading_view = findViewById(R.id.loading_view);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);


        progressAnimation();
    }

    public void progressAnimation() {

        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, loading_view, 0f, 100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);


    }
}
