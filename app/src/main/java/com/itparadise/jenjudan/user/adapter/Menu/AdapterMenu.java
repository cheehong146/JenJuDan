package com.itparadise.jenjudan.user.adapter.Menu;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.user.fragment.Menu.FragmentReward;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

/**
 * Created by itparadise on 22/8/2019
 **/
public class AdapterMenu extends  RecyclerView.Adapter<AdapterMenu.ViewHolder> {

    private ArrayList<String> MenuUrls;
    private ArrayList<String> MenuName;
    private ArrayList<String> MenuPrice;

    private Context aContext;

    public AdapterMenu(ArrayList<String> menuName, ArrayList<String> menuPrice, ArrayList<String> menuUrls, Context aContext) {
        MenuUrls = menuUrls;
        MenuName = menuName;
        MenuPrice = menuPrice;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public AdapterMenu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMenu.ViewHolder holder, final int position) {

        Glide.with(aContext)
                .asBitmap()
                .load(MenuUrls.get(position))
                .into(holder.image);

        holder.name.setText(MenuName.get(position));
        holder.price.setText(MenuPrice.get(position));


        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentReward fragmentReward = new FragmentReward();
                loadFragment(fragmentReward,activity);

            }
        });

    }

    @Override
    public int getItemCount() {
        return MenuUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView image;
        TextView name, price;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_menu);
            name = itemView.findViewById(R.id.tv_menu_name);
            price = itemView.findViewById(R.id.tv_menu_price);
        }
    }

    private void loadFragment(Fragment fragment, AppCompatActivity activity) {

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.vp_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
