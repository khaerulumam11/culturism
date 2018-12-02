package com.example.khaerulumam.culturism;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.khaerulumam.culturism.fragment.BelajarFragment;
import com.example.khaerulumam.culturism.fragment.ListLaguDaerah;
import com.example.khaerulumam.culturism.fragment.ListLaguDaerahKalimantan;
import com.example.khaerulumam.culturism.fragment.ListLaguDaerahPapua;

public class LaguDaerah extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;

    private ListLaguDaerah listPilihanBudaya;
//    private ListLaguDaerahSumatera listPilihanBudaya1;
    private ListLaguDaerahKalimantan listPilihanBudaya2;
//    private ListLaguDaerahSulawesi listPilihanBudaya3;
    private ListLaguDaerahPapua listPilihanBudaya4;
//    private QuizFragment quizFragment;
//    private ProfileFragment profileFragment;
    private BelajarFragment belajarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_daerah);

        String nama = getIntent().getStringExtra("judul");
        if (nama.equals("LaguJabar")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List Lagu Daerah Jawa Barat");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            frameLayout = (FrameLayout) findViewById(R.id.mainframe);


            listPilihanBudaya = new ListLaguDaerah();
            belajarFragment = new BelajarFragment();
//            quizFragment = new QuizFragment();
//            profileFragment = new ProfileFragment();

            setFragment(listPilihanBudaya);

        }
        if (nama.equals("LaguKalimantan")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List Lagu Daerah Kalimantan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            listPilihanBudaya2 = new ListLaguDaerahKalimantan();
            belajarFragment = new BelajarFragment();

            setFragment(listPilihanBudaya2);

        }
        if (nama.equals("LaguPapua")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List Lagu Daerah Papua");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            listPilihanBudaya4 = new ListLaguDaerahPapua();
            belajarFragment = new BelajarFragment();

            setFragment(listPilihanBudaya4);


        }
       // displaySelectedScreen(R.id.nav_gallery);
    }

    private void displaySelectedScreen(int itemId) {
        Fragment fragment = null;

        //initializing the fragment object which is selected


        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainframe, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.makanan_daerah, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
