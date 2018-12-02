package com.example.khaerulumam.culturism.Pemesanan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.khaerulumam.culturism.R;
import com.example.khaerulumam.culturism.model.ListTempatData;
import com.example.khaerulumam.culturism.util.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TempatPemesanan extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;

    private ListTempatPemesanan listTempatPemesanan;
    private RecyclerView recyclerView;
    //  private AdapterListPilihanBudaya adapter;
    private ArrayList<Integer> gambar1;
    private ArrayList<String> judul;
    private RecyclerView.Adapter adapter;

    private List<ListTempatData> mItems = new ArrayList<>();

    String id, nama, aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_makanan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("List Tempat Pemesanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        id = "http://172.89.4.140/culturism/listtempatpertunjukan.php";

        aa = "http://172.89.4.254/culturism/detailtempat.php?id_tempat=";

        nama = getIntent().getStringExtra("nama");

        loadJSON();

        recyclerView.setHasFixedSize(true);
        //adapter = new AdapterListPilihanBudaya(getActivity(),mahasiswaArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        adapter = new LaguData(getContext(),mItems);
        adapter = new ListPemesananData(getApplicationContext(), mItems);

        recyclerView.setAdapter(adapter);

        mMainNav = (BottomNavigationView) findViewById(R.id.btmnav);
        frameLayout = (FrameLayout) findViewById(R.id.mainframe);

//            listTempatPemesanan = new ListTempatPemesanan();
//            setFragment(listTempatPemesanan);
    }

    private void loadJSON() {
        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, id, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        pd.cancel();
                        Log.d("volley", "response : " + response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ListTempatData md = new ListTempatData();
                                md.setId(data.getInt("id_tempat"));
                                md.setNamatempat(data.getString("namatempat"));
                                mItems.add(md);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        pd.cancel();
                        Log.d("volley", "error : " + error.getMessage());
                    }
                });

        AppController.getInstance().addToRequestQueue(reqData);

    }


    public class ListPemesananData extends RecyclerView.Adapter<ListPemesananData.ViewHolder> {

        private List<ListTempatData> mList;
        private Context ctx;


        public ListPemesananData(Context ctx, List<ListTempatData> mList) {
            this.ctx = ctx;
            this.mList = mList;

        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // membuat view baru
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pilihan_makanandaerah, parent, false);
            // mengeset ukuran view, margin, padding, dan parameter layout lainnya
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            ListTempatData ls = mList.get(position);
            holder.a.setImageResource(R.drawable.lagu);
            holder.b.setText(ls.getNamatempat());
            holder.c.setText(String.valueOf(ls.getId()));
            holder.ls = ls;

        }

        @Override
        public int getItemCount() {
            // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
            return mList.size();
        }

       class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            // di tutorial ini kita hanya menggunakan data String dan Integer untuk tiap item
            public ImageView a;
            public TextView b,c;

            private Context context;
            ListTempatData ls;

            public ViewHolder(View v) {
                super(v);

                a = (ImageView) v.findViewById(R.id.img);
                b = (TextView) v.findViewById(R.id.text);
                c = (TextView) v.findViewById(R.id.idtmpat);

                v.setOnClickListener(this);
            }

           @Override
           public void onClick(View v) {
               Intent ah = new Intent(ctx,DeskripsiTempat.class);
               ah.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               ah.putExtra("idtempat","http://172.89.4.140/culturism/detailtempat.php?id_tempat=" +String.valueOf(ls.getId()));
               ah.putExtra("nama",nama);

               ctx.startActivity(ah);
           }
       }

    }
}
//    private void setFragment(Fragment fragment) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.mainframe,fragment);
//        fragmentTransaction.commit();
//    }

