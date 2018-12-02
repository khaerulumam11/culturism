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

import com.example.khaerulumam.culturism.LaguDaerah;
import com.example.khaerulumam.culturism.MakananDaerah;
import com.example.khaerulumam.culturism.PakaianDaerah;
import com.example.khaerulumam.culturism.R;
import com.example.khaerulumam.culturism.TarianDaerah;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPilihanBudayaPapua extends Fragment {

    private RecyclerView recyclerView;
  //  private AdapterListPilihanBudaya adapter;
    private ArrayList<Integer> gambar1;
    private RecyclerView.Adapter adapter;

//    protected ListView listview;
//    protected ListAdapter adapter;
//    SimpleAdapter Adapter;
//    HashMap<String,String> map;
//    ArrayList <HashMap<String,String>> mylist;
//    String[] Gbr;


    private int[] Gambar = {R.drawable.lagudaerah, R.drawable.makanandaerah,R.drawable.tarianadat,R.drawable.pakaiandaerah};
    private int[] judul = {1,2,3,4};



    public ListPilihanBudayaPapua() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_list_pilihan_budaya, container, false);



        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        //adapter = new AdapterListPilihanBudaya(getActivity(),mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(gambar1);

        recyclerView.setAdapter(adapter);

        gambar1 = new ArrayList<>();
        addData();

//        listview = (ListView) view.findViewById(R.id.listview1);
//
//        Gbr = new String[]{
//                Integer.toString(R.drawable.lagudaerah),
//                Integer.toString(R.drawable.makanandaerah),
//                Integer.toString(R.drawable.tarianadat),
//                Integer.toString(R.drawable.pakaiandaerah),
//        };
//
//        mylist = new ArrayList<HashMap<String,String>>();
//
//        for (int i = 0; i<Gbr.length;i++){
//            map = new HashMap<String,String>();
//            map.put("gbr",Gbr[i]);
//            mylist.add(map);
//        }
//
//        Adapter = new SimpleAdapter(getActivity(), mylist,R.layout.list_pilihan_budaya,new String[]{"gbr"}, new int []{R.id.img});
//
//        listview.setAdapter(Adapter);
//
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                // String Pilihitem = NamaWisata[+position];
//                // Toast.makeText(getApplicationContext(), Pilihitem, Toast.LENGTH_SHORT).show();
//                switch (position) {
//                    case 0:
//                        Intent pindah = new Intent(pilihhotelmalang.this, hotelaria.class);
//                        startActivity(pindah);
//                        //finish();
//                        break;
//                    case 1:
//                        Intent pindah2 = new Intent(pilihhotelmalang.this, hotelswiss.class);
//                        startActivity(pindah2);
//                        //finish();
//                        break;
//                    case 2:
//                        Intent pindah3 = new Intent(pilihhotelmalang.this, hotelatria.class);
//                        startActivity(pindah3);
//                        //  finish();
//                        break;
//
//                }
//            }
//        });

        return view;
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private ArrayList<String> rvData, rvHarga;
        private ArrayList<Integer> gambar;


        public RecyclerViewAdapter( ArrayList<Integer> gmbr) {

            gambar = gmbr;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            // di tutorial ini kita hanya menggunakan data String dan Integer untuk tiap item
            public ImageView a;

            private Context context;

            public ViewHolder(View v) {
                super(v);

                //Untuk Menghubungkan dan Mendapakan Context dari MainActivity
//                context = itemView.getContext();
                //melakukan inisiasi TextView, ImageView dan LinearLayoout
                a = (ImageView) v.findViewById(R.id.img);
                //agar isi dari array nya dapat pindah layout dengan membawa data sesuai dibawah
                a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (getAdapterPosition()) {
                            case 0:
                                Intent intent = new Intent(getActivity().getBaseContext(), LaguDaerah.class);
                                intent.putExtra("judul", "LaguPapua");
                                startActivity(intent);
                                break;
                            case 1:
                               Intent intent1 = new Intent(getActivity().getBaseContext(), MakananDaerah.class);
                                intent1.putExtra("judulmakanan", "MakananPapua");
                                startActivity(intent1);
                                break;

                            case 2:
                               Intent intent2 = new Intent(getActivity().getBaseContext(), TarianDaerah.class);
                                intent2.putExtra("judultarian", "TarianPapua");
                                startActivity(intent2);
                                break;

                            case 3:
                                Intent intent3 = new Intent(getActivity().getBaseContext(), PakaianDaerah.class);
                                intent3.putExtra("judulpakaian", "PakaianPapua");
                                startActivity(intent3);
                                break;

                        }

                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // membuat view baru
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pilihan_budaya, parent, false);
            // mengeset ukuran view, margin, padding, dan parameter layout lainnya
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
            // - mengeset isi view dengan elemen dari dataset tersebut
            final Integer test = gambar1.get(position);
            holder.a.setImageResource(test);

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
        }
    }

}
