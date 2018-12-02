package com.example.khaerulumam.culturism.Papua;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
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
import java.util.concurrent.TimeUnit;

import static com.example.khaerulumam.culturism.config.Config.DETAIL_LAGUKALIMANTAN;
import static com.example.khaerulumam.culturism.config.Config.DETAIL_LAGUPAPUA;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeskYamko extends Fragment {

    SeekBar seekBar;

    Button play,pause;

    private Handler threadHandler = new Handler();

    private MediaPlayer mediaPlayer;

    public String as;

    private RequestQueue requestQueue;

    ArrayList<HashMap<String, String>> list_data;

    private StringRequest stringRequest;

    private TextView a,b,c;




    public DeskYamko() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_desk_lagu_daerah, container, false);

        play = (Button) view.findViewById(R.id.play);
        pause = (Button) view.findViewById(R.id.stop);

        requestQueue = Volley.newRequestQueue(getContext());

        list_data = new ArrayList<HashMap<String, String>>();

        as = DETAIL_LAGUPAPUA+"?id_lagu=3";

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                henti();
            }
        });
        seekBar = (SeekBar) view.findViewById(R.id.seekbar);
        seekBar.setClickable(false);

        pause.setEnabled(false);

        int songID = getRawResIdByName("yamko");

        mediaPlayer = MediaPlayer.create(getContext(),songID);


        a = (TextView) view.findViewById(R.id.judullagutarian);
        b = (TextView) view.findViewById(R.id.lagutarian);
        c = (TextView) view.findViewById(R.id.deskripsilagu);

        stringRequest = new StringRequest(Request.Method.GET, as, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("lagupapua");
                    for (int a = 0; a < jsonArray.length(); a ++){
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map  = new HashMap<String, String>();
                        map.put("id_lagu", json.getString("id_lagu"));
                        map.put("namalagu", json.getString("namalagu"));
                        map.put("liriklagu", json.getString("liriklagu"));
                        list_data.add(map);
                    }
                    a.setText(list_data.get(0).get("namalagu"));
                    b.setText("Lagu ini berasal dari Papua");
                    c.setText(list_data.get(0).get("liriklagu"));

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

    private void henti() {
        this.mediaPlayer.pause();
        this.pause.setEnabled(false);
        this.play.setEnabled(true);
    }

    private void start() {
        int duration = this.mediaPlayer.getDuration();

        int currentPosition = this.mediaPlayer.getCurrentPosition();
        if(currentPosition== 0)  {
            this.seekBar.setMax(duration);
//            String maxTimeString = this.millisecondsToString(duration);
//            this.textMaxTime.setText(maxTimeString);
        } else if(currentPosition== duration)  {
            // Resets the MediaPlayer to its uninitialized state.
            this.mediaPlayer.reset();
        }
        this.mediaPlayer.start();
        // Create a thread to update position of SeekBar.
        UpdateSeekBarThread updateSeekBarThread= new UpdateSeekBarThread();
        threadHandler.postDelayed(updateSeekBarThread,50);

        this.pause.setEnabled(true);
        this.play.setEnabled(false);
    }

    private int getRawResIdByName(String resName) {
        String pkgName = getContext().getPackageName();

        int resID = getResources().getIdentifier(resName,"raw",pkgName);
        return resID;
    }

    private String millisecondsToString(int milliseconds)  {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) milliseconds);
        long seconds =  TimeUnit.MILLISECONDS.toSeconds((long) milliseconds) ;
        return minutes+":"+ seconds;
    }
    
    class UpdateSeekBarThread implements Runnable {

        public void run()  {
            int currentPosition = mediaPlayer.getCurrentPosition();
            String currentPositionStr = millisecondsToString(currentPosition);
//            textCurrentPosition.setText(currentPositionStr);

            seekBar.setProgress(currentPosition);
            // Delay thread 50 milisecond.
            threadHandler.postDelayed(this, 50);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        this.mediaPlayer.stop();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.mediaPlayer.stop();
    }
}
