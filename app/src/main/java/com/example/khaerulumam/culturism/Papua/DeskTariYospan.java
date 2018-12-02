package com.example.khaerulumam.culturism.Papua;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.khaerulumam.culturism.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.khaerulumam.culturism.config.Config.DETAIL_TARIANKALIMANTAN;
import static com.example.khaerulumam.culturism.config.Config.DETAIL_TARIANPAPUA;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeskTariYospan extends Fragment implements YouTubePlayer.OnInitializedListener {

    private TextView a,b,c;
    VideoView videoView;
    private int position = 0;
    private MediaController mediaController;
    Button d;

    public String as;

    private RequestQueue requestQueue;

    ArrayList<HashMap<String, String>> list_data;

    private StringRequest stringRequest;


    private static final int REQUEST_NUMBER = 999;
    private YouTubePlayerView youTubePlayerView;

    public static final String YOUTUBE_API_KEY = "AIzaSyAy6xXgIG0RIJkmcasXJ3W2yO9Vn8DyU3c";
    public static final String YOUTUBE_ID = "M3pCwh-WxjE";


    public DeskTariYospan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_desk_tarian_daerah, container, false);

//        videoView = (VideoView) view.findViewById(R.id.videoView);
        youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player);

        a = (TextView) view.findViewById(R.id.namatarian);
        b = (TextView) view.findViewById(R.id.asaltarian);
        c = (TextView) view.findViewById(R.id.deskripsitarian);

        requestQueue = Volley.newRequestQueue(getContext());

        list_data = new ArrayList<HashMap<String, String>>();

        as = DETAIL_TARIANPAPUA+"?id_tarian=2";


        youTubePlayerView.initialize(YOUTUBE_API_KEY,this);

        stringRequest = new StringRequest(Request.Method.GET, as, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("tarianpapua");
                    for (int a = 0; a < jsonArray.length(); a ++){
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map  = new HashMap<String, String>();
                        map.put("id_tarian", json.getString("id_tarian"));
                        map.put("namatarian", json.getString("namatarian"));
                        map.put("deskripsitarian", json.getString("deskripsitarian"));
                        list_data.add(map);
                    }
                    a.setText(list_data.get(0).get("namatarian"));
                    b.setText("Tarian ini berasal dari Papua");
                    c.setText(list_data.get(0).get("deskripsitarian"));

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

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo(YOUTUBE_ID);
            /**
             * there are 2 method you can user here :
             * .cueVideo(), for didn't play automatically
             * .loadVideo(), for do play automatically
             *
             * if you are using play automatically, it better if you hide the video controllers
             * do like below :
             * youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);//hide the players controllers
             */
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(getActivity(), REQUEST_NUMBER).show();
        }else{
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer (%1$s)", youTubeInitializationResult.toString()
            );
            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_NUMBER) {
            youTubePlayerView.initialize(YOUTUBE_API_KEY, this);
        }
    }
}
