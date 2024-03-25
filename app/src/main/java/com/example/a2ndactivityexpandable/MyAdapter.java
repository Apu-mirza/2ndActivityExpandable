package com.example.a2ndactivityexpandable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    String[] topics;
    int[] icons;
    Context context;
    LayoutInflater layoutInflater;

    MyAdapter(Context context, String[] topics){
        this.context = context;
        this.topics = topics;
    }

    @Override
    public int getCount() {
        return topics.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.sample_view, viewGroup, false);
        }

        TextView textView = (TextView) view.findViewById(R.id.text1Id);

        textView.setText(topics[i]);


        return view;
    }


}



