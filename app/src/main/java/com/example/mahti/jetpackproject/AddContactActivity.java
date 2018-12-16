package com.example.mahti.jetpackproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class AddContactActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private FirebaseUser user;
    private FirebaseDatabase database;
    private FirebaseStorage storage;
    private EditText name;
    private Spinner bloodType;
    private EditText allergy;
    private EditText disease;
    private EditText phone;
    private ImageView cardImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        initView();
    }

    private void initView() {
        Button submitBtn = findViewById(R.id.btn_add_regist);
        this.cardImage = findViewById(R.id.detail_img);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });
        this.cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload();
            }
        });

        this.user = FirebaseAuth.getInstance().getCurrentUser();
        this.database = FirebaseDatabase.getInstance();
        this.storage = FirebaseStorage.getInstance();

        this.name = findViewById(R.id.add_name);
        this.bloodType = findViewById(R.id.add_blood);
        this.allergy = findViewById(R.id.add_allergy);
        this.disease = findViewById(R.id.add_disease);
        this.phone = findViewById(R.id.add_phone);


        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.bloodType_array, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.bloodType.setAdapter(myAdapter);
        this.bloodType.setOnItemSelectedListener(this);
    }

    private void addContact() {
        if(this.name.getText().length() == 0) {
            this.toast("Name is empty");
            return;
        }

        if(this.phone.getText().length() == 0) {
            this.toast("Emergency Phone is empty");
            return;
        }

        DatabaseReference myRef = this.database.getReference("cards");
        myRef.child(this.user.getUid()).child("name").setValue(this.name.getText().toString());
        myRef.child(this.user.getUid()).child("bloodType").setValue(this.bloodType.getSelectedItem().toString());
        myRef.child(this.user.getUid()).child("allergies").setValue(this.allergy.getText().toString());
        myRef.child(this.user.getUid()).child("underlyingDisease").setValue(this.disease.getText().toString());
        myRef.child(this.user.getUid()).child("phoneNumber").setValue(this.phone.getText().toString());
    }

    private void upload() {
        StorageReference storageRef = this.storage.getReference();
        StorageReference imgRef = storageRef.child("images");

        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, 1);
    }

    private void toast(String message) {
        Toast.makeText(AddContactActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        this.cardImage.setImageURI(imageReturnedIntent.getData());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        this.bloodType.getItemAtPosition(0);
    }
}
