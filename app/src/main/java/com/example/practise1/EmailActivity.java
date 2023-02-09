package com.example.practise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    EditText etemail,etemsub,etemsg;
    Button esend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        etemail = findViewById(R.id.etemail);
        etemsub = findViewById(R.id.etemsub);
        etemsg = findViewById(R.id.etemmsg);
        esend = findViewById(R.id.button);

        esend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userAddress = etemail.getText().toString();
                String userSubject = etemsub.getText().toString();
                String userMessage = etemsg.getText().toString();
                sendEmail(userAddress,userSubject,userMessage);
                etemail.setText("");
                etemsg.setText("");
                etemsub.setText("");
            }
        });

    }

    public void sendEmail(String userAddress,String userSubject,String userMessage){

        String[] emailAddress = {userAddress};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailAddress);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,userSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT,userMessage);
        startActivity(Intent.createChooser(emailIntent,"email send"));


    }

}