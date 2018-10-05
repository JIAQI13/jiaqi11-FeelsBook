package com.example.jiaqi11_feelbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class comment extends AppCompatActivity {
    //public static final String FILE_NAME="example.txt";
    //ArrayList mylist = (ArrayList<>);
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        mEditText=findViewById(R.id.edit_text);
    }
    public void save(View v){
        Intent intent =getIntent();
        String msg=intent.getStringExtra("mood");
        Intent intent2 = new Intent(this,mood.class);//getApplicationContext(), comment.class);
        //intent2.putExtra("mylist","\nmood::"+msg+"\ncomment::"+mEditText.getText().toString());

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String formattedDate = sdf.format(currentTime);
        String passport="\n"+msg+"\n"+formattedDate.toString()+"\n"+mEditText.getText().toString();
        String text=passport;
        FileOutputStream fos=null;
         //saving file
        try {
            fos = openFileOutput("example.txt",MODE_APPEND);
            fos.write(text.getBytes());
            Toast.makeText(this,"save to"+getFilesDir()+"/"+"example.txt",Toast.LENGTH_LONG).show();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        startActivity(intent2);
    }
}
