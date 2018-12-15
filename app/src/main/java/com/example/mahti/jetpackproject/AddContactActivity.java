package com.example.mahti.jetpackproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        initView();
    }

    private void initView() {
        Button submitBtn = (Button) findViewById(R.id.btn_add_regist);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContract();
            }
        });
    }

    private void addContract() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("cards");
        myRef.child("user1").child("allergies").setValue("test");
        myRef.child("user1").child("bloodType").setValue("test");
        myRef.child("user1").child("underlyingDisease").setValue("test");
        myRef.child("user1").child("name").setValue("test");
    }
}
