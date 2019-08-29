package com.itparadise.jenjudan.user.adapter.Redemption;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.user.Dialog.Dialog_Redeem2;
import com.itparadise.jenjudan.user.activity.P_Store;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

/**
 * Created by itparadise on 22/8/2019
 **/
public class AdapterRedemption extends  RecyclerView.Adapter<AdapterRedemption.ViewHolder> {

    private ArrayList<String> RedeemImageUrls;
    private Context aContext;

    public AdapterRedemption(ArrayList<String> redeemImageUrls, Context aContext) {
        RedeemImageUrls = redeemImageUrls;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public AdapterRedemption.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_redeem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRedemption.ViewHolder holder, final int position) {

        Glide.with(aContext)
                .asBitmap()
                .load(RedeemImageUrls.get(position))
                .into(holder.image);


        holder.redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                LayoutInflater layoutInflater = (LayoutInflater) aContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view1 = layoutInflater.inflate(R.layout.activity_main, null);
                BottomNavigationView bottomNavigationView = view1.findViewById(R.id.navigation);
                bottomNavigationView.setBackgroundColor(aContext.getResources().getColor(R.color.transparent));
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Dialog_Redeem2 redeemDialog = new Dialog_Redeem2();
                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.cv_main, redeemDialog);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return RedeemImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        Button redeem;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_redeem);
            redeem = itemView.findViewById(R.id.btn_redeem);
        }
    }

}
