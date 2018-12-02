package com.example.khaerulumam.culturism.Pemesanan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.example.khaerulumam.culturism.R;
import com.example.khaerulumam.culturism.util.AppController;
import com.facebook.AccessToken;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.khaerulumam.culturism.config.Config.URL_INSERT;

public class PemesananTempat extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    EditText nohp, jumlah,nama, email,hrga;

    String idtempat, namatempat, harga, jam, tgl, name;

    int qty, total;

    Button booking;

    GoogleApiClient googleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan_tempat);

        nama = (EditText) findViewById(R.id.namapemesan);
        email = (EditText) findViewById(R.id.emailpemesan);
        nohp = (EditText) findViewById(R.id.nohppemesan);
        hrga = (EditText) findViewById(R.id.harga);
        jumlah = (EditText) findViewById(R.id.qty);

        idtempat = getIntent().getStringExtra("id");
        namatempat = getIntent().getStringExtra("namatempat");
        harga = getIntent().getStringExtra("harga");
        jam = getIntent().getStringExtra("jam");
        tgl = getIntent().getStringExtra("tgl");
        name = getIntent().getStringExtra("nama");
        booking = (Button) findViewById(R.id.book);

        hrga.setText(harga);

        if (name.equals("google")) {

            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();

            googleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this, this)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build();

        } else {

            nama.setText("");
            email.setText("");
        }

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData() {
        StringRequest sendData = new StringRequest(Request.Method.POST, URL_INSERT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(PemesananTempat.this, "pesan : "+   res.getString("message") , Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity( new Intent(PemesananTempat.this,DetailPemesanan.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PemesananTempat.this, "pesan : Gagal Insert Data", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                qty = Integer.parseInt(jumlah.getText().toString());
                total = qty * Integer.parseInt(hrga.getText().toString());
                Map<String,String> map = new HashMap<>();
                map.put("namapemesan",nama.getText().toString());
                map.put("emailpemesanan",email.getText().toString());
                map.put("nohppemesan",nohp.getText().toString());
                map.put("id_tempat",idtempat);
                map.put("jumlahpemesanan",jumlah.getText().toString());
                map.put("total", String.valueOf(total));

                return map;
            }
        };

        AppController.getInstance().addToRequestQueue(sendData);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (name.equals("google")) {
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
            nama.setText(account.getDisplayName());
            email.setText(account.getEmail());
//            idTextView.setText(account.getId());
        } else {

            Toast.makeText(this,"Gagal Load",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
