package com.example.fluxitdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.fluxitdemo.R;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private Fragment selectedFragment;
    private SearchFragment searchFragment;
    private FavouritesFragment favouritesFragment;
    private PublishFragment publishFragment;
    private NotificationsFragment notificationsFragment;
    private MenuFragment menuFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchFragment = new SearchFragment();
        favouritesFragment = new FavouritesFragment();
        publishFragment = new PublishFragment();
        notificationsFragment = new NotificationsFragment();
        menuFragment = new MenuFragment();

        tabLayout = findViewById(R.id.tabLayout);


        setview();
    }


    private void setview() {

        getSupportFragmentManager().beginTransaction().add(R.id.main_activity_fragment_container, searchFragment).commit();

        setBottomTabLayout();
    }

    private void setBottomTabLayout() {

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        selectedFragment = searchFragment;
                        break;

                    case 1:
                        selectedFragment = favouritesFragment;
                        break;

                    case 2:
                        selectedFragment = publishFragment;
                        break;

                    case 3:
                        selectedFragment = notificationsFragment;
                        break;

                    case 4:
                        selectedFragment = menuFragment;
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_fragment_container, selectedFragment).addToBackStack(null).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
