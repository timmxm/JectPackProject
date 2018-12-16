package com.example.mahti.jetpackproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditContactActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editContact();
            }
        });

        Spinner bloodTypeSpinner = findViewById(R.id.add_blood);
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.bloodType_array, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodTypeSpinner.setAdapter(myAdapter);
        bloodTypeSpinner.setOnItemSelectedListener(this);
    }

    private void editContact() {
        EditText addName = findViewById(R.id.edit_name);
        Spinner bloodType = findViewById(R.id.edit_blood);
        EditText addAllergy = findViewById(R.id.edit_allergy);
        EditText addDisease = findViewById(R.id.edit_disease);
        EditText addPhone = findViewById(R.id.edit_phone);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("cards");
        myRef.child("user1").child("name").setValue(addName.getText().toString());
        myRef.child("user1").child("bloodType").setValue(bloodType.getSelectedItem().toString());
        myRef.child("user1").child("allergies").setValue(addAllergy.getText().toString());
        myRef.child("user1").child("underlyingDisease").setValue(addDisease.getText().toString());
        myRef.child("user1").child("phoneNumber").setValue(addPhone.getText().toString());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
