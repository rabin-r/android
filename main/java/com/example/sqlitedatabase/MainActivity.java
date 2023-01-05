package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,cgpa;
    Button binsert, bview, bexit;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        cgpa = findViewById(R.id.cgpa);
        binsert = findViewById(R.id.insert);
        bview = findViewById(R.id.view);
        bexit = findViewById(R.id.exit);



        db = openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        try {
            db.execSQL("create table if not exists student(name varchar(20), cgpa varchar(20))");
            Toast.makeText(getApplicationContext(),"table created",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"table creation failed",Toast.LENGTH_LONG).show();
        }

        binsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String cg = cgpa.getText().toString();
                String insertQuery = "insert into student values('"+n+"','"+cg+"');";

                try {
                    db.execSQL(insertQuery);
                    Toast.makeText(getApplicationContext(),"row inserted",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"insertion failed",Toast.LENGTH_LONG).show();
                }
            }
        });

        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Records.class);
                startActivity(intent);
                finish();
            }
        });

        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });


    }
}