package com.example.fluxitdemo.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fluxitdemo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment selectedFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setview();
    }


    private void setview() {
        selectedFragment = new SearchFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.main_activity_fragment_container, selectedFragment).commit();

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_search:
                        selectedFragment = new SearchFragment();
                }

                switch (menuItem.getItemId()) {
                    case R.id.navigation_favourites:
                        selectedFragment = new FavouritesFragment();
                }

                switch (menuItem.getItemId()) {
                    case R.id.navigation_publish:
                        selectedFragment = new PublishFragment();
                }

                switch (menuItem.getItemId()) {
                    case R.id.navigation_notifications:
                        selectedFragment = new NotificationsFragment();
                }

                switch (menuItem.getItemId()) {
                    case R.id.navigation_menu:
                        selectedFragment = new MenuFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_fragment_container, selectedFragment).commit();
                return true;
            }
        });

    }
}
