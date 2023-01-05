package com.example.intent_gub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class temperature extends AppCompatActivity {

    private EditText et;
    private TextView tv;
    private Button convert,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        et = findViewById(R.id.temp);
        tv = findViewById(R.id.result);
        convert = findViewById(R.id.convert);
        logout = findViewById(R.id.logout);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double val = Double.parseDouble(et.getText().toString());
                val = val*1.8 + 32;
                tv.setText(""+val);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(temperature.this,MainActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}