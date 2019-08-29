package com.itparadise.jenjudan.user.adapter.Redemption;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.user.Dialog.Dialog_Redeem2;

import java.util.ArrayList;

/**
 * Created by itparadise on 22/8/2019
 **/
public class AdapterRedemptionAll extends  RecyclerView.Adapter<AdapterRedemptionAll.ViewHolder> {

    private  static final String TAG = "AdapterRedemptions";

    private ArrayList<String> RedeemImageUrls;
    private Context aContext;

    public AdapterRedemptionAll(ArrayList<String> redeemImageUrls, Context aContext) {
        RedeemImageUrls = redeemImageUrls;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public AdapterRedemptionAll.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_redeem_all, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRedemptionAll.ViewHolder holder, final int position) {

        Log.d(TAG, "onCreateViewHolder: called");

        Glide.with(aContext)
                .asBitmap()
                .load(RedeemImageUrls.get(position))
                .into(holder.image);


        holder.redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*
                final Dialog dialog = new Dialog(aContext);
                dialog.setContentView(R.layout.dialog_redeem2);
                dialog.setTitle("Title...");
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.show();

                Intent intent = new Intent(aContext, Dialogtest.class);
                aContext.startActivity(intent);

                WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
                lp.dimAmount=0.0f;
                dialog.getWindow().setAttributes(lp);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                //dialog.show();
*/


/*
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Dialog_Redeem redeemDialog = new Dialog_Redeem();
                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.vp_main, redeemDialog);
                transaction.addToBackStack(null);
                transaction.commit();
*/

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

/*
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Dialog_Redeem dialog_redeem = new Dialog_Redeem();
                dialog_redeem.show(activity.getSupportFragmentManager(), dialog_redeem.getClass().getSimpleName());
*/
/*
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Dialogtest dialogtest = new Dialogtest(activity);
                dialogtest.show();
                */

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
            Log.d(TAG, "onCreateViewHolder: holder");
            image = itemView.findViewById(R.id.iv_redeem);
            redeem = itemView.findViewById(R.id.btn_redeem);
        }
    }

}
