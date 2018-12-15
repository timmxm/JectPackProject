package com.example.mahti.jetpackproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


// Our customized view holder
// holding all views that we want to show for each item (match with list_item.xml)
// In this case, there are one image view and one text view (both are encapsulated)

public class CardViewHolder extends BaseViewHolder{
    private ImageView card_pic;
    private TextView card_name;
    private TextView cardPrompt_blood;
    private TextView card_blood;
    private TextView cardPrompt_allergy;
    private TextView card_allergy;
    private TextView cardPrompt_disease;
    private TextView card_disease;

    public CardViewHolder(View itemView) {
        super(itemView);
        card_pic = itemView.findViewById(R.id.card_pic);
        card_name = itemView.findViewById(R.id.card_name);
        cardPrompt_blood = itemView.findViewById(R.id.cardPrompt_blood);
        card_blood = itemView.findViewById(R.id.card_blood);
        cardPrompt_allergy = itemView.findViewById(R.id.cardPrompt_allergy);
        card_allergy = itemView.findViewById(R.id.card_allergy);
        cardPrompt_disease = itemView.findViewById(R.id.cardPrompt_disease);
        card_disease = itemView.findViewById(R.id.card_disease);

    }
    public void setcard_pic(int image) {
        card_pic.setImageResource(image);
    }
    public void setcard_name(String text) {
        card_name.setText(text);
    }
    public void setcard_blood(String text) {
        card_blood.setText(text);
    }
    public void setcardPrompt_blood(String text) {
        cardPrompt_blood.setText(text);
    }
    public void setcardPrompt_allergy(String text) {
        cardPrompt_allergy.setText(text);
    }
    public void setcard_allergy(String text) {
        card_allergy.setText(text);
    }
    public void setcardPrompt_disease(String text) {
        cardPrompt_disease.setText(text);
    }
    public void setcard_disease(String text) {
        card_disease.setText(text);
    }
}
