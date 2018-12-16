package com.example.mahti.jetpackproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


public class UserActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private Button btn_logout;
    private Button btn_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

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
