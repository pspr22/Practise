package com.example.practise1;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_INDEFINITE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class broadcastExample extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isPlaneMode = intent.getBooleanExtra("state",false);
        if(isPlaneMode == true){
            Toast.makeText(context,"Device is in Airplane Mode",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(context,"Device is not in Airplane Mode",Toast.LENGTH_LONG).show();
        }
    }
}




