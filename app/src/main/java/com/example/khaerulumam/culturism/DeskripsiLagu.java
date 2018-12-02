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

import com.example.khaerulumam.culturism.Jabar.DeskEsLilin;
import com.example.khaerulumam.culturism.Jabar.DeskLaguDaerah;
import com.example.khaerulumam.culturism.Jabar.DeskManukDadali;
import com.example.khaerulumam.culturism.Kalimantan.DeskBadindangRia;
import com.example.khaerulumam.culturism.Kalimantan.DeskCikPeriok;
import com.example.khaerulumam.culturism.Kalimantan.DeskIndungIndung;
import com.example.khaerulumam.culturism.Papua.DeskApuse;
import com.example.khaerulumam.culturism.Papua.DeskSajojo;
import com.example.khaerulumam.culturism.Papua.DeskYamko;
import com.example.khaerulumam.culturism.fragment.BelajarFragment;

public class DeskripsiLagu extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;

    private DeskLaguDaerah deskMakananDaerah;
    private DeskManukDadali deskMakananDaerah1;
    private DeskEsLilin deskMakananDaerah2;
    private DeskIndungIndung deskMakananDaerah3;
    private DeskCikPeriok deskMakananDaerah4;
    private DeskBadindangRia deskMakananDaerah5;
    private DeskApuse deskMakananDaerah6;
    private DeskSajojo deskMakananDaerah7;
    private DeskYamko deskMakananDaerah8;
    private BelajarFragment belajarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_makanan);

        String nama = getIntent().getStringExtra("id");
        if (nama.equals("bubuybulan")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Bubuy Bulan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah = new DeskLaguDaerah();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiLagu.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiLagu.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("manukdadali")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Manuk Dadali");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah1 = new DeskManukDadali();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah1);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiLagu.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiLagu.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("eslilin")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Es Lilin");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah2 = new DeskEsLilin();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah2);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {

                        case R.id.nav_belajar:
                            Intent intent = new Intent(DeskripsiLagu.this, Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiLagu.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("indung")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Indung - Indung");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah3 = new DeskIndungIndung();
            belajarFragment = new BelajarFragment();


            setFragment(deskMakananDaerah3);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiLagu.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiLagu.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("cikperiuk")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Cik - Cik Periok");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah4 = new DeskCikPeriok();
            belajarFragment = new BelajarFragment();


            setFragment(deskMakananDaerah4);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiLagu.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiLagu.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("badindang")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Badindang Ria");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah5 = new DeskBadindangRia();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah5);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiLagu.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiLagu.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }

        if (nama.equals("apuse")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Apuse");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah6 = new DeskApuse();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah6);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiLagu.this,Home.class);
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
            getSupportActionBar().setTitle("Sajojo");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah7 = new DeskSajojo();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah7);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiLagu.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("yamko")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Yamko Rambe Yamko");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah8 = new DeskYamko();
            belajarFragment = new BelajarFragment();


            setFragment(deskMakananDaerah8);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiLagu.this,Home.class);
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
