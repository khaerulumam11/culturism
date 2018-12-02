package com.example.khaerulumam.culturism.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khaerulumam.culturism.R;
import com.example.khaerulumam.culturism.model.LaguModel;
import com.example.khaerulumam.culturism.model.MakananModel;

import java.util.List;

public class MakananData extends RecyclerView.Adapter<MakananData.HolderData> {
    private List<MakananModel> mList ;
    private Context ctx;


    public MakananData(Context ctx, List<MakananModel> mList)
    {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pilihan_makanandaerah,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        MakananModel dm = mList.get(position);
        holder.judullagu.setText(dm.getNama());
        holder.imageView.setImageResource(dm.getGambar());
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
      return mList.size();
    }

    class HolderData extends  RecyclerView.ViewHolder{
        TextView judullagu;
        ImageView imageView;
        MakananModel dm;
        public HolderData (View v)
        {
            super(v);

            judullagu  = (TextView) v.findViewById(R.id.text);
            imageView  = (ImageView) v.findViewById(R.id.img);

        }
    }
}
