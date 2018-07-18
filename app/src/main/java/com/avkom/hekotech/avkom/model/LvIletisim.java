package com.avkom.hekotech.avkom.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avkom.hekotech.avkom.R;
import com.avkom.hekotech.avkom.classes.Eleman;
import com.avkom.hekotech.avkom.classes.Iletisim;

import java.util.List;

/**
 * Created by hekotech on 16.07.2018.
 */

public class LvIletisim extends RecyclerView.Adapter<LvIletisim.MyViewHolder> {

    private List<Iletisim> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isim,mail,numara;

        public MyViewHolder(View view) {
            super(view);
            isim = (TextView) itemView.findViewById(R.id.c_iletisim_isim);


            mail = (TextView) itemView.findViewById(R.id.c_iletisim_mail);
            numara = (TextView) itemView.findViewById(R.id.c_iletisim_numara);


        }
    }


    public LvIletisim(List<Iletisim> eList) {
        this.list = eList;
    }

    @Override
    public LvIletisim.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.c_iletisim, parent, false);

        return new LvIletisim.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LvIletisim.MyViewHolder holder, int position) {
        Iletisim mylist = list.get(position);
        holder.isim.setText(mylist.getIsim());

        holder.mail.setText(mylist.getMail());
        holder.numara.setText(mylist.getNumara());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}