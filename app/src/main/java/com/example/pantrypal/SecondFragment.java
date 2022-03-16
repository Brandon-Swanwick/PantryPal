package com.example.pantrypal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.pantrypal.databinding.FragmentSecondBinding;
import java.net.MalformedURLException;
import java.net.URL;
import productPack.jsonParser;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    EditText editTextNumber;
    String apiCallpt1 = "https://api.barcodelookup.com/v3/products?barcode=";
    String apiCallpt2;
    String apiCallpt3 = "&formatted=y&key=vxn37no3fnetzu59kum8nkqomj3j7p";
    String finalapiCall;
    URL url;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.editTextNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextNumber = getActivity().findViewById(R.id.editTextNumber);
                apiCallpt2 = editTextNumber.getText().toString();
                finalapiCall = apiCallpt1 + apiCallpt2 + apiCallpt3;
                try {
                    URL url = new URL(finalapiCall);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                new jsonParser(url);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}