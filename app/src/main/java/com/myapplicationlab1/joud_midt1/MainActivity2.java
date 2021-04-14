package com.myapplicationlab1.joud_midt1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button4 = (Button)findViewById(R.id.button4);

        textView7= (TextView) findViewById(R.id.textView7);

        textView7= new DataBaseHelper(this);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textView7.getText().toString();
                String quantity = textView7.getText().toString();
                if(name.isEmpty()||quantity.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill all boxes",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    if(!textView7.addData(name,quantity)){
                        Toast.makeText(MainActivity.this, "Insertion failed",
                                Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Insertion Successful",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });}}