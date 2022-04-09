package com.example.pantrypal;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pantrypal.databinding.FragmentSecondBinding;
import com.example.pantrypal.databinding.FragmentThirdBinding;

import java.util.ArrayList;

import productPack.EntryInfo;


public class FourthFragment extends Fragment {

    // Used for linking fragments to activity
    private FragmentThirdBinding binding;

    private ArrayList<String> productNames;
    private ArrayList<String> productImages;

    //
    private ArrayList<String> productInfoString;
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    private static final String TAG = "ThirdFragment";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.fragment_fourth,container,false);

        productImages = new ArrayList<>();
        productNames = new ArrayList<>();

        productInfoString = new ArrayList<>();



        initImageBitmaps();

        recyclerView = view.findViewById(R.id.recycler_view);
        Activity act = getActivity();

        adapter = new RecyclerViewAdapter(view.getContext(), productImages,productNames, productInfoString , ((MainActivity) act));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        Log.d(TAG, "onCreateView: within fragment 4 is called");

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        Activity act = getActivity();
        if (act instanceof MainActivity) {
            for (int i = 0; i < ((MainActivity) act).getScannedList().size(); ++i) {
                productNames.add(((MainActivity) act).getScannedList().get(i).getDataObj().products[0].title);
                productImages.add(((MainActivity) act).getScannedList().get(i).getDataObj().products[0].images[0]);


                productInfoString.add("Title: " +((MainActivity) act).getScannedList().get(i).getDataObj().products[0].title
                        + "\n\nBrand: " + ((MainActivity) act).getScannedList().get(i).getDataObj().products[0].brand
                        + "\n\nBarcode Number: " + ((MainActivity) act).getScannedList().get(i).getDataObj().products[0].barcode_number);

            }
        }
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }
}