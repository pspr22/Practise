package com.example.practise1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button ok,change,page1,page2,page3,page4,page5,page6;
    TextView text,answer,question,colorchange,txtage,personName;
    EditText name;
    String num;
    CheckBox yes;
    CheckBox no;
    RadioGroup group;
    RadioButton style1,style2,style3,style4;
    ToggleButton tb;
    LinearLayout linear;
    Spinner spinner;
    ArrayAdapter adapter;

    broadcastExample br = new broadcastExample();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.write);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image1);
        ok = findViewById(R.id.ok);
        text = findViewById(R.id.ans1);
        name = findViewById(R.id.name);
        question = findViewById(R.id.question);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        answer = findViewById(R.id.answer);
        colorchange = findViewById(R.id.colorchange);
        group = findViewById(R.id.group);
        style1 = findViewById(R.id.picture1);
        style2 = findViewById(R.id.picture2);
        style3 = findViewById(R.id.picture3);
        style4 = findViewById(R.id.picture4);
        tb = findViewById(R.id.toggleButton);
        change = findViewById(R.id.change);
        linear = findViewById(R.id.linear);
        spinner = findViewById(R.id.spinner);
        txtage = findViewById(R.id.txtage);
        page1 = findViewById(R.id.page1);
        page2 = findViewById(R.id.page2);
        page3 = findViewById(R.id.page3);
        page4 = findViewById(R.id.page4);
        page5 = findViewById(R.id.page5);
        page6 = findViewById(R.id.page6);
        personName = findViewById(R.id.txtpersonName);






        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    image.setVisibility(View.INVISIBLE);
                }
                else{
                    image.setVisibility(View.VISIBLE);
                }
            }
        });

        adapter = ArrayAdapter.createFromResource(this,R.array.age_group,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String select = adapterView.getItemAtPosition(i).toString();
                txtage.setText(select);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(style1.isChecked()){
                    linear.setBackgroundResource(R.drawable.nature);
                    Snackbar.make(linear,"App layout is changed.",Snackbar.LENGTH_INDEFINITE)
                            .setAction("Close", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            }).show();
                }
                else if(style2.isChecked()){
                    linear.setBackgroundResource(R.drawable.city);
                    Snackbar.make(linear,"App layout is changed.",Snackbar.LENGTH_INDEFINITE)
                            .setAction("Close", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            }).show();
                }
                else if(style3.isChecked()){
                    linear.setBackgroundResource(R.drawable.nature2);
                    Snackbar.make(linear,"App layout is changed.",Snackbar.LENGTH_INDEFINITE)
                            .setAction("Close", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            }).show();
                }
                else if(style4.isChecked()){
                    linear.setBackgroundResource(R.drawable.view);
                    Snackbar.make(linear,"App layout is changed.",Snackbar.LENGTH_INDEFINITE)
                            .setAction("Close", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            }).show();
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = name.getText().toString();
                try{
                    final long numbs = Long.parseLong(num);
                    String returnz = words.convert(numbs);
                    text.setText(returnz);
                    question.setText("Is it Correct?");
                    yes.setText("Yes");
                    no.setText("No");
                    yes.setChecked(false);
                    no.setChecked(false);
                    answer.setText("");
                    yes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(yes.isChecked()){
                                answer.setText("Thank you!!! :)");
                                no.setChecked(false);
                            }
                        }
                    });
                    no.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(no.isChecked()){
                                answer.setText("I will Improve!!!");
                                yes.setChecked(false);
                            }
                        }
                    });

                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"illegal Number or empty number",Toast.LENGTH_LONG).show();
                }
            }
        });

        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),recyclerview.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Went to RecyclerView",Toast.LENGTH_SHORT).show();
            }
        });

        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),listview.class);
                startActivity(intent1);
                Toast.makeText(getApplicationContext(),"Went to ListView",Toast.LENGTH_SHORT).show();
            }
        });

        page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),GridView.class);
                startActivity(intent2);
                Toast.makeText(getApplicationContext(),"Went to GridView",Toast.LENGTH_SHORT).show();
            }
        });

        page4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(),ScrollView.class);
                startActivity(intent3);
                Toast.makeText(getApplicationContext(),"Went to ScrollView",Toast.LENGTH_SHORT).show();
            }
        });

        page5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(),SendSms.class);
                startActivity(intent4);
                Toast.makeText(MainActivity.this, "went to send Sms", Toast.LENGTH_SHORT).show();
            }
        });

        page6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this,EmailActivity.class);
                startActivity(intent5);
                Toast.makeText(MainActivity.this, "went to send email", Toast.LENGTH_SHORT).show();

            }
        });



        Intent intent = getIntent();
        String userName = intent.getStringExtra("keyword");
        personName.setText(userName);


    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(br,filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(br);
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle("Exit Application?")
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);

                    }
                }).show();
        alertdialog.create();
    }

}