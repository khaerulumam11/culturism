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
import com.example.khaerulumam.culturism.fragment.ListPilihanBudayaKalimantan;
import com.example.khaerulumam.culturism.fragment.ListPilihanBudayaPapua;
import com.example.khaerulumam.culturism.jawabarat.ListPilihanBudaya;
public class ListBudaya extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;

    private ListPilihanBudaya listPilihanBudaya;
    //    private ListPilihanBudayaSumatera listPilihanBudaya1;
//    private ListPilihanBudayaSulawesi listPilihanBudaya2;
    private ListPilihanBudayaKalimantan listPilihanBudaya3;
    private ListPilihanBudayaPapua listPilihanBudaya4;
    private BelajarFragment belajarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_list_budaya);


        String nama = getIntent().getStringExtra("daerah");

        if (nama.equals("JawaBarat")) {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List Budaya Jawa Barat");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            frameLayout = (FrameLayout) findViewById(R.id.mainframe);


            listPilihanBudaya = new ListPilihanBudaya();
            belajarFragment = new BelajarFragment();

            setFragment(listPilihanBudaya);


            // displaySelectedScreen(R.id.nav_gallery);
        }
        if (nama.equals("Kalimantan")) {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List Budaya Kalimantan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);


            frameLayout = (FrameLayout) findViewById(R.id.mainframe);


            listPilihanBudaya3 = new ListPilihanBudayaKalimantan();
            belajarFragment = new BelajarFragment();


            setFragment(listPilihanBudaya3);



            // displaySelectedScreen(R.id.nav_gallery);
        }
