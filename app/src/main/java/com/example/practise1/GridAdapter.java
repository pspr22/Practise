package com.example.practise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> text;
    ArrayList<Integer> image;

    public GridAdapter( ArrayList<String> text, ArrayList<Integer> image,Context context) {
        this.context = context;
        this.text = text;
        this.image = image;
    }


    @Override
    public int getCount() {
        return text.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View views = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview,viewGroup,false);
        TextView textView = views.findViewById(R.id.textView);
        ImageView imageview = views.findViewById(R.id.imageview);
        textView.setText(text.get(i));
        imageview.setImageResource(image.get(i));
        return views;
    }
}
