package com.itparadise.jenjudan.user.adapter.Menu;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itparadise.jenjudan.R;

import java.util.ArrayList;

/**
 * Created by itparadise on 22/8/2019
 **/
public class AdapterPaymentHistory extends  RecyclerView.Adapter<AdapterPaymentHistory.ViewHolder> {

    private ArrayList<String> PayName;
    private ArrayList<String> PayDetails;
    private ArrayList<String> PayAmount;
    private Context aContext;

    public AdapterPaymentHistory(ArrayList<String> payName, ArrayList<String> payDetails, ArrayList<String> payAmount, Context aContext) {
        PayName = payName;
        PayDetails = payDetails;
        PayAmount = payAmount;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public AdapterPaymentHistory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_payment_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPaymentHistory.ViewHolder holder, final int position) {

        holder.amount.setText(PayAmount.get(position));
        holder.name.setText(PayName.get(position));
        holder.detail.setText(PayDetails.get(position));

    }

    @Override
    public int getItemCount() {
        return PayAmount.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView amount, name, detail;

        public ViewHolder(View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.payment_price);
            name = itemView.findViewById(R.id.payment_name);
            detail = itemView.findViewById(R.id.purchase_detail);
        }
    }

}
