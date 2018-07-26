package com.example.jojo.dhaaniapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CityActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    LinearLayoutManager mLayoutManager;
    List<City> listofSoftware;
    City CityDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_city);
        recyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);

        databaseReference = FirebaseDatabase.getInstance().getReference("Rajasthan").child("Kota");
        loadDataFromSoftwareServer();



    }

    public void loadDataFromSoftwareServer() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Latest Data Database");
        progressDialog.show();

        listofSoftware = new ArrayList<>();

        //------------------------------------------Data Received from server-----------------------------------------------------

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    CityDetails = dataSnapshot.getValue(City.class);

                    listofSoftware.add(CityDetails);
                }

                adapter = new RecyclerViewAdapterCity(CityActivity.this, listofSoftware);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });
    }

}
