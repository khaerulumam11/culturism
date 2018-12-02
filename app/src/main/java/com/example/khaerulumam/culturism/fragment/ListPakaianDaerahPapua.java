package com.example.khaerulumam.culturism.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khaerulumam.culturism.DeskripsiPakaian;
import com.example.khaerulumam.culturism.R;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPakaianDaerahPapua extends Fragment {

    private RecyclerView recyclerView;
    //  private AdapterListPilihanBudaya adapter;
    private ArrayList<Integer> gambar1;
    private ArrayList<String> judul;
    private RecyclerView.Adapter adapter;

//    protected ListView listview;
//    protected ListAdapter adapter;
//    SimpleAdapter Adapter;
//    HashMap<String,String> map;
//    ArrayList <HashMap<String,String>> mylist;
//    String[] Gbr;


    private int[] Gambar = {R.drawable.koteka, R.drawable.rokrumbai,R.drawable.yokal};
    private String[] Judul = {"Koteka","Rok Rumbai","Yokal"};


    public ListPakaianDaerahPapua() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_makanan_daerah, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        //adapter = new AdapterListPilihanBudaya(getActivity(),mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(gambar1,judul);

        recyclerView.setAdapter(adapter);

        gambar1 = new ArrayList<>();
        judul = new ArrayList<>();
        addData();

        return view;
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private ArrayList<String> rvData, rvHarga;
        private ArrayList<Integer> gambar;


        public RecyclerViewAdapter( ArrayList<Integer> gmbr,ArrayList<String> jdl) {

            gambar = gmbr;
            judul = jdl;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            // di tutorial ini kita hanya menggunakan data String dan Integer untuk tiap item
            public ImageView a;
            public TextView b;

            private Context context;

            public ViewHolder(View v) {
                super(v);

                //Untuk Menghubungkan dan Mendapakan Context dari MainActivity
//                context = itemView.getContext();
                //melakukan inisiasi TextView, ImageView dan LinearLayoout
                a = (ImageView) v.findViewById(R.id.img);
                b = (TextView) v.findViewById(R.id.text);
                //agar isi dari array nya dapat pindah layout dengan membawa data sesuai dibawah
                a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity().getBaseContext(), DeskripsiPakaian.class);
                        //  String deskprisi = "";
                        switch (getAdapterPosition()) {
                            case 0:
                                intent.putExtra("id", "koteka");
                                startActivity(intent);
                                break;
                            case 1:
                                intent.putExtra("id", "rumbai");
                                startActivity(intent);
                                break;
                            case 2:
                                intent.putExtra("id", "yokal");
                                startActivity(intent);
                                break;

                        }

                    }
                });
            }
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
            // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
            // - mengeset isi view dengan elemen dari dataset tersebut
            final Integer test = gambar1.get(position);
            final String test1 = judul.get(position);
            holder.a.setImageResource(test);
            holder.b.setText(test1);

        }

        @Override
        public int getItemCount() {
            // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
            return gambar1.size();
        }
    }

    private void addData(){
        for (int w = 0; w < Gambar.length; w++){
            gambar1.add(Gambar[w]);
            judul.add(Judul[w]);
        }
    }
}
