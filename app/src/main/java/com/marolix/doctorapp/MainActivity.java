package com.marolix.doctorapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.marolix.doctorapp.fragment.AccountFragment;
import com.marolix.doctorapp.fragment.HomeFragment;
import com.marolix.doctorapp.fragment.RemindersFragment;
import com.marolix.doctorapp.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Fragment fragment;
    private FragmentManager fragmentManager;


    private BottomNavigationView mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Constants.checkPermission(MainActivity.this)){

        } else {
            Constants.requestPermission(MainActivity.this);
        }
        mTextMessage = (TextView) findViewById(R.id.message);
        mBottomNavigation = (BottomNavigationView) findViewById(R.id.navigation);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();
        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menu) {
                int menuItem = menu.getItemId();
                if (menuItem == R.id.action_account) {
                    fragment = new AccountFragment();
                } else if (menuItem == R.id.action_home) {
                    fragment = new HomeFragment();
                } else if (menuItem == R.id.action_orders) {
                    fragment = new RemindersFragment();
                }
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                return true;
            }
        });
    }

}
