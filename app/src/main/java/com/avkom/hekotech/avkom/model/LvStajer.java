package com.avkom.hekotech.avkom.model;

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
import com.avkom.hekotech.avkom.classes.Stajer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by hekotech on 16.07.2018.
 */

public class LvStajer  extends RecyclerView.Adapter<LvStajer.MyViewHolder> {

    FirebaseDatabase database;
    DatabaseReference myRef ;
    private List<Stajer> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isim,yas,tarih,sure,medeni,uni,mail,numara,adres;
        Button ara,sil;

        public MyViewHolder(View view) {
            super(view);
            isim = (TextView) itemView.findViewById(R.id.c_stajer_isim);
            yas = (TextView) itemView.findViewById(R.id.c_stajer_yas);
            sure = (TextView) itemView.findViewById(R.id.c_stajer_sure);

            uni = (TextView) itemView.findViewById(R.id.c_stajer_uni);
            medeni = (TextView) itemView.findViewById(R.id.c_stajer_medeni);
            tarih = (TextView) itemView.findViewById(R.id.c_stajer_tarih);

            mail = (TextView) itemView.findViewById(R.id.c_stajer_mail);
            numara = (TextView) itemView.findViewById(R.id.c_stajer_numara);
            adres = (TextView) itemView.findViewById(R.id.c_stajer_adres);

            ara = itemView.findViewById(R.id.c_stajer_ara);
            sil = itemView.findViewById(R.id.c_stajer_sil);


        }
    }


    public LvStajer(List<Stajer> eList) {
        this.list = eList;
    }

    @Override
    public LvStajer.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.c_stajer, parent, false);

        return new LvStajer.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LvStajer.MyViewHolder holder, int position) {
        final Stajer mylist = list.get(position);
        holder.isim.setText(mylist.getIsim());
        holder.yas.setText(mylist.getDogum());
        holder.uni.setText(mylist.getUni());

        holder.tarih.setText(mylist.getStajTarih());
        holder.medeni.setText(mylist.getMedeni());
        holder.sure.setText(mylist.getStajSure());

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
                myRef = database.getReference("stajer");
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