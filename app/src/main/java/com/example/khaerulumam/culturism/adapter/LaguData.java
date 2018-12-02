package com.example.khaerulumam.culturism.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khaerulumam.culturism.R;
import com.example.khaerulumam.culturism.fragment.ListLaguDaerah;
import com.example.khaerulumam.culturism.model.LaguModel;

import java.util.List;

public class LaguData extends RecyclerView.Adapter<LaguData.HolderData> {
    private List<LaguModel> mList ;
    private Context ctx;


    public LaguData(Context ctx, List<LaguModel> mList)
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
        LaguModel dm = mList.get(position);
        holder.judullagu.setText(dm.getNama());
        holder.imageView.setImageResource(R.drawable.play);
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
      return mList.size();
    }

    class HolderData extends  RecyclerView.ViewHolder{
        TextView judullagu;
        ImageView imageView;
        LaguModel dm;
        public HolderData (View v)
        {
            super(v);

            judullagu  = (TextView) v.findViewById(R.id.text);
            imageView  = (ImageView) v.findViewById(R.id.img);

        }
    }
}
