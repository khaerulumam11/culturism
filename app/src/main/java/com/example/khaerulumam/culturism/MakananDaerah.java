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
import com.example.khaerulumam.culturism.fragment.ListMakananDaerah;
import com.example.khaerulumam.culturism.fragment.ListMakananDaerahKalimantan;
import com.example.khaerulumam.culturism.fragment.ListMakananDaerahPapua;

public class MakananDaerah extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;

    private ListMakananDaerah listPilihanBudaya;
    private ListMakananDaerahKalimantan listPilihanBudaya2;
    private ListMakananDaerahPapua listPilihanBudaya4;
    private BelajarFragment belajarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_daerah);
        String nama = getIntent().getStringExtra("judulmakanan");
        if (nama.equals("MakananJabar") ) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List Makanan Daerah Jawa Barat");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            listPilihanBudaya = new ListMakananDaerah();
            belajarFragment = new BelajarFragment();

            setFragment(listPilihanBudaya);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(MakananDaerah.this,Home.class);
                            startActivity(intent);
                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(MakananDaerah.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("MakananKalimantan")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List Makanan Daerah Kalimantan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            listPilihanBudaya2 = new ListMakananDaerahKalimantan();
            belajarFragment = new BelajarFragment();

            setFragment(listPilihanBudaya2);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(MakananDaerah.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        if (nama.equals("MakananPapua")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List Makanan Daerah Papua");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
            frameLayout = (FrameLayout) findViewById(R.id.mainframe);

            listPilihanBudaya4 = new ListMakananDaerahPapua();
            belajarFragment = new BelajarFragment();


            setFragment(listPilihanBudaya4);

            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.nav_belajar :
                            Intent intent = new Intent(MakananDaerah.this,Home.class);
                            startActivity(intent);
                            return true;

                        default:
                            return false;
                    }
                }
            });
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
//            case R.id.nav_tarian:
//                Intent intent = new Intent(MakananDaerah.this,TarianDaerah.class);
//                intent.putExtra("judultarian","TarianJabar");
//                startActivity(intent);
//                break;
//            case R.id.nav_makanan:
//                Intent intent1 = new Intent(MakananDaerah.this,MakananDaerah.class);
//                intent1.putExtra("judulmakanan","MakananJabar");
//                startActivity(intent1);
//                break;
//            case R.id.nav_lagu:
//                Intent intent2 = new Intent(MakananDaerah.this,LaguDaerah.class);
//                intent2.putExtra("judul","LaguJabar");
//                startActivity(intent2);
//                break;
//
//            case R.id.nav_pakaian:
//                Intent intent3 = new Intent(MakananDaerah.this,PakaianDaerah.class);
//                intent3.putExtra("judulpakaian","PakaianJabar");
//                startActivity(intent3);
//                break;
//            case R.id.nav_tarian_kalimantan:
//                Intent intent4 = new Intent(MakananDaerah.this,TarianDaerah.class);
//                intent4.putExtra("judultarian","TarianKalimantan");
//                startActivity(intent4);
//                break;
//            case R.id.nav_makanan_kalimantan:
//                Intent intent5 = new Intent(MakananDaerah.this,MakananDaerah.class);
//                intent5.putExtra("judulmakanan","MakananKalimantan");
//                startActivity(intent5);
//                break;
//            case R.id.nav_lagu_kalimantan:
//                Intent intent6 = new Intent(MakananDaerah.this,LaguDaerah.class);
//                intent6.putExtra("judul","LaguKalimantan");
//                startActivity(intent6);
//                break;
//
//            case R.id.nav_pakaian_kalimantan:
//                Intent intent7 = new Intent(MakananDaerah.this,PakaianDaerah.class);
//                intent7.putExtra("judulpakaian","PakaianKalimantan");
//                startActivity(intent7);
//                break;
//
//            case R.id.nav_tarian_sumatera:
//                Intent intent8 = new Intent(MakananDaerah.this,TarianDaerah.class);
//                intent8.putExtra("judultarian","TarianSumatera");
//                startActivity(intent8);
//                break;
//            case R.id.nav_makanan_sumatera:
//                Intent intent9 = new Intent(MakananDaerah.this,MakananDaerah.class);
//                intent9.putExtra("judulmakanan","MakananSumatera");
//                startActivity(intent9);
//                break;
//            case R.id.nav_lagu_sumatera:
//                Intent intent10 = new Intent(MakananDaerah.this,LaguDaerah.class);
//                intent10.putExtra("judul","LaguSumatera");
//                startActivity(intent10);
//                break;
//
//            case R.id.nav_pakaian_sumatera:
//                Intent intent11 = new Intent(MakananDaerah.this,PakaianDaerah.class);
//                intent11.putExtra("judulpakaian","PakaianSumatera");
//                startActivity(intent11);
//                break;
//            case R.id.nav_tarian_sulawesi:
//                Intent intent12 = new Intent(MakananDaerah.this,TarianDaerah.class);
//                intent12.putExtra("judultarian","TarianSulawesi");
//                startActivity(intent12);
//                break;
//            case R.id.nav_makanan_sulawesi:
//                Intent intent13 = new Intent(MakananDaerah.this,MakananDaerah.class);
//                intent13.putExtra("judulmakanan","MakananSulawesi");
//                startActivity(intent13);
//                break;
//            case R.id.nav_lagu_sulawesi:
//                Intent intent14 = new Intent(MakananDaerah.this,LaguDaerah.class);
//                intent14.putExtra("judul","LaguSulawesi");
//                startActivity(intent14);
//                break;
//
//            case R.id.nav_pakaian_sulawesi:
//                Intent intent15 = new Intent(MakananDaerah.this,PakaianDaerah.class);
//                intent15.putExtra("judulpakaian","PakaianSulawesi");
//                startActivity(intent15);
//                break;
//            case R.id.nav_tarian_papua:
//                Intent intent16 = new Intent(MakananDaerah.this,TarianDaerah.class);
//                intent16.putExtra("judultarian","TarianPapua");
//                startActivity(intent16);
//                break;
//            case R.id.nav_makanan_papua:
//                Intent intent17 = new Intent(MakananDaerah.this,MakananDaerah.class);
//                intent17.putExtra("judulmakanan","MakananPapua");
//                startActivity(intent17);
//                break;
//            case R.id.nav_lagu_papua:
//                Intent intent18 = new Intent(MakananDaerah.this,LaguDaerah.class);
//                intent18.putExtra("judul","LaguPapua");
//                startActivity(intent18);
//                break;
//
//            case R.id.nav_pakaian_papua:
//                Intent intent19 = new Intent(MakananDaerah.this,PakaianDaerah.class);
//                intent19.putExtra("judulpakaian","PakaianPapua");
//                startActivity(intent19);
//                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
