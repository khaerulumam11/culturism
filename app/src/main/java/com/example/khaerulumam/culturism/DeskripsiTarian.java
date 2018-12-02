package com.example.khaerulumam.culturism;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.khaerulumam.culturism.Jabar.DeskTarianDaerah;
import com.example.khaerulumam.culturism.Jabar.DeskTopeng;
import com.example.khaerulumam.culturism.Kalimantan.DeskTariGantar;
import com.example.khaerulumam.culturism.Kalimantan.DeskTariLeleng;
import com.example.khaerulumam.culturism.Papua.DeskTariSajojo;
import com.example.khaerulumam.culturism.Papua.DeskTariYospan;
import com.example.khaerulumam.culturism.fragment.BelajarFragment;
public class DeskripsiTarian extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;

    private DeskTarianDaerah deskMakananDaerah;
    private DeskTopeng deskMakananDaerah1;
    private DeskTariLeleng deskMakananDaerah2;
    private DeskTariGantar deskMakananDaerah3;
    private DeskTariSajojo deskMakananDaerah4;
    private DeskTariYospan deskMakananDaerah5;
    private BelajarFragment belajarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_makanan);

        String nama = getIntent().getStringExtra("id");

        if (nama.equals("merak")) {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Tari Merak");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah = new DeskTarianDaerah();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiTarian.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiTarian.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("topeng")) {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Tari Topeng");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah1 = new DeskTopeng();
            belajarFragment = new BelajarFragment();


            setFragment(deskMakananDaerah1);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiTarian.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiTarian.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("leleng")) {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Tari Leleng");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah2 = new DeskTariLeleng();
            belajarFragment = new BelajarFragment();


            setFragment(deskMakananDaerah2);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiTarian.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("gantar")) {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Tari Gantar");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah3 = new DeskTariGantar();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah3);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiTarian.this,Home.class);
                            startActivity(intent);
                            return true;


                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("sajojo")) {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Tari Sajojo");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah4 = new DeskTariSajojo();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah4);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiTarian.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("yospan")) {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Tari Yospan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah5 = new DeskTariYospan();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah5);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiTarian.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();
    }
}
