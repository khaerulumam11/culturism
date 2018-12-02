package com.example.khaerulumam.culturism.Pemesanan;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.khaerulumam.culturism.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DeskripsiTempat extends AppCompatActivity implements OnMapReadyCallback {

    TextView namatmpat;
    TextView alamat;
    TextView deskripsi;
    TextView tgl;
    TextView jam;
    TextView harga;
    TextView lt;
    TextView lg;
    Button psan;

    SupportMapFragment mapFragment;

    String id, nama,id_tempat,hrga;
    Double lat,lng;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    ArrayList<HashMap<String, String>> list_data;

    private BottomNavigationView mMainNav;

    private GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_tempat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detail Tempat Pemesanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        namatmpat = (TextView) findViewById(R.id.judul);
        alamat = (TextView) findViewById(R.id.tvAlmatTmpt);
        deskripsi = (TextView) findViewById(R.id.tvDeskTmpt);
        tgl = (TextView) findViewById(R.id.tvTgltTmpt);
        jam = (TextView) findViewById(R.id.tvJamTmpt);
        harga = (TextView) findViewById(R.id.tvHrgTmpt);
        lt = (TextView) findViewById(R.id.lat);
        lg = (TextView) findViewById(R.id.lng);
        psan = (Button) findViewById(R.id.pesan);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        requestQueue = Volley.newRequestQueue(DeskripsiTempat.this);

        list_data = new ArrayList<HashMap<String, String>>();

        id = getIntent().getStringExtra("idtempat");
        nama = getIntent().getStringExtra("nama");

        stringRequest = new StringRequest(Request.Method.GET, id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("tempat");
                    for (int a = 0; a < jsonArray.length(); a ++){
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map  = new HashMap<String, String>();
                        map.put("id_tempat", json.getString("id_tempat"));
                        map.put("namatempat", json.getString("namatempat"));
                        map.put("alamat", json.getString("alamat"));
                        map.put("deskripsi", json.getString("deskripsi"));
                        map.put("tanggal_pertunjukan", json.getString("tanggal_pertunjukan"));
                        map.put("jam_pertunjukan", json.getString("jam_pertunjukan"));
                        map.put("harga_tiket", json.getString("harga_tiket"));
                        map.put("lat", json.getString("lat"));
                        map.put("lng", json.getString("lng"));
                        list_data.add(map);
                    }
                    namatmpat.setText(list_data.get(0).get("namatempat"));
                    alamat.setText(list_data.get(0).get("alamat"));
                    deskripsi.setText(list_data.get(0).get("deskripsi"));
                    tgl.setText(list_data.get(0).get("tanggal_pertunjukan"));
                    jam.setText(list_data.get(0).get("jam_pertunjukan") + "WIB");
                    harga.setText(list_data.get(0).get("harga_tiket"));
                    id_tempat = list_data.get(0).get("id_tempat");
                    lt.setText(list_data.get(0).get("lat"));
                    lg.setText(list_data.get(0).get("lng"));
                    lat = Double.valueOf(lt.getText().toString());
                    lng = Double.valueOf(lg.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DeskripsiTempat.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);

        psan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aj = new Intent(getApplicationContext(),PemesananTempat.class);
                aj.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                aj.putExtra("id",id_tempat);
                aj.putExtra("nama", nama);
                aj.putExtra("harga", String.valueOf(harga.getText().toString()));
                aj.putExtra("namatempat", String.valueOf(namatmpat));
                aj.putExtra("tgl", String.valueOf(tgl));
                aj.putExtra("jam", String.valueOf(jam));

                startActivity(aj);
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

//         Menambah marker di Alun-alun Demak - Jateng, Indonesia, dan menggerakan kamera.
        LatLng demak = new LatLng(lat, lng);
        gMap.addMarker(new MarkerOptions().position(demak).title("www.dedykuncoro.com"));
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(demak,18));
    }
}
