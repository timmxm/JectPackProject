package com.example.mahti.jetpackproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<CardDetail> Card1st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Card1st = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("cards");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dsp : dataSnapshot.getChildren()) {
                    CardDetail card = dsp.getValue(CardDetail.class);
                    Card1st.add(new CardDetail(card.getName(), card.getBloodType(), card.getAllergies(), card.getUnderlyingDisease(), card.getPhoneNumber(), R.drawable.contact_pic));
                }
                Card1st.remove(0);
                RecyclerView myrv = (RecyclerView) findViewById(R.id.main_recyclerView);
                LinearLayoutManager horizontalLayoutManager
                        = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(MainActivity.this, Card1st);
                myrv.setLayoutManager(horizontalLayoutManager);
                myrv.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Error, duh
            }
        });

        Card1st.add(new CardDetail("Loading...", "Loading...", "Loading...", "Loading...", "Loading...", R.drawable.contact_pic));
        System.out.println("Now");
        RecyclerView myrv = (RecyclerView) findViewById(R.id.main_recyclerView);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, Card1st);
        myrv.setLayoutManager(horizontalLayoutManager);
        myrv.setAdapter(myAdapter);

    }
}
