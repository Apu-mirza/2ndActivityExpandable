package com.example.a2ndactivityexpandable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    private CustomAdapter customAdapter;
    private int lastExpandablePosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        prepareListData();

        expandableListView = (ExpandableListView) findViewById(R.id.expandTextId);

        customAdapter = new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                String groupName = listDataHeader.get(i);
                Toast.makeText(getApplicationContext(),groupName,Toast.LENGTH_SHORT).show();
                return false;

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String childString = listDataChild.get(listDataHeader.get(i)).get(i1);
                Toast.makeText(getApplicationContext(),childString,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandablePosition != -1 && lastExpandablePosition != i){
                    expandableListView.collapseGroup(lastExpandablePosition);

                }
                lastExpandablePosition = i;
            }
        });


    }
    public void prepareListData(){

//        String[] headerString = getResources().getStringArray(R.array.abbreviations);
//        String[] childString = getResources().getStringArray(R.array.acronyms);

        String[] headerString = getIntent().getStringArrayExtra("data_header");
        String[] childString = getIntent().getStringArrayExtra("data_child");

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for(int i=0; i<headerString.length; i++){

            listDataHeader.add(headerString[i]);

            List<String> child = new ArrayList<>();
            child.add(childString[i]);

            listDataChild.put(listDataHeader.get(i),child);

        }

    }

}