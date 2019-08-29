package com.itparadise.jenjudan.user.adapter.Menu;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
public class AdapterCart extends  RecyclerView.Adapter<AdapterCart.ViewHolder> {

    private ArrayList<String> CartAmount;
    private ArrayList<String> CartName;
    private ArrayList<String> CartPrice;
    private Context aContext;

    public AdapterCart(ArrayList<String> cartAmount, ArrayList<String> cartName, ArrayList<String> cartPrice, Context aContext) {
        CartAmount = cartAmount;
        CartName = cartName;
        CartPrice = cartPrice;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public AdapterCart.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCart.ViewHolder holder, final int position) {

        holder.amount.setText(CartAmount.get(position));
        holder.name.setText(CartName.get(position));
        holder.price.setText(CartPrice.get(position));

    }

    @Override
    public int getItemCount() {
        return CartName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView amount, name, price;

        public ViewHolder(View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.cart_amount);
            name = itemView.findViewById(R.id.cart_name);
            price = itemView.findViewById(R.id.cart_price);
        }
    }

}
