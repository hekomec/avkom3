package com.avkom.hekotech.avkom.View;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avkom.hekotech.avkom.R;
import com.avkom.hekotech.avkom.classes.Iletisim;
import com.avkom.hekotech.avkom.classes.Sikayet;
import com.avkom.hekotech.avkom.model.LvIletisim;
import com.avkom.hekotech.avkom.model.LvSikayet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class FrSikayet extends android.support.v4.app.Fragment implements main.YourFragmentInterface {
    @Override
    public void fragmentBecameVisible() {

    }
    FirebaseDatabase database;
    DatabaseReference myRef ;
    private List<Sikayet> list = new ArrayList<>();
    RecyclerView recyclerView;
    LvSikayet mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
prepareData();



        View rootView = inflater.inflate(R.layout.activity_fr_sikayet, container, false);


        return rootView;
    }

    private void prepareData() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("sikayet");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                list.clear();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Sikayet value = dataSnapshot1.getValue(Sikayet.class);
                    Sikayet fire = new Sikayet();
                    String isim = value.getIsim();
                    String mail = value.getMail();

                    String numara = value.getNumara();
                    String mesaj = value.getMesaj();




                    fire.setIsim(isim);
                    Log.d(TAG, "onDataChange: "+fire.getIsim());
                    fire.setMail(mail);
                    Log.d(TAG, "onDataChange: "+fire.getMail());


                    fire.setNumara(numara);
                    Log.d(TAG, "onDataChange: "+fire.getNumara());

                    fire.setMesaj(mesaj);

                    list.add(fire);
                    mAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Hello", "Failed to read value.", error.toException());
            }
        });

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Override
    public void onResume() {

        super.onResume();

        prepareData();
        recyclerView = getActivity().findViewById(R.id.RwSikayet);

        mAdapter = new LvSikayet(list);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);




    }





}