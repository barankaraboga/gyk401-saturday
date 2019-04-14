package com.denemebaran2.baran.idealsey.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.denemebaran2.baran.idealsey.R;
import com.denemebaran2.baran.idealsey.fragments.DietFragment;
import com.denemebaran2.baran.idealsey.fragments.HealthFragment;
import com.denemebaran2.baran.idealsey.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // buraya dönücez
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);

        FragmentTransaction transaction = getSupportFragmentManager()
                                                    .beginTransaction();
         // hangi frame üstünde fragmentler haraket edecek onu tanımladık.
        transaction.replace(R.id.frameLayout,new HomeFragment());
        transaction.commit();
    }

    private
    BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_health:
                    selectedFragment = new HealthFragment();
                    break;
                case R.id.nav_diet:
                    selectedFragment = new DietFragment();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager()
                                                            .beginTransaction();
            transaction.replace(R.id.frameLayout,selectedFragment);
            transaction.commit();
            return true;
        }
    };
}
