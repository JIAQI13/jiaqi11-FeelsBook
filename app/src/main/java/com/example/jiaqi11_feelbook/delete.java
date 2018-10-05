package com.example.jiaqi11_feelbook;
//https://www.youtube.com/watch?v=WnTKJKNB4kc
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class delete extends AppCompatActivity {
    ArrayList<String> x = new ArrayList<String>();
    ListView Listview0;
    ListView lv;
    EditText nameTxt;
    Button addbtn, updateBtn, deleteBtn, clearBtn;
    ArrayList<String> names = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Listview0 = (ListView) findViewById(R.id.listView1);
        FileInputStream fis = null;
        //loading file
        try {
            fis = openFileInput("example.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text);
                sb.append("\n");
                x.add(text);
                //x.add("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
        lv = (ListView) findViewById(R.id.listView1);
        //nameTxt = (EditText) findViewById(R.id.nameTxt);

        //Adapter


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, x);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int pos, long id) {
                //TODO Auto-generated method stub
                //nameTxt.setText(x.get(pos));
                x.remove(pos);
               //saving file
                String name = "\n";
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput("example.txt", MODE_PRIVATE);
                    for (int i = 0; i < x.size(); i++) {
                        fos.write(x.get(i).getBytes());
                        fos.write(name.getBytes());
                    }
                    //Toast.makeText(this,"save to"+getFilesDir()+"/"+"example.txt",Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                adapter.notifyDataSetChanged();

            }
        });
    }
}


