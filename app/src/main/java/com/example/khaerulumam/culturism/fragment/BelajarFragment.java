package com.example.khaerulumam.culturism.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.khaerulumam.culturism.Home;
import com.example.khaerulumam.culturism.ListBudaya;
import com.example.khaerulumam.culturism.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BelajarFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView jawa,sumatera,sulawesi,kalimantan,papua;

    public BelajarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_belajar, container, false);

        jawa = (ImageView) view.findViewById(R.id.jawa);
//        sumatera = (ImageView) view.findViewById(R.id.sumbar);
//        sulawesi = (ImageView) view.findViewById(R.id.sulawesi);
        kalimantan = (ImageView) view.findViewById(R.id.kalimantan);
        papua = (ImageView) view.findViewById(R.id.papua);

        jawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), ListBudaya.class);
                pindah.putExtra("daerah","JawaBarat");
                pindah.putExtra("budaya","listbudaya");
                startActivity(pindah);
            }
        });

//        sumatera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent pindah = new Intent(getContext(), ListBudaya.class);
//                pindah.putExtra("daerah","Sumatera");
//                startActivity(pindah);
//            }
//        });
//
//        sulawesi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent pindah = new Intent(getContext(), ListBudaya.class);
//                pindah.putExtra("daerah","Sulawesi");
//                startActivity(pindah);
//            }
//        });

        kalimantan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getContext(), ListBudaya.class);
                pindah.putExtra("daerah","Kalimantan");
                startActivity(pindah);
            }
        });

        papua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getContext(), ListBudaya.class);
                pindah.putExtra("daerah","Papua");
                startActivity(pindah);
            }
        });

//        GridView gridview = (GridView) view.findViewById(R.id.gvprovinsi);
//        gridview.setAdapter (new PilihKota_Adapter(getActivity()));
//
//        gridview.setOnItemClickListener     (new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                switch (i){
//                    case 0:
//                        Intent pindah = new Intent(getActivity(), LoginActivity.class);
//                        startActivity(pindah);
//                        //finish();
//                        break;
//                    case 1:
//                        Intent pindah2 = new Intent(getActivity(), LoginActivity.class);
//                        startActivity(pindah2);
//                        //finish();
//                        break;
//                    case 2:
//                        Intent pindah3 = new Intent(getActivity(), LoginActivity.class);
//                        startActivity(pindah3);
//                        //  finish();
//                        break;
//                    case 3:
//                        Intent pindah4 = new Intent(getActivity(), LoginActivity.class);
//                        startActivity(pindah4);
//                        //  finish();
//                        break;
//
//                    case 4:
//                        Intent pindah5 = new Intent(getActivity(), LoginActivity.class);
//                        startActivity(pindah5);
//                        //  finish();
//                        break;
//
//
//                }
//            }
//        });

        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
