package com.example.mahti.jetpackproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView icon_user;;
    List<CardDetail> Card1st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //plz review before merg
        this.icon_user = (ImageView) findViewById(R.id.icon_user);
        this.icon_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserActivity.class);
                MainActivity.this.startActivity(i);
            }
        });


        Card1st = new ArrayList<>();
        Card1st.add(new CardDetail("The Vegitarian","A","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("The Wild Robot","B","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("Maria Semples","B","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("The Martian","B","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("He Died with...","AB","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("The Vegitarian","O","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("The Wild Robot","B","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("Maria Semples","A","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("The Martian","O","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("He Died with...","AB","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("The Vegitarian","O","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("The Wild Robot","B","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("Maria Semples","O","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("The Martian","AB","book","Aids",R.drawable.contact_pic,"0987654321"));
        Card1st.add(new CardDetail("He Died with...","A","book","Aids",R.drawable.contact_pic,"0987654321"));
        RecyclerView myrv = (RecyclerView) findViewById(R.id.main_recyclerView);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, Card1st);
        myrv.setLayoutManager(horizontalLayoutManager);
        myrv.setAdapter(myAdapter);

    }
}
