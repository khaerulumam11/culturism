package com.example.khaerulumam.culturism.Jabar;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.khaerulumam.culturism.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import me.biubiubiu.justifytext.library.JustifyTextView;

import static com.example.khaerulumam.culturism.config.Config.DETAIL_MAKANAN;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeskPeyeum extends Fragment {

    private ImageView a;
    private TextView b,c,d;
    private JustifyTextView e;

    public String as;

    private RequestQueue requestQueue;

    ArrayList<HashMap<String, String>> list_data;

    private StringRequest stringRequest;


    public DeskPeyeum() {
        // Required empty public constructor
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_desk_makanan_daerah, container, false);

        a = (ImageView) view.findViewById(R.id.imageView);
        b = (TextView) view.findViewById(R.id.namamakanan);
        c = (TextView) view.findViewById(R.id.asalmakanan);
       // d = (TextView) view.findViewById(R.id.deskripsimakanan);
        e = (JustifyTextView) view.findViewById(R.id.deskripsimakanan);

        requestQueue = Volley.newRequestQueue(getContext());

        list_data = new ArrayList<HashMap<String, String>>();

        as = DETAIL_MAKANAN+"?id_makanan=3";

        a.setImageResource(R.drawable.peyeum);
//        b.setText("Batagor");
//        c.setText("Makanan Khas Jawa Barat");
//        e.setText("Batagor adalah perpaduan antara baso goreng yang dibuat dari tepung tapioka dan ikan tenggiri, lalu dibungkus dengan kulit pangsit dan digoreng. Kemudian, baso goreng itu disajikan dengan potongan tahu goreng, kentang goreng, kol, dan telur goreng");
//        //d.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        stringRequest = new StringRequest(Request.Method.GET, as, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("makananjawabarat");
                    for (int a = 0; a < jsonArray.length(); a ++){
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map  = new HashMap<String, String>();
                        map.put("id_makanan", json.getString("id_makanan"));
                        map.put("namamakanan", json.getString("namamakanan"));
                        map.put("deskripsimakanan", json.getString("deskripsimakanan"));
                        list_data.add(map);
                    }
                    b.setText(list_data.get(0).get("namamakanan"));
                    c.setText("Makanan ini berasal dari Jawa Barat");
                    e.setText(list_data.get(0).get("deskripsimakanan"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
        return view;
    }

}


