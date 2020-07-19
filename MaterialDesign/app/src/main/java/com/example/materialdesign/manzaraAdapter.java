package com.example.materialdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class manzaraAdapter extends RecyclerView.Adapter<manzaraAdapter.MyViewHolder> {
    ArrayList<Manzara> mDataList;
    LayoutInflater inflater;

    public manzaraAdapter(Context context,ArrayList<Manzara> data)
    {
        inflater=LayoutInflater.from(context);
        this.mDataList=data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Manzara tiklananManzara=mDataList.get(position);
        holder.setData(tiklananManzara,position);
    }

    public void deleteItem(int position)
    {
        mDataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mDataList.size());

    }
    public void addItem(int position,Manzara kopyalanacakManzara)
    {
        mDataList.add(position,kopyalanacakManzara);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,mDataList.size());

    }
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        int positionn;
        Manzara kopyManzara;
        TextView mGeziBaslik,mGeziAciklama;
        ImageView mGeziResmi,mSilResmi,mKopyalaResmi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mGeziBaslik=(TextView) itemView.findViewById(R.id.tvManzaraBaslik);
            mGeziAciklama=(TextView) itemView.findViewById(R.id.tvManzaraTanim);
            mGeziResmi=(ImageView)itemView.findViewById(R.id.imgManzara);
            mSilResmi=(ImageView)itemView.findViewById(R.id.imgSil);
            mKopyalaResmi=(ImageView)itemView.findViewById(R.id.imgKopyala);
            mSilResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteItem(positionn);
                }
            });
            mKopyalaResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addItem(positionn,kopyManzara);
                }
            });
        }

        public void setData(Manzara tiklananManzara, int position) {
            this.mGeziBaslik.setText(tiklananManzara.getBaslik());
            this.mGeziAciklama.setText(tiklananManzara.getTanım());
            this.mGeziResmi.setImageResource(tiklananManzara.getImageID());
            this.positionn=position;
            this.kopyManzara=tiklananManzara;
        }
    }
}
