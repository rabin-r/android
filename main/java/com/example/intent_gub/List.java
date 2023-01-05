package com.example.intent_gub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class List extends AppCompatActivity {

    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        l = findViewById(R.id.list_gub);
        String[] players = getResources().getStringArray(R.array.players);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(List.this,R.layout.my_list,R.id.view_t,players);
        l.setAdapter(arrayAdapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String content = players[i];
                Toast.makeText(List.this,content,Toast.LENGTH_LONG).show();
            }
        });
    }
}