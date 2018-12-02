package com.example.khaerulumam.culturism.Pemesanan;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.khaerulumam.culturism.DeskripsiLagu;
import com.example.khaerulumam.culturism.R;
import com.example.khaerulumam.culturism.model.LaguModel;
import com.example.khaerulumam.culturism.model.ListTempatData;
import com.example.khaerulumam.culturism.util.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListTempatPemesanan extends Fragment {

    private RecyclerView recyclerView;
    //  private AdapterListPilihanBudaya adapter;
    private ArrayList<Integer> gambar1;
    private ArrayList<String> judul;
    private RecyclerView.Adapter adapter;

    private List<ListTempatData> mItems = new ArrayList<>();

    String id;

//    protected ListView listview;
//    protected ListAdapter adapter;
//    SimpleAdapter Adapter;
//    HashMap<String,String> map;
//    ArrayList <HashMap<String,String>> mylist;
//    String[] Gbr;


    private int[] Gambar = {R.drawable.play, R.drawable.play,R.drawable.play};
    private String[] Judul = {"Bubuy Bulan","Manuk Dadali","Es Lilin"};


    public ListTempatPemesanan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_makanan_daerah, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        id = "http://172.89.4.151/culturism/listtempatpertunjukan.php";

//        loadJSON();
//
//        recyclerView.setHasFixedSize(true);
//        //adapter = new AdapterListPilihanBudaya(getActivity(),mahasiswaArrayList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
////        adapter = new LaguData(getContext(),mItems);
//        adapter = new ListPemesananData(getContext(),mItems);

        recyclerView.setAdapter(adapter);
//        addData();

        return view;
    }

//    private void loadJSON() {
//        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, id,null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
////                        pd.cancel();
//                        Log.d("volley","response : " + response.toString());
//                        for(int i = 0 ; i < response.length(); i++)
//                        {
//                            try {
//                                JSONObject data = response.getJSONObject(i);
//                                ListTempatData md = new ListTempatData();
//                                md.setNamatempat(data.getString("namatempat"));
//                                mItems.add(md);
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
////                        pd.cancel();
//                        Log.d("volley", "error : " + error.getMessage());
//                    }
//                });
//
//        AppController.getInstance().addToRequestQueue(reqData);
//
//    }

//    public class ListPemesananData extends RecyclerView.Adapter<ListPemesananData.ViewHolder> {
//
//        private List<ListTempatData> mList ;
//        private Context ctx;
//
//
//        public ListPemesananData( Context ctx, List<ListTempatData> mList) {
//            this.ctx = ctx;
//            this.mList = mList;
//
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder {
//
//            // di tutorial ini kita hanya menggunakan data String dan Integer untuk tiap item
//            public ImageView a;
//            public TextView b;
//
//            private Context context;
//            ListTempatData ls;
//
//            public ViewHolder(View v) {
//                super(v);
//
//                //Untuk Menghubungkan dan Mendapakan Context dari MainActivity
////                context = itemView.getContext();
//                //melakukan inisiasi TextView, ImageView dan LinearLayoout
//                a = (ImageView) v.findViewById(R.id.img);
//                b = (TextView) v.findViewById(R.id.text);
//                //agar isi dari array nya dapat pindah layout dengan membawa data sesuai dibawah
//                v.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(ctx, DeskripsiTempat.class);
//                        intent.putExtra("id_tempat",""+ls.getId_tempat());
//                        intent.putExtra("nama","");
//
//                        ctx.startActivity(intent);
//                    }
//                });
//            }
//        }
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            // membuat view baru
//            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pilihan_makanandaerah, parent, false);
//            // mengeset ukuran view, margin, padding, dan parameter layout lainnya
//            ViewHolder vh = new ViewHolder(v);
//            return vh;
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//
//            ListTempatData ls = mList.get(position);
//            holder.a.setImageResource(R.drawable.lagu);
//            holder.b.setText(ls.getNamatempat());
//
//        }
//
//        @Override
//        public int getItemCount() {
//            // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
//            return mList.size();
//        }
//    }
}
