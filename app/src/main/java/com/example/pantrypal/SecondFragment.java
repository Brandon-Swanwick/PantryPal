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

import com.example.pantrypal.databinding.FragmentSecondBinding;

import java.util.ArrayList;

import productPack.EntryInfo;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    public EditText inputText;
    public String apiCallpt1 = "https://api.barcodelookup.com/v3/products?barcode=";
    public String apiCallpt2;
    public String apiCallpt3 = "&formatted=y&key=elpbe6u5zexop902y2iyxdfu11t0o2";
    public String finalapiCall;
    public Activity act = getActivity();
    private ArrayList<EntryInfo> tempList = new ArrayList<>();




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonFirst.setOnClickListener(view1 -> {
            Toast.makeText(getContext(),"You Clicked on home",Toast.LENGTH_SHORT).show();
            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment);

        });

        binding.buttonSecond.setOnClickListener(view12 -> {
            if (act != null){
               tempList = ((MainActivity) act).getScanList();
                Log.d("mere", "title from copied list from main is " + tempList.get(0).getDataObj().products[0].title);
            }
            else
                Log.d("mere1", "act == null");
//            if (tempList.get(tempList.size()-1).getDataObj() != null) {
//                Toast.makeText(getContext(), "product with found with barcode", Toast.LENGTH_LONG).show();
//            }
//            else
//                Toast.makeText(getContext(), "product not found with barcode", Toast.LENGTH_LONG).show();
//                ((MainActivity) act).removeEntry(((MainActivity) act).getScanList().size()-1);
        });

        binding.editText.setOnClickListener(view13 -> {

            inputText = view13.findViewById(R.id.editText);
            apiCallpt2 = inputText.getText().toString();
            finalapiCall = apiCallpt1 + apiCallpt2 + apiCallpt3;
            EntryInfo tempEntry = new EntryInfo(finalapiCall);
            if (act != null) {
                Log.d("xd1212", "act is != NULL");
                ((MainActivity) act).addEntry(tempEntry);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

