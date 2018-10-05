package com.example.jiaqi11_feelbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class update extends AppCompatActivity {
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
        setContentView(R.layout.activity_update);
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
                //apend each single line to the array we want to edit
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
        nameTxt = (EditText) findViewById(R.id.nameTxt);


        //Adapter


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, x);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int pos, long id) {
                //TODO Auto-generated method stub
                //nameTxt.setText(x.get(pos));
                String name=  nameTxt.getText().toString();
                x.set(pos,name);
                //sorting by time
                if (name.indexOf("2018") != -1){
                    String a=x.get(pos);
                    String b=x.get(pos-1);
                    String c=x.get(pos+1);
                    for (int i = 0; i < 3; i++) {
                        x.remove( x.size() - 1 );
                    }
                    Collections.reverse(x);
                    x.add(c);
                    x.add(b);
                    x.add(a);
                    Collections.reverse(x);


                    //x.set(2,name);
                    //x.set(1,x.get(pos-1));
                   // x.set(3,x.get(pos+1));
                    //x.set(pos-1,a);
                    //x.set(pos,b);
                    //x.set(pos+1,c);

                }
                String name1 = "\n";
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput("example.txt", MODE_PRIVATE);
                    for (int i = 0; i < x.size(); i++) {
                        fos.write(x.get(i).getBytes());
                        fos.write(name1.getBytes());
                    }
                    //Toast.makeText(this,"save to"+getFilesDir()+"/"+"example.txt",Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }//handle all kinds of catch terms it generate automaticlly
                finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //refresh
                adapter.notifyDataSetChanged();

            }
        });
    }
}
