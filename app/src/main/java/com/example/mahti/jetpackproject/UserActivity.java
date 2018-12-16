package com.example.mahti.jetpackproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class UserActivity extends AppCompatActivity {

    private FirebaseUser user;
    private FirebaseAuth mAuth;

    private Button btn_logout;
    private Button btn_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // back
        ImageView back_icon = findViewById(R.id.user_back_icon);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // back
        TextView back  = findViewById(R.id.user_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null)
        {

            FirebaseUser user = mAuth.getCurrentUser();
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("cards/" + user.getUid());

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    CardDetail card = dataSnapshot.getValue(CardDetail.class);
                    TextView username = findViewById(R.id.userPrompt_name);
                    username.setText(card.getName());
                    TextView bloodType = findViewById(R.id.user_blood);
                    bloodType.setText(card.getBloodType());
                    TextView allergy = findViewById(R.id.user_allergy);
                    allergy.setText(card.getAllergies());
                    TextView disease = findViewById(R.id.user_disease);
                    disease.setText(card.getUnderlyingDisease());

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    //An error, duh!
                }

            });
        }

        this.btn_logout = (Button) findViewById(R.id.btn_logout);
        this.btn_edit = (Button) findViewById(R.id.btn_edit);

        this.btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();

                Intent i = new Intent(UserActivity.this, LoginActivity.class);
                UserActivity.this.startActivity(i);
            }
        });

        this.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserActivity.this, EditContactActivity.class);
                UserActivity.this.startActivity(i);
            }
        });

    }
}
