package com.itparadise.jenjudan.user.adapter.Menu;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.itparadise.jenjudan.R;

import java.util.ArrayList;

/**
 * Created by itparadise on 22/8/2019
 **/
public class AdapterCategory extends  RecyclerView.Adapter<AdapterCategory.ViewHolder> {

    private ArrayList<String> MenuCategoryUrls;
    private ArrayList<String> MenuCategoryName;
    private Context aContext;

    public AdapterCategory(ArrayList<String> menuCategoryName, ArrayList<String> menuCategoryUrls, Context aContext) {
        MenuCategoryUrls = menuCategoryUrls;
        MenuCategoryName = menuCategoryName;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public AdapterCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.col_menu_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCategory.ViewHolder holder, final int position) {

        Glide.with(aContext)
                .asBitmap()
                .load(MenuCategoryUrls.get(position))
                .into(holder.image);

        holder.name.setText(MenuCategoryName.get(position));

/*
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = view.getContext();
                final Intent intent = new Intent(context, P_Store.class);
                context.startActivity(intent);

            }
        });
        */
    }

    @Override
    public int getItemCount() {
        return MenuCategoryUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_category);
            name = itemView.findViewById(R.id.tv_category_name);
        }
    }

}
