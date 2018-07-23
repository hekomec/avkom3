package com.avkom.hekotech.avkom.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.avkom.hekotech.avkom.R;
import com.avkom.hekotech.avkom.classes.Eleman;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by hekotech on 16.07.2018.
 */

public class LvEleman extends RecyclerView.Adapter<LvEleman.MyViewHolder> {
    FirebaseDatabase database;
    DatabaseReference myRef ;
    private List<Eleman> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isim,yas,alan,egitim,medeni,askerlik,mail,numara,adres;
        public Button ara,sil;

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
            ara = itemView.findViewById(R.id.c_eleman_ara);
            sil = itemView.findViewById(R.id.c_eleman_sil);

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
        final Eleman mylist = list.get(position);
        holder.isim.setText(mylist.getIsim());
        holder.yas.setText(mylist.getDogum());
        holder.alan.setText(mylist.getAlan());

        holder.egitim.setText(mylist.getEgitim());
        holder.medeni.setText(mylist.getMedeni());
        holder.askerlik.setText(mylist.getAskerlik());

        holder.mail.setText(mylist.getMail());
        holder.numara.setText(mylist.getNumara());
        holder.adres.setText(mylist.getAdres());

        holder.ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+mylist.getNumara()));
                view.getContext().startActivity(callIntent);
            }
        });
        holder.sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("eleman");
                myRef.child(mylist.getId()).removeValue();
                Log.d(TAG, "onClick: key of iletisim"+mylist.getId());

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}