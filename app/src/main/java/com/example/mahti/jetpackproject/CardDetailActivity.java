package com.example.mahti.jetpackproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CardDetailActivity extends AppCompatActivity {

    private TextView Ccard_name,Ccard_blood,Ccard_allergy, Ccard_disease, Back_button;
    private ImageView Ccard_pic, Back_icon, Phone_num;
    String phone_string;

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);

        Back_button = (TextView) findViewById(R.id.detail_back);
        Back_icon = (ImageView) findViewById(R.id.detail_back_icon);

        Ccard_name = (TextView) findViewById(R.id.detailPrompt_name);
        Ccard_blood = (TextView) findViewById(R.id.detail_blood);
        Ccard_allergy = (TextView) findViewById(R.id.detail_allergy);
        Ccard_disease = (TextView) findViewById(R.id.detail_disease);

        Ccard_pic = (ImageView) findViewById(R.id.detail_img);

        Phone_num = (ImageView) findViewById(R.id.btn_call);
        // Recieve data
        Intent intent = getIntent();
        String card_name = intent.getExtras().getString("card_name");
        String card_blood = intent.getExtras().getString("card_blood");
        String card_allergy = intent.getExtras().getString("card_allergy");
        String card_disease = intent.getExtras().getString("card_disease");
        int image = intent.getExtras().getInt("card_pic") ;
        phone_string = getIntent().getExtras().getString("phone_number") + "";

        Ccard_name.setText(card_name);
        Ccard_blood.setText(card_blood);
        Ccard_allergy.setText(card_allergy);
        Ccard_disease.setText(card_disease);
        Ccard_pic.setImageResource(image);

        Back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CardDetailActivity.this, MainActivity.class);
                CardDetailActivity.this.startActivity(myIntent);
            }
        });

        Back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CardDetailActivity.this, MainActivity.class);
                CardDetailActivity.this.startActivity(myIntent);
            }
        });

        Phone_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phone_string;
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

    }

}
