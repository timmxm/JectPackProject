package com.example.mahti.jetpackproject;

public class CardDetail {
    /*private String card_name;
    private String cardPrompt_blood;
    private String card_blood;
    private String cardPrompt_allergy;
    private String card_allergy;
    private String cardPrompt_disease;
    private String card_disease;
    private int card_pic;
    private String phone_number;*/

    private String name;
    private String bloodType;
    private String allergies;
    private String underlyingDisease;
    private String phoneNumber;
    private int picture;

    public CardDetail()
    {

    }

    public CardDetail(String name, String bloodType, String allergies, String underlyingDisease, String phoneNumber, int picture) {
        this.name = name;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.underlyingDisease = underlyingDisease;
        this.phoneNumber = phoneNumber;
        this.picture = picture;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBloodType()
    {
        return  bloodType;
    }

    public void setBloodType(String bloodType)
    {
        this.bloodType = bloodType;
    }

    public String getAllergies()
    {
        return allergies;
    }

    public void setAllergies(String allergies)
    {
        this.allergies = allergies;
    }

    public String getUnderlyingDisease(){
        return underlyingDisease;
    }

    public void setUnderlyingDisease(String underlyingDisease)
    {
        this.underlyingDisease = underlyingDisease;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public int getPicture()
    {
        return picture;
    }

    public void setPicture(int picture)
    {
        this.picture = picture;
    }
}
