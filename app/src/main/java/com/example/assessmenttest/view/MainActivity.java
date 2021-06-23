package com.example.assessmenttest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.TextView;

import com.example.assessmenttest.R;
import com.example.assessmenttest.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    ActivityMainBinding mainBinding;
    private TextView title;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

       /*  toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       title = findViewById(R.id.toolbar_title);
        title.setText("test abc");*/

     //   getSupportActionBar().setDisplayShowHomeEnabled(true);

        BottomNavigationView navView = mainBinding.navView;
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);


     //   https://stackoverflow.com/questions/27100007/set-a-title-in-toolbar-from-fragment-in-android/64054238

    }
}