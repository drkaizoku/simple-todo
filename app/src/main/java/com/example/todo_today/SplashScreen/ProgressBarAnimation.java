package com.example.todo_today.SplashScreen;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.todo_today.LoginSignup.MainActivity;


//function for progressbar animation loading animation....
public class ProgressBarAnimation extends Animation {

    private Context context;
    private ProgressBar progressBar;
    private TextView loading_view;
    private float from;
    private float to;

    public ProgressBarAnimation(Context context, ProgressBar progressBar, TextView loading_view, float from, float to) {

        this.context = context;
        this.progressBar = progressBar;
        this.loading_view = loading_view;
        this.from = from;
        this.to = to;

    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);
        loading_view.setText((int) value + "%");


        if (value == to) {
            context.startActivity(new Intent(context, MainActivity.class));
        }

    }

}
