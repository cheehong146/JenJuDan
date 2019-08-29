package com.itparadise.jenjudan.user.adapter.Tutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.itparadise.jenjudan.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    public int[] images = {
            R.drawable.tutorial1,
            R.drawable.tutorial2,
            R.drawable.tutorial3
    };

    public  String[] headings = {
            "Het Geruime Tadeen",
            "Het Geruime Tadeen",
            "Het Geruime Tadeen"
    };

    public  String[] desc = {
            "Larem Ipdum dolor sit amet, consectetur/nadipiscielit, sed do eiusmod tempar incididunt/nlabore et dolare magna aliqua.",
            "Larem Ipdum dolor sit amet, consectetur/nadipiscielit, sed do eiusmod tempar incididunt/nlabore et dolare magna aliqua.",
            "Larem Ipdum dolor sit amet, consectetur/nadipiscielit, sed do eiusmod tempar incididunt/nlabore et dolare magna aliqua."
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView iv = view.findViewById(R.id.slider_image);
        TextView tvhead = view.findViewById(R.id.slider_heading);
        TextView tvdesc = view.findViewById(R.id.slider_desc);

        iv.setImageResource(images[position]);
        tvhead.setText(headings[position]);
        tvdesc.setText(desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
