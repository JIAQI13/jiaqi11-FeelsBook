package com.example.jiaqi11_feelbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class countnumber extends AppCompatActivity {
    //initialize
    TextView Text;
    int countinglove=0;
    int countingjoy=0;
    int countingsurprise=0;
    int countinganger=0;
    int countingsadness=0;
    int countingfear=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countnumber);
        Text=findViewById(R.id.textView);
        FileInputStream fis=null;
        //File file = new File("example.txt");

        try {
            //fis=openFileInput("count.txt");
            fis=openFileInput("example.txt");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb= new StringBuilder();
            String text;
            //so basically it is counting how many times each emotion occurs in the final file
            //in this case it wont brother to find where store the count and minus one when delete any items
            while((text=br.readLine())!=null) {

                if (text.indexOf("love") != -1) {
                     countinglove=countinglove+1;
                }
                if (text.indexOf("joy") != -1) {
                    countingjoy=countingjoy+1;
                }
                if (text.indexOf("surprise") != -1) {
                    countingsurprise=countingsurprise+1;
                }
                if (text.indexOf("anger") != -1) {
                    countinganger=countinganger+1;
                }
                if (text.indexOf("sadness") != -1) {
                    countingsadness=countingsadness+1;
                }
                if (text.indexOf("fear") != -1) {
                    countingfear=countingfear+1;
                }
                sb.append(text).append("\n");
            }
            String numberone = new Integer(countinglove).toString();
            String numbertwo = new Integer(countingjoy).toString();
            String numberthree = new Integer(countingsurprise).toString();
            String numberfour = new Integer(countinganger).toString();
            String numberfive = new Integer(countingsadness).toString();
            String numbersix = new Integer(countingfear).toString();
            Text.setText("count love::"+numberone+"\ncount joy::"+numbertwo+"\ncount surprise::"+numberthree+"\ncount anger::"+numberfour+"\ncount sadness::"+numberfive+"\ncount fear::"+numbersix+"\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
    }

