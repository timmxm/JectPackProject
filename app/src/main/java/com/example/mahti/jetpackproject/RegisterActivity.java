package com.example.mahti.jetpackproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btn_regist_next;
    private Button btn_regist_backt;

    private EditText regist_email;
    private EditText resigt_pass;
    private EditText resigt_pass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        this.btn_regist_next = (Button) findViewById(R.id.btn_regist_next);
        this.btn_regist_backt = (Button) findViewById(R.id.btn_regist_back);

        this.regist_email = (EditText) findViewById(R.id.regist_email);
        this.resigt_pass = (EditText) findViewById(R.id.resigt_pass);
        this.resigt_pass2 = (EditText) findViewById(R.id.resigt_pass2);

        this.btn_regist_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

        this.btn_regist_backt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(i);
            }
        });
    }

    public void submit(){

            if(this.regist_email.getText().length() == 0){
                Toast.makeText(RegisterActivity.this, "Email is empty.",
                        Toast.LENGTH_SHORT).show();

                return;
            }


            if(this.resigt_pass.getText().length() == 0){
                Toast.makeText(RegisterActivity.this, "Password is empty.",
                        Toast.LENGTH_SHORT).show();

                return;
            }


            if(this.resigt_pass2.getText().length() == 0){
                Toast.makeText(RegisterActivity.this, "Password is empty.",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            String email = this.regist_email.getText().toString();
            String password = this.resigt_pass.getText().toString();
            String password2 = this.resigt_pass2.getText().toString();


            Log.d("auth",password);
            Log.d("auth",password2);


            if(password.equals(password2) == false){
                Toast.makeText(RegisterActivity.this, "Password not match.",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("auth", "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();

                                Intent i = new Intent(RegisterActivity.this, AddContactActivity.class);
                                RegisterActivity.this.startActivity(i);

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("auth", "signInWithEmail:failure", task.getException());
                                Toast.makeText(RegisterActivity.this, task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });

    }

}
