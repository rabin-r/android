package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Records extends AppCompatActivity {

    TextView t1,t2;
    Button n,p,e;
    SQLiteDatabase db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        t1 = findViewById(R.id.recordName);
        t2 = findViewById(R.id.recordcgpa);
        n = findViewById(R.id.next);
        p = findViewById(R.id.prev);
        e = findViewById(R.id.bexit);

        db = openOrCreateDatabase("mydb", MODE_PRIVATE,null);
        Cursor cursor = db.rawQuery("select * from student", null);
        cursor.moveToFirst();

        t1.setText(cursor.getString(cursor.getColumnIndex("name")));
        t2.setText(cursor.getString(cursor.getColumnIndex("cgpa")));

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursor.moveToNext();
                    t1.setText(cursor.getString(cursor.getColumnIndex("name")));
                    t2.setText(cursor.getString(cursor.getColumnIndex("cgpa")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the last record",Toast.LENGTH_LONG).show();
                }
            }
        });

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursor.moveToPrevious();
                    t1.setText(cursor.getString(cursor.getColumnIndex("name")));
                    t2.setText(cursor.getString(cursor.getColumnIndex("cgpa")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the first record",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}