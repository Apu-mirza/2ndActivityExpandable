package com.example.a2ndactivityexpandable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class FirstActivity extends AppCompatActivity {

    private String[] abbreviations, acronyms, idioms, example, topics;
    private Button button1, button2;
    private GridView gridView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button1 = findViewById(R.id.button1Id);
//        button2 = findViewById(R.id.button2Id);

        gridView = (GridView) findViewById(R.id.gridViewId);

        topics = getResources().getStringArray(R.array.topics);

        acronyms = getResources().getStringArray(R.array.acronyms);
        abbreviations = getResources().getStringArray(R.array.abbreviations);
        idioms = getResources().getStringArray(R.array.idioms);
        example = getResources().getStringArray(R.array.idioms_example);



        MyAdapter myAdapter = new MyAdapter(this,topics);
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 4){
                    Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                    intent.putExtra("data_header", abbreviations);
                    intent.putExtra("data_child", acronyms);
                    startActivity(intent);
                }
                else if(i == 5){
                    Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                    intent.putExtra("data_header", idioms);
                    intent.putExtra("data_child", example);
                    startActivity(intent);
                }
            }
        });

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("data_header", abbreviations);
//                intent.putExtra("data_child", acronyms);
//                startActivity(intent);
//
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("data_header", idioms);
//                intent.putExtra("data_child", example);
//                startActivity(intent);
//
//            }
//        });

    }


}