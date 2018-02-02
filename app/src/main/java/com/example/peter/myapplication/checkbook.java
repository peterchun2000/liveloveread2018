package com.example.peter.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class checkbook extends AppCompatActivity implements MyRecyclerViewAdapter1.ItemClickListener { //implements MyRecyclerViewAdapter.ItemClickListener {
    private static final String TAG = books.class.getSimpleName();
    private TextView txtResultDueDate ; private DatePicker datePicker; private Calendar calendar; private int year; private int month; private int day;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_checkbook);
        RecyclerView recyclerView = findViewById(R.id.bookview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecyclerViewAdapter1 adapter = new MyRecyclerViewAdapter1(this, books.test);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onItemClick(View view, int position) {
        String s= books.test.get(position).getDate();
        Toast.makeText(this, "You have"  + s + " until your due date", Toast.LENGTH_SHORT).show();
    }

}
