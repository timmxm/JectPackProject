package com.example.mahti.jetpackproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class UserActivity extends AppCompatActivity {

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
