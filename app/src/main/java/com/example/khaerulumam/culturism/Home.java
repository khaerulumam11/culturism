package com.example.khaerulumam.culturism;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.khaerulumam.culturism.Pemesanan.ListTempatPemesanan;
import com.example.khaerulumam.culturism.Pemesanan.TempatPemesanan;
import com.example.khaerulumam.culturism.fragment.BelajarFragment;
import com.example.khaerulumam.culturism.fragment.ListPilihanBudayaKalimantan;
import com.example.khaerulumam.culturism.fragment.ListPilihanBudayaPapua;
import com.example.khaerulumam.culturism.jawabarat.ListPilihanBudaya;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.twitter.sdk.android.core.TwitterCore;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,GoogleApiClient.OnConnectionFailedListener {

    public static void start(Context context) {
        Intent intent = new Intent(context, Home.class);
        intent.putExtra("id","login_biasa");
        context.startActivity(intent);
    }

    ImageView imageView;
     TextView nameTexView,emailTextView,idTextView;

     GoogleApiClient googleApiClient;

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;
    private BelajarFragment belajarFragment;
    private ListPilihanBudaya listPilihanBudaya;
    //    private ListPilihanBudayaSumatera listPilihanBudaya1;
//    private ListPilihanBudayaSulawesi listPilihanBudaya2;
    private ListPilihanBudayaKalimantan listPilihanBudaya3;
    private ListPilihanBudayaPapua listPilihanBudaya4;

    String id,id1,nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        imageView = (ImageView) headerView.findViewById(R.id.imageView);
        nameTexView = (TextView) headerView.findViewById(R.id.nama);
        emailTextView = (TextView) headerView.findViewById(R.id.email);

        mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
        frameLayout = (FrameLayout) findViewById(R.id.mainframe);


        id = getIntent().getStringExtra("id");

            belajarFragment = new BelajarFragment();
            setFragment(belajarFragment);

        //  idTextView = (TextView) findViewById(R.id.idImageView);


        if (id.equals("google")) {

            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();

            googleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this, this)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build();

        } else if (id.equals("fb")){
            if (AccessToken.getCurrentAccessToken()==null){
                goLoginScreen1();
            } else {
                String nama = getIntent().getStringExtra("nama");
                String email = getIntent().getStringExtra("email");
                String id = getIntent().getStringExtra("id_fb");
                String gambar = getIntent().getStringExtra("gambar");

                Glide.with(this).load(gambar).into(imageView);

                nameTexView.setText(nama);
                emailTextView.setText(email);
                //idTextView.setText(id);
            }
            //imageView.setVisibility(View.INVISIBLE);
        }
//        else if (id.equals("twitter")){
//
//            String username = getIntent().getStringExtra("username");
//            imageView.setVisibility(View.INVISIBLE);
//            nameTexView.setVisibility(View.VISIBLE);
//            nameTexView.setText(username);
//            emailTextView.setVisibility(View.INVISIBLE);
//           // idTextView.setVisibility(View.INVISIBLE);
//        }
        else if (id.equals("loginbiasa")){
            nameTexView.setText("default");
            emailTextView.setText("default");
            imageView.setImageResource(R.drawable.fb);
        }


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_belajar:
                        Intent intent = new Intent(Home.this, Home.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_quiz:
                        Intent intent1 = new Intent(Home.this, TempatPemesanan.class);
                        intent1.putExtra("nama",id);
                        startActivity(intent1);
                        return true;

                    default:
                        return false;
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


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
        getMenuInflater().inflate(R.menu.home, menu);
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

        if (id == R.id.jawa) {
            // Handle the camera action
        } else if (id == R.id.sumatera) {

        } else if (id == R.id.sulawesi) {

        } else if (id == R.id.kalimantan) {

        } else if (id == R.id.papua) {

        } else if (id == R.id.profile) {

        } else if (id == R.id.logout) {
           logout();
        }

//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        if (id.equals("google")) {
            Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                @Override
                public void onResult(@NonNull Status status) {
                    if (status.isSuccess()) {
                        goLoginScreen();
                    } else {
                        Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else if (id.equals("fb")){
            LoginManager.getInstance().logOut();
            goLoginScreen();
        } else if (id.equals("twitter")){
            CookieSyncManager.createInstance(this);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeSessionCookie();
            TwitterCore.getInstance().getSessionManager().clearActiveSession();
            goLoginScreen();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (id.equals("google")) {
            OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
            if (opr.isDone()) {
                GoogleSignInResult result = opr.get();
                handleSignInResult(result);
            } else {
                opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                    @Override
                    public void onResult(@NonNull GoogleSignInResult result) {
                        handleSignInResult(result);
                    }
                });

            }
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {

        if (result.isSuccess()){

            GoogleSignInAccount account = result.getSignInAccount();
            nameTexView.setText(account.getDisplayName());
            emailTextView.setText(account.getEmail());
//            idTextView.setText(account.getId());

            Glide.with(this).load(account.getPhotoUrl()).into(imageView);

        } else {

            goLoginScreen();
        }

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view) {

        if (id.equals("google")) {
            Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                @Override
                public void onResult(@NonNull Status status) {
                    if (status.isSuccess()) {
                        goLoginScreen();
                    } else {
                        Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else if (id.equals("fb")){
            LoginManager.getInstance().logOut();
            goLoginScreen();
        } else if (id.equals("twitter")){
            CookieSyncManager.createInstance(this);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeSessionCookie();
            TwitterCore.getInstance().getSessionManager().clearActiveSession();
            goLoginScreen();
        }
    }

    public void revoke(View view) {
        Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()){
                    goLoginScreen();
                } else{
                    Toast.makeText(getApplicationContext(),"Gagal Revoke",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void goLoginScreen1() {
        Intent intent = new Intent(this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
//
//    public void keluar(View view) {
//        LoginManager.getInstance().logOut();
//        goLoginScreen();
//    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
