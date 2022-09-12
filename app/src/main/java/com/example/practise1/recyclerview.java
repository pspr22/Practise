package com.example.practise1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class recyclerview extends AppCompatActivity {


    ArrayList<String> countryList = new ArrayList<>();
    ArrayList<String> detailsList = new ArrayList<>();
    ArrayList<Integer> imageList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerview.this));

        countryList.add("India");
        countryList.add("Australia");
        countryList.add("United Kingdom");
        countryList.add("Italy");

        detailsList.add("This is an Indian Flag");
        detailsList.add("This is an Australian Flag");
        detailsList.add("This is an United Kingdom Flag");
        detailsList.add("This is an Italy Flag");

        imageList.add(R.drawable.india);
        imageList.add(R.drawable.australia);
        imageList.add(R.drawable.uk);
        imageList.add(R.drawable.italy);

        adapter = new RecyclerAdapter(countryList,detailsList,imageList,recyclerview.this);
        recyclerView.setAdapter(adapter);
    }
}