//        if (nama.equals("Sumatera")) {
//
//            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setTitle("List Budaya Sumatera");
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//            drawer.addDrawerListener(toggle);
//            toggle.syncState();
//
//            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//            navigationView.setNavigationItemSelectedListener(this);
//
//            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
//            frameLayout = (FrameLayout) findViewById(R.id.mainframe);
//
//
//            listPilihanBudaya1 = new ListPilihanBudayaSumatera();
//            belajarFragment = new BelajarFragment();
//            quizFragment = new QuizFragment();
//            profileFragment = new ProfileFragment();
//
//            setFragment(listPilihanBudaya1);
//
//
//            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switch (item.getItemId()){
//
//                        case R.id.nav_belajar :
//                            Intent intent = new Intent(ListBudaya.this,PilihKota.class);
//                            startActivity(intent);
//                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(ListBudaya.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;
//
//                        default:
//                            return false;
//                    }
//                }
//            });
//
//            // displaySelectedScreen(R.id.nav_gallery);
//        }
//        if (nama.equals("Sulawesi")) {
//
//            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setTitle("List Budaya Sulawesi");
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//            drawer.addDrawerListener(toggle);
//            toggle.syncState();
//
//            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//            navigationView.setNavigationItemSelectedListener(this);
//
//            mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
//            frameLayout = (FrameLayout) findViewById(R.id.mainframe);
//
//
//            listPilihanBudaya2 = new ListPilihanBudayaSulawesi();
//            belajarFragment = new BelajarFragment();
//            quizFragment = new QuizFragment();
//            profileFragment = new ProfileFragment();
//
//            setFragment(listPilihanBudaya2);
//
//
//            mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switch (item.getItemId()){
//
//                        case R.id.nav_belajar :
//                            Intent intent = new Intent(ListBudaya.this,PilihKota.class);
//                            startActivity(intent);
//                            return true;
//                        case R.id.nav_quiz :
//                            Intent intent1 = new Intent(ListBudaya.this,Quiz.class);
//                            startActivity(intent1);
//                            return true;
//
//                        default:
//                            return false;
//                    }
//                }
//            });
//
//            // displaySelectedScreen(R.id.nav_gallery);
//        }
        if (nama.equals("Papua")) {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List Budaya Papua");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);




            listPilihanBudaya4 = new ListPilihanBudayaPapua();
            belajarFragment = new BelajarFragment();


            setFragment(listPilihanBudaya4);




            // displaySelectedScreen(R.id.nav_gallery);
        }
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
//        getMenuInflater().inflate(R.menu.list_budaya, menu);
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
//                Intent intent = new Intent(ListBudaya.this,TarianDaerah.class);
//                intent.putExtra("judultarian","TarianJabar");
//                startActivity(intent);
//                break;
//            case R.id.nav_makanan:
//                Intent intent1 = new Intent(ListBudaya.this,MakananDaerah.class);
//                intent1.putExtra("judulmakanan","MakananJabar");
//                startActivity(intent1);
//                break;
//            case R.id.nav_lagu:
//                Intent intent2 = new Intent(ListBudaya.this,LaguDaerah.class);
//                intent2.putExtra("judul","LaguJabar");
//                startActivity(intent2);
//                break;
//
//            case R.id.nav_pakaian:
//                Intent intent3 = new Intent(ListBudaya.this,PakaianDaerah.class);
//                intent3.putExtra("judulpakaian","PakaianJabar");
//                startActivity(intent3);
//                break;
//            case R.id.nav_tarian_kalimantan:
//                Intent intent4 = new Intent(ListBudaya.this,TarianDaerah.class);
//                intent4.putExtra("judultarian","TarianKalimantan");
//                startActivity(intent4);
//                break;
//            case R.id.nav_makanan_kalimantan:
//                Intent intent5 = new Intent(ListBudaya.this,MakananDaerah.class);
//                intent5.putExtra("judulmakanan","MakananKalimantan");
//                startActivity(intent5);
//                break;
//            case R.id.nav_lagu_kalimantan:
//                Intent intent6 = new Intent(ListBudaya.this,LaguDaerah.class);
//                intent6.putExtra("judul","LaguKalimantan");
//                startActivity(intent6);
//                break;
//
//            case R.id.nav_pakaian_kalimantan:
//                Intent intent7 = new Intent(ListBudaya.this,PakaianDaerah.class);
//                intent7.putExtra("judulpakaian","PakaianKalimantan");
//                startActivity(intent7);
//                break;
//
//            case R.id.nav_tarian_sumatera:
//                Intent intent8 = new Intent(ListBudaya.this,TarianDaerah.class);
//                intent8.putExtra("judultarian","TarianSumatera");
//                startActivity(intent8);
//                break;
//            case R.id.nav_makanan_sumatera:
//                Intent intent9 = new Intent(ListBudaya.this,MakananDaerah.class);
//                intent9.putExtra("judulmakanan","MakananSumatera");
//                startActivity(intent9);
//                break;
//            case R.id.nav_lagu_sumatera:
//                Intent intent10 = new Intent(ListBudaya.this,LaguDaerah.class);
//                intent10.putExtra("judul","LaguSumatera");
//                startActivity(intent10);
//                break;
//
//            case R.id.nav_pakaian_sumatera:
//                Intent intent11 = new Intent(ListBudaya.this,PakaianDaerah.class);
//                intent11.putExtra("judulpakaian","PakaianSumatera");
//                startActivity(intent11);
//                break;
//            case R.id.nav_tarian_sulawesi:
//                Intent intent12 = new Intent(ListBudaya.this,TarianDaerah.class);
//                intent12.putExtra("judultarian","TarianSulawesi");
//                startActivity(intent12);
//                break;
//            case R.id.nav_makanan_sulawesi:
//                Intent intent13 = new Intent(ListBudaya.this,MakananDaerah.class);
//                intent13.putExtra("judulmakanan","MakananSulawesi");
//                startActivity(intent13);
//                break;
//            case R.id.nav_lagu_sulawesi:
//                Intent intent14 = new Intent(ListBudaya.this,LaguDaerah.class);
//                intent14.putExtra("judul","LaguSulawesi");
//                startActivity(intent14);
//                break;
//
//            case R.id.nav_pakaian_sulawesi:
//                Intent intent15 = new Intent(ListBudaya.this,PakaianDaerah.class);
//                intent15.putExtra("judulpakaian","PakaianSulawesi");
//                startActivity(intent15);
//                break;
//            case R.id.nav_tarian_papua:
//                Intent intent16 = new Intent(ListBudaya.this,TarianDaerah.class);
//                intent16.putExtra("judultarian","TarianPapua");
//                startActivity(intent16);
//                break;
//            case R.id.nav_makanan_papua:
//                Intent intent17 = new Intent(ListBudaya.this,MakananDaerah.class);
//                intent17.putExtra("judulmakanan","MakananPapua");
//                startActivity(intent17);
//                break;
//            case R.id.nav_lagu_papua:
//                Intent intent18 = new Intent(ListBudaya.this,LaguDaerah.class);
//                intent18.putExtra("judul","LaguPapua");
//                startActivity(intent18);
//                break;
//
//            case R.id.nav_pakaian_papua:
//                Intent intent19 = new Intent(ListBudaya.this,PakaianDaerah.class);
//                intent19.putExtra("judulpakaian","PakaianPapua");
//                startActivity(intent19);
//                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
