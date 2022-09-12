package com.example.practise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CountryViewHolder> {
    ArrayList<String> countryList;
    ArrayList<String> detailsList;
    ArrayList<Integer> imageList;
    Context context;

    public RecyclerAdapter(ArrayList<String> countryList, ArrayList<String> detailsList, ArrayList<Integer> imageList, Context context) {
        this.countryList = countryList;
        this.detailsList = detailsList;
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

        holder.countryName.setText(countryList.get(position));
        holder.detail.setText(detailsList.get(position));
        holder.imageview.setImageResource(imageList.get(position));
        holder.cardView.setOnClickListener(view -> {
            if(position ==0){
                Toast.makeText(context,"You selected India",Toast.LENGTH_SHORT).
                        show();
            }else if(position == 1){
                Toast.makeText(context,"You selected Australia",Toast.LENGTH_SHORT).
                        show();
            }else if(position == 2){
                Toast.makeText(context,"You selected United Kingdom",Toast.LENGTH_SHORT).
                        show();
            }else if(position ==3){
                Toast.makeText(context,"You selected Italy",Toast.LENGTH_SHORT).
                        show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryName,detail;
        ImageView imageview;
        CardView cardView;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.cname);
            detail = itemView.findViewById(R.id.detail);
            imageview = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
