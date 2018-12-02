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

import com.example.khaerulumam.culturism.Jabar.DeskBatagor;
import com.example.khaerulumam.culturism.Jabar.DeskKaredok;
import com.example.khaerulumam.culturism.Jabar.DeskPeyeum;
import com.example.khaerulumam.culturism.Kalimantan.DeskBekepor;
import com.example.khaerulumam.culturism.Kalimantan.DeskIwak;
import com.example.khaerulumam.culturism.Kalimantan.DeskPengkang;
import com.example.khaerulumam.culturism.Papua.DeskIkanBungkus;
import com.example.khaerulumam.culturism.Papua.DeskIkanManokwari;
import com.example.khaerulumam.culturism.Papua.DeskPapeda;
import com.example.khaerulumam.culturism.fragment.BelajarFragment;


public class DeskripsiMakanan extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;

    private DeskPeyeum deskMakananDaerah;
    private DeskKaredok deskMakananDaerah1;
    private DeskBatagor deskMakananDaerah2;
    private DeskIwak deskMakananDaerah3;
    private DeskBekepor deskMakananDaerah4;
    private DeskPengkang deskMakananDaerah5;
    private DeskIkanManokwari deskMakananDaerah6;
    private DeskIkanBungkus deskMakananDaerah7;
    private DeskPapeda deskMakananDaerah8;
    private BelajarFragment belajarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_makanan);
        String nama = getIntent().getStringExtra("id");

        if (nama.equals("peyeum")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Peyeum");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah = new DeskPeyeum();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiMakanan.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiMakanan.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("karedok")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Karedok");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah1 = new DeskKaredok();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah1);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiMakanan.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiMakanan.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("batagor")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Batagor");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah2 = new DeskBatagor();
            belajarFragment = new BelajarFragment();
//
            setFragment(deskMakananDaerah2);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiMakanan.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(DeskripsiMakanan.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }

        if (nama.equals("iwak")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Iwak Pakasam");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah3 = new DeskIwak();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah3);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiMakanan.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("bekepor")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Nasi Bekepor");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah4 = new DeskBekepor();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah4);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiMakanan.this,Home.class);
                            startActivity(intent);
                            return true;


                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("pengkang")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Pengkang");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah5 = new DeskPengkang();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah5);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiMakanan.this,Home.class);
                            startActivity(intent);
                            return true;


                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("ikanbakar")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Ikan Bakar Manokwari");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah6 = new DeskIkanManokwari();
            belajarFragment = new BelajarFragment();


            setFragment(deskMakananDaerah6);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiMakanan.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("ikanbungkus")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Ikan Bungkus");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah7 = new DeskIkanBungkus();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah7);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiMakanan.this,Home.class);
                            startActivity(intent);
                            return true;


                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("papeda")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Papeda");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            deskMakananDaerah8 = new DeskPapeda();
            belajarFragment = new BelajarFragment();

            setFragment(deskMakananDaerah8);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(DeskripsiMakanan.this,Home.class);
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
