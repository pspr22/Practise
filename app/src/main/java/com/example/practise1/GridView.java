package com.example.practise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class GridView extends AppCompatActivity {

    android.widget.GridView gridView;
    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.gridview);
        fillArray();
        GridAdapter adapter = new GridAdapter(text,image,this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(gridView,"You selected "+text.get(i),Snackbar.LENGTH_INDEFINITE)
                        .setAction("Close", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
            }
        });
    }

    public void fillArray(){
        text.add("facebook");
        text.add("instagram");
        text.add("whatsapp");
        text.add("telegram");
        text.add("twitter");
        text.add("resso");
        text.add("linkedIn");
        text.add("snapchat");
        text.add("swiggy");

        image.add(R.drawable.facebook);
        image.add(R.drawable.instagram);
        image.add(R.drawable.whatsapp);
        image.add(R.drawable.telegram);
        image.add(R.drawable.twitter);
        image.add(R.drawable.resso);
        image.add(R.drawable.linkedin);
        image.add(R.drawable.snapchat);
        image.add(R.drawable.swiggy);

    }
}