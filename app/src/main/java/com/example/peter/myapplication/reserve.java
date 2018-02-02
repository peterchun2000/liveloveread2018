package com.example.peter.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class reserve extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    private ArrayList<BookCls> books;
    private static final String TAG = books.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        // data to populate the RecyclerView with
        books = new ArrayList<>();
        books.add(new BookCls("Making Things Happen","by Addison Woodyard", R.drawable.business_bookcover,""));
        books.add(new BookCls("The World of Abstract Art","by Shawn Fordham", R.drawable.art_bookcover,""));
        books.add(new BookCls("Dutch","by Jake Smith", R.drawable.how_to_book_cover,""));
        books.add(new BookCls("Bone Jack","by Sarah Par", R.drawable.bookcover1,""));
        books.add(new BookCls("The Jungle","by Upton Sinclair", R.drawable.bookcover2,""));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.bookview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, books);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, int position) {
        String s= books.get(position).getTitle();
        String a = books.get(position).getAuthor();
        int d=books.get(position).getImage();
        Toast.makeText(this, "You reserved " + s + " " + a, Toast.LENGTH_SHORT).show();
    }
    public ArrayList<BookCls> getbooks(){
        return books;
    }
}
