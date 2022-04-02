package com.example.pantrypal;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pantrypal.databinding.FragmentSecondBinding;

import java.util.ArrayList;

import productPack.EntryInfo;


public class SecondFragment extends Fragment {

    // Used for linking fragments to activity
    private FragmentSecondBinding binding;

    // variables for view model (communication for fragment -> fragment)

    // variables used for setting up get req from API
    public EditText inputText;
    public String apiCallpt1 = "https://api.barcodelookup.com/v3/products?barcode=";
    public String apiCallpt2;
    public String apiCallpt3 = "&formatted=y&key=elpbe6u5zexop902y2iyxdfu11t0o2";
    public String finalapiCall;

    // scanned products list (updated on success from API get req, otherwise no entry is added
    private ArrayList<EntryInfo> tempList = new ArrayList<>();
    EntryInfo tempEntry;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(view1 -> {
            Toast.makeText(getContext(),"You Clicked on home",Toast.LENGTH_SHORT).show();

            Activity act = getActivity();
            if (act instanceof MainActivity){
                ((MainActivity) act).updateScannedList(tempList);
                Toast.makeText(getContext(),"sent temp list to main",Toast.LENGTH_SHORT).show();
            }


            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment);

        });

        binding.buttonSecond.setOnClickListener(view12 -> {
            if (tempEntry.getDataObj() != null){
                Toast.makeText(getContext(),"product was found in database", Toast.LENGTH_LONG).show();
                tempList.add(tempEntry);
                Toast.makeText(getContext(),"Title of most recent product" + tempList.get(tempList.size()-1).getDataObj().products[0].title,Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getContext(),"product was NOT found in database, Failed to add entry", Toast.LENGTH_LONG).show();
        });

        binding.editText.setOnClickListener(view13 -> {

            inputText = view13.findViewById(R.id.editText);
            apiCallpt2 = inputText.getText().toString();
            finalapiCall = apiCallpt1 + apiCallpt2 + apiCallpt3;
            tempEntry = new EntryInfo(finalapiCall);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

