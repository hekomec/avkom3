package com.avkom.hekotech.avkom.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avkom.hekotech.avkom.R;
import com.avkom.hekotech.avkom.classes.Iletisim;
import com.avkom.hekotech.avkom.classes.Sikayet;

import java.util.List;

/**
 * Created by hekotech on 16.07.2018.
 */

public class LvSikayet extends RecyclerView.Adapter<LvSikayet.MyViewHolder> {

    private List<Sikayet> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isim,mail,numara,mesaj;

        public MyViewHolder(View view) {
            super(view);
            isim = (TextView) itemView.findViewById(R.id.c_sikayet_isim);


            mail = (TextView) itemView.findViewById(R.id.c_sikayet_mail);
            numara = (TextView) itemView.findViewById(R.id.c_sikayet_numara);
            mesaj = (TextView) itemView.findViewById(R.id.c_sikayet_mesaj);


        }
    }


    public LvSikayet(List<Sikayet> eList) {
        this.list = eList;
    }

    @Override
    public LvSikayet.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.c_sikayet, parent, false);

        return new LvSikayet.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LvSikayet.MyViewHolder holder, int position) {
        Sikayet mylist = list.get(position);
        holder.isim.setText(mylist.getIsim());

        holder.mail.setText(mylist.getMail());
        holder.numara.setText(mylist.getNumara());
        holder.mesaj.setText(mylist.getMesaj());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}