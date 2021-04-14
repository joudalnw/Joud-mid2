package com.myapplicationlab1.joud_midt1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber, editTextTextPersonName,editTextTextEmailAddress;
    INSERT INTO table_name (column1, column2, column3, ...)
    VALUES (value1, value2, value3, ...);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextTextPersonName = (EditText)findViewById(R.id.editTextTextPersonName);
       editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }}

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }

            db = new DataBaseHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = editTextTextEmailAddress.getText().toString();
                    String quantity = PQuantity.getText().toString();
                    if(name.isEmpty()||quantity.isEmpty()){
                        Toast.makeText(MainActivity.this, "Please fill email",
                                Toast.LENGTH_LONG).show();
                    }
                    else{
                        if(!db.addData(name,quantity)){
                            Toast.makeText(MainActivity.this, "Insertion failed",
                                    Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Insertion Successful",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = editTextNumber.getText().toString();
                    if(id.isEmpty()){
                        Toast.makeText(MainActivity.this, "Please insert number",
                                Toast.LENGTH_LONG).show();
                    }
                    else{
                        Cursor cursor = db.getSpecificResult(id);
                        if(cursor.getCount() <= 0){
                            Toast.makeText(MainActivity.this, "Item is not exist",
                                    Toast.LENGTH_LONG).show();
                        }
                        else {
                            String CID = cursor.getString(0);
                            String CName = cursor.getString(1);
                            String CQuan = cursor.getString(2);
                            Toast.makeText(MainActivity.this, CID + ", " + CName + ", " +
                                    CQuan, Toast.LENGTH_LONG).show();
                        }
                    } }
            });
        button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = editTextTextPersonName.getText().toString();
                    db.Delete(id);
                    Toast.makeText(MainActivity.this, "enter name",
                            Toast.LENGTH_LONG).show();
                }
            });
        view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor cur = db.getListContents();
                    StringBuffer buffer = new StringBuffer();
                    while(cur.moveToNext()) {
                        buffer.append("id: " + cur.getString(0)+ "\n");
                        buffer.append("Name: " + cur.getString(1)+ "\n");
                        buffer.append("Quantity: " + cur.getString(2)+ "\n\n");
                    }
                    AlertDialog.Builder builder = new
                            AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true); // a dialog box that can be closed
                    builder.setTitle("All Employees");
                    builder.setMessage(buffer.toString());
                    builder.show();
                    Toast.makeText(MainActivity.this, "Successful View",
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }



}}}