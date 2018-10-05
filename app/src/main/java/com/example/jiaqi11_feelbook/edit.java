package com.example.jiaqi11_feelbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class edit extends AppCompatActivity {
    //read in file and initialize
    public static final String FILE_NAME="example.txt";
    Button btnloading;
    Button btnedit_edit;
    Button edit_2;
    TextView Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        btnloading = (Button) findViewById(R.id.button);
        btnedit_edit = (Button) findViewById(R.id.edit_edit);
        edit_2 = (Button) findViewById(R.id.edit_2);
        //click event handle
        Text=findViewById(R.id.editText);
        btnedit_edit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openedelete();

            }
        });
        edit_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openeupdate();

            }
        });
    }
       //loading file
        public void load(View v){
            FileInputStream fis=null;
            try {
                fis=openFileInput(FILE_NAME);
                InputStreamReader isr=new InputStreamReader(fis);
                BufferedReader br=new BufferedReader(isr);
                StringBuilder sb= new StringBuilder();
                String text;
                ArrayList<String> list = new ArrayList<String>();
                while((text=br.readLine())!=null) {
                    sb.append(text);
                    sb.append("\n");

                }
                Text.setText(sb.toString());
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
                }//handle all the catch which generate automaticlly


            }

        }
        //function to other activities
    public void openedelete(){
        Intent intent=new Intent(this, delete.class);
        startActivity(intent);
    }
    public void openeupdate(){
        Intent intent=new Intent(this, update.class);
        startActivity(intent);
    }
    }

