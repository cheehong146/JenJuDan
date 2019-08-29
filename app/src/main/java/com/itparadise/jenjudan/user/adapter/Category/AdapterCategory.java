package com.itparadise.jenjudan.user.adapter.Category;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.user.activity.P_Productpage;
import com.itparadise.jenjudan.user.activity.P_Store;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by itparadise on 22/8/2019
 **/
public class AdapterCategory extends  RecyclerView.Adapter<AdapterCategory.ViewHolder> {

    private ArrayList<String> CategNames = new ArrayList<>();
    private ArrayList<String> CategLocation = new ArrayList<>();
    private ArrayList<String> CategImageUrls = new ArrayList<>();
    private Context aContext;

    public AdapterCategory(ArrayList<String> categNames, ArrayList<String> categLocation, ArrayList<String> categImageUrls, Context aContext) {
        CategNames = categNames;
        CategLocation = categLocation;
        CategImageUrls = categImageUrls;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public AdapterCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.col_home_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCategory.ViewHolder holder, final int position) {

        Glide.with(aContext)
                .asBitmap()
                .load(CategImageUrls.get(position))
                .into(holder.image);

        holder.name.setText(CategNames.get(position));
        holder.location.setText(CategLocation.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = view.getContext();
                final Intent intent = new Intent(context, P_Store.class);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return CategImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView image;
        TextView name, location;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_category);
            name = itemView.findViewById(R.id.tv_category_name);
            location = itemView.findViewById(R.id.tv_category_location);        }
    }

}
