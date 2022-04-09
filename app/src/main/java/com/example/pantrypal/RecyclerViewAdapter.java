package com.example.pantrypal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import productPack.EntryInfo;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    // mImages
    private ArrayList<String> productImages = new ArrayList<>();

    // mImageNames
    private ArrayList<String> productNames = new ArrayList<>();

    // context
    private Context mContext;

    private Activity act;

    // info string
    private ArrayList<String> productInfoString = new ArrayList<>();

    public RecyclerViewAdapter(Context mContext, ArrayList<String> productImages, ArrayList<String> productNames, ArrayList<String> productInfoString , Activity act) {
        this.productImages = productImages;
        this.productNames = productNames;
        this.mContext = mContext;
        this.productInfoString = productInfoString;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext)
                .asBitmap()
                .load(productImages.get(position))
                .into(holder.productImage);

        holder.productName.setText(productNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on " + productNames.get(position));

                Toast.makeText(mContext, productNames.get(position),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, DetailedActivity.class);
                intent.putExtra("image_url", productImages.get(position));
                intent.putExtra("entry_info", productInfoString.get(position));
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return productNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView productImage;
        TextView productName;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.image);
            productName = itemView.findViewById(R.id.product_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
