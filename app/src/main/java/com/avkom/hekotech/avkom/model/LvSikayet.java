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
import com.avkom.hekotech.avkom.classes.Iletisim;
import com.avkom.hekotech.avkom.classes.Sikayet;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by hekotech on 16.07.2018.
 */

public class LvSikayet extends RecyclerView.Adapter<LvSikayet.MyViewHolder> {

    private List<Sikayet> list;
    FirebaseDatabase database;
    DatabaseReference myRef ;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isim,mail,numara,mesaj;
        public Button ara,sil;

        public MyViewHolder(View view) {
            super(view);
            isim = (TextView) itemView.findViewById(R.id.c_sikayet_isim);


            mail = (TextView) itemView.findViewById(R.id.c_sikayet_mail);
            numara = (TextView) itemView.findViewById(R.id.c_sikayet_numara);
            mesaj = (TextView) itemView.findViewById(R.id.c_sikayet_mesaj);

            ara = itemView.findViewById(R.id.c_sikayet_ara);
            sil = itemView.findViewById(R.id.c_sikayet_sil);


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
        final Sikayet mylist = list.get(position);
        holder.isim.setText(mylist.getIsim());

        holder.mail.setText(mylist.getMail());
        holder.numara.setText(mylist.getNumara());
        holder.mesaj.setText(mylist.getMesaj());

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
                myRef = database.getReference("sikayet");
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