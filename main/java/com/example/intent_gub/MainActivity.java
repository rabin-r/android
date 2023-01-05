package com.example.intent_gub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText un, pd;
    private Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        un = findViewById(R.id.uName);
        pd = findViewById(R.id.passWord);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn_go);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(un.getText().toString().equals("admin") && pd.getText().toString().equals("123")){
                    Intent intent = new Intent(MainActivity.this,temperature.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this,"wrong credentials",Toast.LENGTH_LONG).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,List.class);
                startActivity(intent);
                finish();
            }
        });
    }
}