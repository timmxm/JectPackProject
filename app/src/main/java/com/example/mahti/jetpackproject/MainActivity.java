package com.example.mahti.jetpackproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private ImageView icon_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.icon_user = (ImageView) findViewById(R.id.icon_user);
        this.icon_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        // Bind recycleView
        recyclerView = findViewById(R.id.main_recyclerView);

        // TODO You can change the layout manager here.
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        // Set the adapter
        adapter = new MainAdapter();

        // Add list of items to adapter
        adapter.setItemList(createItem());

        // Bind adapter to recyclerView
        recyclerView.setAdapter(adapter);


    }

    // Test creating list of items
    private List<BaseItem> createItem() {
        List<BaseItem> itemList = new ArrayList<>();
        for(int item=0; item<10; item++) {
            itemList.add(new CardViewItem()
                    .setcard_pic(R.drawable.contact_pic)
                    .setcard_name("Name" + item)
                    .setcardPrompt_blood("" + item)
                    .setcard_blood("" + item)
                    .setcardPrompt_allergy("" + item)
                    .setcard_allergy("" + item)
                    .setcardPrompt_disease("" + item)
                    .setcard_disease("" + item));
        }
        return itemList;
    }
}
