package com.itparadise.jenjudan.user.adapter.Features;

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
import com.itparadise.jenjudan.user.activity.P_Setting;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

/**
 * Created by itparadise on 22/8/2019
 **/
public class AdapterFeatures extends  RecyclerView.Adapter<AdapterFeatures.ViewHolder> {


    private ArrayList<String> aNames;
    private ArrayList<String> aImageUrls;
    private Context aContext;

    public AdapterFeatures(ArrayList<String> aNames, ArrayList<String> aImageUrls, Context aContext) {
        this.aNames = aNames;
        this.aImageUrls = aImageUrls;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public AdapterFeatures.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.col_home_feature, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFeatures.ViewHolder holder, final int position) {

        Glide.with(aContext)
                .asBitmap()
                .load(aImageUrls.get(position))
                .into(holder.image);

        holder.name.setText(aNames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(aContext, aNames.get(position), Toast.LENGTH_SHORT).show();

                Context context = view.getContext();
                final Intent intent = new Intent(context, P_Productpage.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return aImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_feature);
            name = itemView.findViewById(R.id.tv_feature_name);
        }
    }

}
