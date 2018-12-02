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

import com.example.khaerulumam.culturism.Jabar.DeskBeskap;
import com.example.khaerulumam.culturism.Jabar.DeskKebaya;
import com.example.khaerulumam.culturism.Jabar.DeskPangsi;
import com.example.khaerulumam.culturism.Kalimantan.DeskKing;
import com.example.khaerulumam.culturism.Kalimantan.DeskSangkarut;
import com.example.khaerulumam.culturism.Kalimantan.DeskSapei;
import com.example.khaerulumam.culturism.Papua.DeskKoteka;
import com.example.khaerulumam.culturism.Papua.DeskRumbai;
import com.example.khaerulumam.culturism.Papua.DeskYokal;
import com.example.khaerulumam.culturism.fragment.BelajarFragment;

public class DeskripsiPakaian extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;

    private DeskBeskap deskMakananDaerah;
    private DeskKebaya deskMakananDaerah1;
    private DeskPangsi deskMakananDaerah2;
    private DeskSangkarut deskMakananDaerah3;
    private DeskKing deskMakananDaerah4;
    private DeskSapei deskMakananDaerah5;
    private DeskRumbai deskMakananDaerah6;
    private DeskYokal deskMakananDaerah7;
    private DeskKoteka deskMakananDaerah8;
    private BelajarFragment belajarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_makanan);
        String nama = getIntent().getStringExtra("id");

        if (nama.equals("beskap")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Beskap");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah = new DeskBeskap();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiPakaian.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiPakaian.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("kebaya")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Kebaya Sunda");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah1 = new DeskKebaya();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah1);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiPakaian.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiPakaian.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("pangsi")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Pangsi");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah2 = new DeskPangsi();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah2);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiPakaian.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiPakaian.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("sangkarut")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Baju Sangkarut");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah3 = new DeskSangkarut();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah3);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiPakaian.this,Home.class);
                            startActivity(intent);
                            return true;


                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("kingbaba")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("King baba dan King bibinge");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah4 = new DeskKing();
            belajarFragment = new BelajarFragment();


            setFragment(deskMakananDaerah4);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiPakaian.this,Home.class);
                            startActivity(intent);
                            return true;


                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("sapei")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Sapei Sapaq");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah5 = new DeskSapei();
            belajarFragment = new BelajarFragment();


            setFragment(deskMakananDaerah5);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiPakaian.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("rumbai")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Rok Rumbai Papua");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah6 = new DeskRumbai();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah6);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiPakaian.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("yokal")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Yokal");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah7 = new DeskYokal();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah7);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiPakaian.this,Home.class);
                            startActivity(intent);
                            return true;
                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("koteka")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Koteka");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah8 = new DeskKoteka();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah8);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiPakaian.this,Home.class);
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
