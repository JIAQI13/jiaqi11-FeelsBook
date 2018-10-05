package com.example.jiaqi11_feelbook;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
//main activity begins here
public class mood extends AppCompatActivity {
    public static final String FILE_NAME="example.txt";
    ArrayList myList = new ArrayList();
    //initialize all the bottoms
    TextView txt;
    Button btnlove;
    Button btnjoy;
    Button btnsurprise;
    Button btnanger;
    Button btnsadness;
    Button btnfear;
    Button btnload;
    Button btncount;
    Button btnexit;
    String passport;
    int countlove=0;
    int countjoy=0;
    int countsurprise=0;
    int countanger=0;
    int countsadness=0;
    int countfear=0;
    public String mood;
    int counter=0;//count value number starting from zero

    @Override
    public void onCreate (Bundle savedInstanceState) {
       //find all the botton

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        txt = (TextView) findViewById(R.id.showtext);
        btnlove = (Button) findViewById(R.id.love);
        btnload = (Button) findViewById(R.id.button_load);
        btnjoy = (Button) findViewById(R.id.joy);
        btnsurprise = (Button) findViewById(R.id.surprise);
        btnanger = (Button) findViewById(R.id.anger);
        btnsadness = (Button) findViewById(R.id.sadness);
        btnfear = (Button) findViewById(R.id.fear);
        btnexit=(Button) findViewById(R.id.exit_exit) ;
        btnload.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txt.setText("load");
                openedit();

            }
        });
        btncount = (Button) findViewById(R.id.count_button);
        btncount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                opencout();
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
                System.exit(0);

            }
        });

    }
    //for each bottom there is a independt funtion to run the event
    public void love(View v){
        countlove=countlove+1;
        mood="love";
        txt.setText("love");
        //count(1);
        openComment(mood);
    }
    public void joy(View v){
        countjoy=countjoy+1;
        mood="joy";
        txt.setText("joy");
        //count(2);
        openComment(mood);
    }
    public void surprise(View v){
        countsurprise=countsurprise+1;
        mood="surprise";
        txt.setText("surprise");
        //count(3);
        openComment(mood);
    }
    public void anger(View v){
        countanger=countanger+1;
        mood="anger";
        txt.setText("anger");
        //count(4);
        openComment(mood);
    }
    public void sadness(View v){
        countsadness=countsadness+1;
        mood="sadness";
        txt.setText("sadness");
        //count(5);
        openComment(mood);
    }
    public void fear(View v){
        countfear=countfear+1;
        txt.setText("fear");
        mood="fear";
        //count(6);
        openComment(mood);
    }
    //these are the functions that link to another class
    public void openComment(String v){
        Intent intent=new Intent(this, comment.class);
        intent.putExtra("mood",v);
        startActivity(intent);
    }
    public void openedit(){
        Intent intent=new Intent(this, edit.class);
        startActivity(intent);
    }

    public void opencout(){
        Intent intent=new Intent(this, countnumber.class);
        startActivity(intent);
    }
    }

