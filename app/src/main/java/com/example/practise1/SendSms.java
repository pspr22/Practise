package com.example.practise1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSms extends AppCompatActivity {

    EditText etmsg,etmsgnum;
    Button sendmsg;
    String userNum,userMsg;
    public final String CHANNEL_ID = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        etmsg = findViewById(R.id.etmessage);
        etmsgnum = findViewById(R.id.etmsgnum);
        sendmsg = findViewById(R.id.sendmsg);


        sendmsg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                userNum = etmsgnum.getText().toString();
                userMsg = etmsg.getText().toString();
                sendMsg(userMsg,userNum);
                Toast.makeText(SendSms.this, "Sent masg to "+userNum+" Successfully!!",
                        Toast.LENGTH_SHORT).show();
                etmsg.setText("");
                etmsgnum.setText("");
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void sendMsg (String userMsg, String userNum){

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        }
        else{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(userNum,null,userMsg,null,null);
            startNotification();
        }




    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(userNum,null,userMsg,null,null);
            startNotification();
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startNotification(){

        Intent i = new Intent(this,SendSms.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,i,PendingIntent.FLAG_MUTABLE);

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"1", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager  manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);

        Notification.Builder builder = new Notification.Builder(SendSms.this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_baseline_circle_notifications_24)
                .setContentTitle("SMS")
                .setContentText("Sms Sent to "+ userNum+" Sucessfully")
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat compat = NotificationManagerCompat.from(SendSms.this);
        compat.notify(1, builder.build());

    }

}