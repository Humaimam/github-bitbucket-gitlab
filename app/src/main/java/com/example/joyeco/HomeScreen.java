package com.example.joyeco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeScreen extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    public Fragment fragment;
    public Class fragmentClass;
   // AnimatedExpandableListView listView;
    private static int[] imgs = { R.drawable.ic_schedule_icon,R.drawable.ic_jobs_icon,R.drawable.ic_earnings_icon,
            R.drawable.ic_location_icon ,R.drawable.ic_schedule_icon,R.drawable.ic_jobs_icon,R.drawable.ic_earnings_icon,
            R.drawable.ic_location_icon ,R.drawable.ic_schedule_icon,R.drawable.ic_jobs_icon,R.drawable.ic_earnings_icon,
            R.drawable.ic_location_icon , };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        ImageButton openDrawerMenu = (ImageButton) findViewById(R.id.openDrawerMenu);
        openDrawerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.openDrawer(GravityCompat.START);
                else drawerLayout.closeDrawer(GravityCompat.END);

            }
        });
        setDrawerContent(navigationView);
        try {
            fragment = null;
            fragmentClass = home.class;
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frageContent,fragment).commit();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void setDrawerContent(final NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectedItemDrawer(menuItem);
                return true;
            }
        });
}

    public void selectedItemDrawer(MenuItem menuItem){
        fragment = null;
        boolean close = true;
        switch (menuItem.getItemId()){
            case R.id.home:
                fragmentClass = home.class;
                break;
            case R.id.setting:
                fragmentClass = setting.class;
                break;
            case R.id.FAQ:
                fragmentClass = FAQ.class;
                break;
            case R.id.logout:
                preferenceUtils.save(null,"token",this);
                close = false;
                Intent intent = new Intent(HomeScreen.this,MainActivity.class);
                startActivity(intent);
                break;
            default:
                fragmentClass = home.class;
        }
            try {
                fragment = (Fragment) fragmentClass.newInstance();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frageContent,fragment).commit();
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        if(close == true)
            drawerLayout.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}