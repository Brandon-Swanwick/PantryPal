package com.example.pantrypal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import productPack.EntryInfo;

public class SharedViewModel extends ViewModel {
    private ArrayList<EntryInfo> List = new ArrayList<>();

    public void setList(ArrayList<EntryInfo> input) {
//        scanList = input;

        for (int i = 0; i < input.size(); ++i){
            List.add(input.get(i));
        }
    }

    public ArrayList<EntryInfo> getList() {
        return List;
    }

}