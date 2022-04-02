package com.example.pantrypal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import productPack.EntryInfo;

public class SharedViewModel extends ViewModel {
    private ArrayList<EntryInfo> scanList = new ArrayList<>();

    public void setList(ArrayList<EntryInfo> input) {
        scanList = input;
    }

    public ArrayList<EntryInfo> getList() {
        return scanList;
    }

}