package com.example.mahti.jetpackproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class EditContactActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private FirebaseUser user;
    private FirebaseDatabase database;
    private FirebaseStorage storage;
    private EditText name;
    private Spinner bloodType;
    private EditText allergy;
    private EditText disease;
    private EditText phone;
    private ImageView cardImage;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        // back
        ImageView back_icon = findViewById(R.id.edit_back_icon);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // back
        TextView back  = findViewById(R.id.edit_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initView();
    }

    private void initView() {
        Button submitBtn = findViewById(R.id.btn_edit_confirm);
        this.cardImage = findViewById(R.id.edit_img);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editContact();
            }
        });
        this.cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImage();
            }
        });

        this.user = FirebaseAuth.getInstance().getCurrentUser();
        this.database = FirebaseDatabase.getInstance();
        this.storage = FirebaseStorage.getInstance();

        this.name = findViewById(R.id.edit_name);
        this.bloodType = findViewById(R.id.edit_blood);
        this.allergy = findViewById(R.id.edit_allergy);
        this.disease = findViewById(R.id.edit_disease);
        this.phone = findViewById(R.id.edit_phone);


        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.bloodType_array, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.bloodType.setAdapter(myAdapter);
        this.bloodType.setOnItemSelectedListener(this);
    }

    private void editContact() {
        if(this.name.getText().length() == 0){
            this.toast("Name is empty");
            return;
        }

        if(this.phone.getText().length() == 0){
            this.toast("Emergency Phone is empty");
            return;
        }

        upload();

        DatabaseReference cardRef = this.database.getReference("cards");
        cardRef.child(this.user.getUid()).child("name").setValue(this.name.getText().toString());
        cardRef.child(this.user.getUid()).child("bloodType").setValue(this.bloodType.getSelectedItem().toString());
        cardRef.child(this.user.getUid()).child("allergies").setValue(this.allergy.getText().toString());
        cardRef.child(this.user.getUid()).child("underlyingDisease").setValue(this.disease.getText().toString());
        cardRef.child(this.user.getUid()).child("phoneNumber").setValue(this.phone.getText().toString());

        finish();
    }

    private void getImage() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, 1);
    }

    private void upload() {
        StorageReference storageRef = this.storage.getReference("images");
        StorageReference imgRef = storageRef.child("images");

        if(this.imageUri != null) {
            StorageReference fileRef = storageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(this.imageUri));
            fileRef.putFile(this.imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(EditContactActivity.this, "Upload successful",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("cards");
                            myRef.child(user.getUid() + "/" + "imageUrl").setValue(taskSnapshot.getUploadSessionUri().toString());
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(EditContactActivity.this, "Upload failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            this.toast("No file selected");
        }
    }

    private void toast(String message) {
        Toast.makeText(EditContactActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        if(resultCode == RESULT_OK) {
            super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
            this.cardImage.setImageURI(imageReturnedIntent.getData());
            this.imageUri = imageReturnedIntent.getData();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        this.bloodType.getItemAtPosition(0);
    }
}
