package com.example.todo_today.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;

import com.example.todo_today.R;
import com.example.todo_today.databinding.ActivityAdminLoginBinding;
import com.example.todo_today.mvvm.model.User;
import com.example.todo_today.mvvm.viewmodel.UserViewModel;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAdminLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_admin_login);

        //userview model initializing

        UserViewModel userViewModel = ViewModelProviders.of(this,new  UserViewModelFactory(this, new User())).get(UserViewModel.class);

        binding.setUserModel(userViewModel);
    }
}
