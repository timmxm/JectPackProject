package com.example.mahti.jetpackproject;

public class CardDetail {
    private String card_name;
    private String cardPrompt_blood;
    private String card_blood;
    private String cardPrompt_allergy;
    private String card_allergy;
    private String cardPrompt_disease;
    private String card_disease;
    private int card_pic;
    private String phone_number;

    public CardDetail() {
    }

    public CardDetail(String card_name, String card_blood, String card_allergy, String card_disease, int card_pic,String phone_number) {
        this.card_name = card_name;
        this.card_blood = card_blood;
        this.card_allergy = card_allergy;
        this.card_disease = card_disease;
        this.card_pic = card_pic;
        this.phone_number = phone_number;
    }


    public String getcard_name() {
        return this.card_name;
    }

    public String getcardPrompt_blood() {
        return this.cardPrompt_blood;
    }

    public String getcard_blood() {
        return this.card_blood;
    }

    public String getcardPrompt_allergy() {
        return this.cardPrompt_allergy;
    }

    public String getcard_allergy() {
        return this.card_allergy;
    }

    public String getcardPrompt_disease() {
        return this.cardPrompt_disease;
    }

    public String getcard_disease() {
        return this.card_disease;
    }

    public int getcard_pic() {
        return this.card_pic;
    }

    public String getphone_number() {
        return this.phone_number;
    }


    public void setcard_name(String card_name) {
        this.card_name = card_name;
    }

    public void setcardPrompt_blood(String cardPrompt_blood) {
        this.cardPrompt_blood = cardPrompt_blood;
    }

    public void setcard_blood(String card_blood) {
        this.card_blood = card_blood;
    }

    public void setcardPrompt_allergy(String cardPrompt_allergy) {
        this.cardPrompt_allergy = cardPrompt_allergy;
    }

    public void setcard_allergy(String card_allergy) {
        this.card_allergy = card_allergy;
    }

    public void setcardPrompt_disease(String cardPrompt_disease) {
        this.cardPrompt_disease = cardPrompt_disease;
    }

    public void setcard_disease(String card_disease) {
        this.card_disease = card_disease;
    }

    public void setcard_pic(int card_pic) {
        this.card_pic = card_pic;
    }

    public void setphone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
