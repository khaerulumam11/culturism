package com.example.khaerulumam.culturism;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
//import com.twitter.sdk.android.core.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener {


    private static final int RC_SIGN_IN = 9001;

    private SignInButton signInButton;

    private GoogleApiClient googleApiClient;

    private LoginButton loginButton;

    private Button btnLogin;

    private CallbackManager callbackManager;

    private TwitterLoginButton mTwitterSignInButton;

    private String first,last,email,id,nama,picture;



    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
    TextInputLayout gmail,sandi;
   // private int gambar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("VaFuaZXgO7NIcJ32zzC6VKh3b","ZkUd9OpN9LxdN0z0BLKYbCKQ2RhLdVJGX6po7XgKcwj4VmCsPz"))
                .debug(true)
                .build();
        Twitter.initialize(config);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.buttonLogin);

        gmail = findViewById(R.id.email);
        sandi = findViewById(R.id.password);

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                login();
//            }
//        });

        checkForInstagramData();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile","email","user_birthday","user_friends"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String accessToken = loginResult.getAccessToken().getToken();

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                        Log.d("response",object.toString());
                         getData(object);
                         goMainScreen1();
                    }
                });

                Bundle parameter = new Bundle();
                parameter.putString("fields","first_name,last_name,email,id");
                request.setParameters(parameter);
                request.executeAsync();


            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Cancel Login",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Gagal Login",Toast.LENGTH_SHORT).show();
            }
        });

//        TwitterAuthConfig authConfig = new TwitterAuthConfig("hkmstJYCBhvXzH9pBF5WbbDic",
//                "H7IdsTPH6aDQZbKzeKy6XSctKIAFitWaU7jNftG3J4Uh6ahtDR");
//        Fabric.with(this, new TwitterCore(authConfig));

        mTwitterSignInButton = (TwitterLoginButton)findViewById(R.id.twitter_sign_in_button);
        mTwitterSignInButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(final Result<TwitterSession> result) {
               TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;


                //Calling login method and passing twitter session
                login(session);
            }

            @Override
            public void failure(TwitterException e) {
                Toast.makeText(LoginActivity.this, "Authentication failed!", Toast.LENGTH_LONG).show();
            }
        });

        signInButton = (SignInButton) findViewById(R.id.btn_login_google);

        signInButton.setOnClickListener(this);
        signInButton.setSize(SignInButton.SIZE_WIDE);

        signInButton.setColorScheme(SignInButton.COLOR_DARK);

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();

    }

//    private void login() {
//        final String email1 = gmail.getEditText().getText().toString();
//        String pass = sandi.getEditText().getText().toString();
//
//        if (TextUtils.isEmpty(email)) {
//            gmail.setError("Email Tidak Boleh Kosong!");
//            return;
//        }
//
//        if (TextUtils.isEmpty(pass)) {
//            sandi.setError("Password Tidak Boleh Kosong");
//            return;
//        }
//        loginService = new LoginService(this);
//        loginService.doLogin(email1, pass, new retrofit2.Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                User user = (User) response.body();
//
//                if (user != null) {
//                    if (!user.isError()) {
////                        Intent ab = new Intent(getApplicationContext(),Home.class);
////                        ab.putExtra("id_biasa",)
//                        PrefUtil.putUser(LoginActivity.this, PrefUtil.USER_SESSION, user);
//                        Home.start(LoginActivity.this);
//                        LoginActivity.this.finish();
//                    }
//
//                    Toast.makeText(LoginActivity.this, user.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Toast.makeText(LoginActivity.this, "An error occurred!", Toast.LENGTH_SHORT).show();
//            }
//        });


    private void getData(JSONObject object) {
        try{
            URL url_picture = new URL ("https://graph.facebook.com/"+object.getString("id")+"/picture?width=350&height=350");

            picture = url_picture.toString();
            first = object.getString("first_name");
            last = object.getString("last_name");
            email = object.getString("email");
            id = object.getString("id");

            nama = first + last;

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    private void checkForInstagramData() {
        final Uri data = this.getIntent().getData();
        if(data != null && data.getScheme().equals("sociallogin") && data.getFragment() != null) {
            final String accessToken = data.getFragment().replaceFirst("access_token=", "");
            if (accessToken != null) {
                handleSignInResult(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        // Do nothing, just throw the access token away.
                        return null;
                    }
                });
            } else {
                handleSignInResult(null);
            }
        }
    }

    private void loginInstagram() {
        final Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme("https")
                .authority("api.instagram.com")
                .appendPath("oauth")
                .appendPath("authorize")
                .appendQueryParameter("client_id", "12ff55a250c6458f98bd4ffe9f601faa")
                .appendQueryParameter("redirect_uri", "sociallogin://redirect")
                .appendQueryParameter("response_type", "token");
        final Intent browser = new Intent(Intent.ACTION_VIEW, uriBuilder.build());
        startActivity(browser);
    }

    private void login(TwitterSession session) {
        String username = session.getUserName();
        Intent intent = new Intent(LoginActivity.this, Home.class);
        intent.putExtra("username", username);
        intent.putExtra("id","twitter");
        startActivity(intent);
    }

    private void goMainScreen2() {
        Intent intent = new Intent(this,Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id","twitter");
        startActivity(intent);
    }

    private void handleSignInResult(Callable<Void> callable) {
    }

    private void goMainScreen1() {
        Intent intent = new Intent(this,Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id","fb");
        intent.putExtra("nama",nama);
        intent.putExtra("email",email);
        intent.putExtra("id_fb",id);
        intent.putExtra("gambar",picture);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_login_google:
                signIn();
                break;
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn(){

        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,RC_SIGN_IN);

    }

    private void handleResult (GoogleSignInResult result){

        if (result.isSuccess()){

           // GoogleSignInAccount account = result.getSignInAccount();
            goMainScreen();
        }
        else {
            Toast.makeText(this,"Gagal Login",Toast.LENGTH_SHORT).show();
        }

    }

    private void goMainScreen() {
        Intent intent = new Intent(this,Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id","google");
        startActivity(intent);
    }

    private void updateUI(boolean isLoggin){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }  else if(TwitterAuthConfig.DEFAULT_AUTH_REQUEST_CODE == requestCode) {
            mTwitterSignInButton.onActivityResult(requestCode, resultCode, data);
        }
        else {
            callbackManager.onActivityResult(requestCode,resultCode,data);
        }


    }
}
