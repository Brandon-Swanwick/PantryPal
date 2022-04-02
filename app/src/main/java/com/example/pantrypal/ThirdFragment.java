package com.example.pantrypal;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pantrypal.databinding.FragmentThirdBinding;

import java.util.ArrayList;

import productPack.EntryInfo;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    public TextView groceryList;

    private ArrayList<EntryInfo> scannedList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Activity act = getActivity();
        if (act instanceof MainActivity){
            scannedList = ((MainActivity) act).getScannedList();
            if (!scannedList.isEmpty()) {
                Toast.makeText(getContext(), "List gathered from main is " + scannedList.get(0).getDataObj().products[0].title, Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getContext(), "Empty list was passed from main activity", Toast.LENGTH_SHORT).show();
        }

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}