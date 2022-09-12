package com.example.practise1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ScrollView extends AppCompatActivity {

    Button p1,p2,p3,p4,p5,p6,go;
    EditText personName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        personName = findViewById(R.id.etpersonName);
        go = findViewById(R.id.go);

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(si);
                Toast.makeText(getApplicationContext(),"Went to linearLayout",Toast.LENGTH_SHORT).show();
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si1 = new Intent(getApplicationContext(),recyclerview.class);
                startActivity(si1);
                Toast.makeText(getApplicationContext(),"Went to RecyclerView",Toast.LENGTH_SHORT).show();
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si2 = new Intent(getApplicationContext(), listview.class);
                startActivity(si2);
                Toast.makeText(getApplicationContext(),"Went to ListView",Toast.LENGTH_SHORT).show();
            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si3 = new Intent(getApplicationContext(), GridView.class);
                startActivity(si3);
                Toast.makeText(getApplicationContext(),"Went to GridView",Toast.LENGTH_SHORT).show();
            }
        });

        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si4 = new Intent(getApplicationContext(), WebView.class);
                startActivity(si4);
                Toast.makeText(getApplicationContext(),"Went to WebView",Toast.LENGTH_SHORT).show();
            }
        });

        p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si5 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(si5);
                Toast.makeText(getApplicationContext(),"Went to LinearView",Toast.LENGTH_SHORT).show();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                String UserName = personName.getText().toString();
                intent.putExtra("keyword",UserName);
                startActivity(intent);

            }
        });

    }
}