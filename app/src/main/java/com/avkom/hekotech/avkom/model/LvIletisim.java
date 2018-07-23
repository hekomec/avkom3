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
import android.widget.Toast;

import com.avkom.hekotech.avkom.R;
import com.avkom.hekotech.avkom.classes.Iletisim;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by hekotech on 16.07.2018.
 */

public class LvIletisim extends RecyclerView.Adapter<LvIletisim.MyViewHolder> {


    FirebaseDatabase database;
    DatabaseReference myRef ;
    private List<Iletisim> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isim,mail,numara;
        public Button ara,sil;

        public MyViewHolder(View view) {
            super(view);
            isim = (TextView) itemView.findViewById(R.id.c_iletisim_isim);


            mail = itemView.findViewById(R.id.c_iletisim_mail);
            numara = itemView.findViewById(R.id.c_iletisim_numara);
            ara = itemView.findViewById(R.id.c_iletisim_ara);
            sil = itemView.findViewById(R.id.c_iletisim_sil);


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
        final Iletisim mylist = list.get(position);
        holder.isim.setText(mylist.getIsim());

        holder.mail.setText(mylist.getMail());
        holder.numara.setText(mylist.getNumara());


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
                myRef = database.getReference("iletisim");
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