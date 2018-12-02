package com.example.khaerulumam.culturism;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private ImageView imageView;
    private TextView nameTexView,emailTextView,idTextView;

    private GoogleApiClient googleApiClient;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.photoImageView);
        nameTexView = (TextView) findViewById(R.id.nameImageView);
        emailTextView = (TextView) findViewById(R.id.emailImageView);
        idTextView = (TextView) findViewById(R.id.idImageView);

        id = getIntent().getStringExtra("id");
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
                idTextView.setText(id);
            }
            //imageView.setVisibility(View.INVISIBLE);
        }
        else if (id.equals("twitter")){

            String username = getIntent().getStringExtra("username");
            imageView.setVisibility(View.INVISIBLE);
            nameTexView.setVisibility(View.VISIBLE);
            nameTexView.setText(username);
            emailTextView.setVisibility(View.INVISIBLE);
            idTextView.setVisibility(View.INVISIBLE);
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
            idTextView.setText(account.getId());

            Glide.with(this).load(account.getPhotoUrl()).into(imageView);

        } else {

            goLoginScreen();
        }

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
