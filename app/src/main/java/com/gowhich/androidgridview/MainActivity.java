package com.gowhich.androidgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.*;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    private ImageView imageView;
    private int[] data = new int[]{R.drawable.fengjing1, R.drawable.fengjing2, R.drawable.fengjing3, R.drawable.fengjing4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) this.findViewById(R.id.gridView);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < data.length; i++) {
            Map<String, Object> cell = new HashMap<String, Object>();
            cell.put("imageView", data[i]);
            list.add(cell);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.cell, new String[]{"imageView"}, new int[]{R.id.imageView});
        gridView.setAdapter(simpleAdapter);

        imageView = (ImageView) this.findViewById(R.id.imageView);

        gridView.setOnItemClickListener(this);
        gridView.setOnItemSelectedListener(this);

        imageView.setImageResource(data[0]);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        imageView.setImageResource(data[i]);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        imageView.setImageResource(data[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
