package com.example.pantrypal;

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

import productPack.Product;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    public EditText inputText;
    public String apiCallpt1 = "https://api.barcodelookup.com/v3/products?barcode=";
    public String apiCallpt2;
    public String apiCallpt3 = "&formatted=y&key=vxn37no3fnetzu59kum8nkqomj3j7p";
    public String finalapiCall;

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
                Toast.makeText(getContext(),"You Clicked on home",Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);

            }
        });


        binding.editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputText = view.findViewById(R.id.editText);
                apiCallpt2 = inputText.getText().toString();
                finalapiCall = apiCallpt1 + apiCallpt2 + apiCallpt3;

//                Product tempProduct = new Product(finalapiCall);


                Toast.makeText(getContext(),"following api is " + finalapiCall, Toast.LENGTH_LONG).show();
//                Toast.makeText(getContext(),"following api is " + finalapiCall, Toast.LENGTH_LONG).show();
//                Toast.makeText(getContext(),"You entered " + inputText.getText().toString(),Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(),"returned Title: " + tempProduct.getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

