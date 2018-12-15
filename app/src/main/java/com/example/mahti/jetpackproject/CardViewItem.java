package com.example.mahti.jetpackproject;

// Our customized item used to get/set information of view that we want to show

public class CardViewItem extends BaseItem {

    private int card_pic;
    private String card_name;
    private String cardPrompt_blood;
    private String card_blood;
    private String cardPrompt_allergy;
    private String card_allergy;
    private String cardPrompt_disease;
    private String card_disease;

    public CardViewItem() {
        super(ViewType.TYPE_CARD_VIEW);
    }

    public int getcard_pic() {
        return card_pic;
    }

    public CardViewItem setcard_pic(int card_pic) {
        this.card_pic = card_pic;
        return this;
    }

    public String getcard_name() {
        return card_name;
    }

    public CardViewItem setcard_name(String card_name) {
        this.card_name = card_name;
        return this;
    }

    public String getcardPrompt_blood() {
        return cardPrompt_blood;
    }

    public CardViewItem setcardPrompt_blood(String cardPrompt_blood) {
        this.cardPrompt_blood = cardPrompt_blood;
        return this;
    }

    public String getcard_blood() {
        return card_blood;
    }

    public CardViewItem setcard_blood(String card_blood) {
        this.card_blood = card_blood;
        return this;
    }

    public String getcardPrompt_allergy() {
        return cardPrompt_allergy;
    }

    public CardViewItem setcardPrompt_allergy(String cardPrompt_allergy) {
        this.cardPrompt_allergy = cardPrompt_allergy;
        return this;
    }

    public String getcard_allergy() {
        return card_allergy;
    }

    public CardViewItem setcard_allergy(String card_allergy) {
        this.card_allergy = card_allergy;
        return this;
    }

    public String getcardPrompt_disease() {
        return cardPrompt_disease;
    }

    public CardViewItem setcardPrompt_disease(String cardPrompt_disease) {
        this.cardPrompt_disease = cardPrompt_disease;
        return this;
    }

    public String getcard_disease() {
        return card_disease;
    }

    public CardViewItem setcard_disease(String card_disease) {
        this.card_disease = card_disease;
        return this;
    }
}
