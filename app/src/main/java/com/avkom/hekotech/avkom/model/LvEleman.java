package com.avkom.hekotech.avkom.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avkom.hekotech.avkom.R;
import com.avkom.hekotech.avkom.classes.Eleman;

import java.util.List;

/**
 * Created by hekotech on 16.07.2018.
 */

public class LvEleman extends RecyclerView.Adapter<LvEleman.MyViewHolder> {

    private List<Eleman> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isim,yas,alan,egitim,medeni,askerlik,mail,numara,adres;

        public MyViewHolder(View view) {
            super(view);
            isim = (TextView) itemView.findViewById(R.id.c_eleman_isim);
            yas = (TextView) itemView.findViewById(R.id.c_eleman_yas);
            alan = (TextView) itemView.findViewById(R.id.c_eleman_alan);

            egitim = (TextView) itemView.findViewById(R.id.c_eleman_egitim);
            medeni = (TextView) itemView.findViewById(R.id.c_eleman_medeni);
            askerlik = (TextView) itemView.findViewById(R.id.c_eleman_askerlik);

            mail = (TextView) itemView.findViewById(R.id.c_eleman_mail);
            numara = (TextView) itemView.findViewById(R.id.c_eleman_numara);
            adres = (TextView) itemView.findViewById(R.id.c_eleman_adres);

        }
    }


    public LvEleman(List<Eleman> eList) {
        this.list = eList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.c_eleman, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Eleman mylist = list.get(position);
        holder.isim.setText(mylist.getIsim());
        holder.yas.setText(mylist.getDogum());
        holder.alan.setText(mylist.getAlan());

        holder.egitim.setText(mylist.getEgitim());
        holder.medeni.setText(mylist.getMedeni());
        holder.askerlik.setText(mylist.getAskerlik());

        holder.mail.setText(mylist.getMail());
        holder.numara.setText(mylist.getNumara());
        holder.adres.setText(mylist.getAdres());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}