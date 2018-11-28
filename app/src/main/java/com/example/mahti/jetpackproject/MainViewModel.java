package com.example.mahti.jetpackproject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> TestData;
    public MutableLiveData<String> getTestData() {
        if(TestData == null) {
            TestData = new MutableLiveData<String>();
        }
        return TestData;
    }
}
