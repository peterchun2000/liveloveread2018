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

public class books extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
        private ArrayList<BookCls> books;
        private static final String TAG = books.class.getSimpleName();
    private TextView txtResultDueDate ; private DatePicker datePicker; private Calendar calendar; private int year; private int month; private int day;
      public static ArrayList<BookCls> test;
      public static String leftDays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_books);

        // data to populate the RecyclerView with
        books = new ArrayList<>();
        test = new ArrayList<>();
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
        Toast.makeText(this, "You checked-out " + s + " by " + a, Toast.LENGTH_SHORT).show();
        Calendar dd = Calendar.getInstance();
        Calendar then = setDate(dd.get(Calendar.DAY_OF_MONTH)+14, dd.get(Calendar.MONTH), dd.get(Calendar.YEAR));
        Calendar c = Calendar.getInstance();
        Calendar now = setDate(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
         leftDays = getLeftDays(then, now);//your result
        test.add(new BookCls(s,a,d,leftDays));
        Log.d(TAG, test.get(0).getDate());
    }

    public ArrayList<BookCls> getbooks(){
        return books;
    }
    public ArrayList<BookCls> getchk(){
        return test;
    }

    public String getLeftDays(Calendar then, Calendar now) {
        long leftMilis = then.getTimeInMillis() - now.getTimeInMillis();
        int seconds = (int) (leftMilis / 1000);
        //Log.d(TAG, "seconds:" + seconds);
        int minutes = seconds / 60;
       // Log.d(TAG, "minutes:" + minutes);
        int hours = minutes / 60;
        //Log.d(TAG, "hours:" + hours);
        int days = hours / 24;
        //Log.d(TAG, "days:" + days);
        int weeks = days / 7;
        //Log.d(TAG, "weeks:" + weeks);

        //months.. another way calculating data due not equal amount of days per month
        Calendar temp = ((Calendar) then.clone());
        temp.add(Calendar.MONTH, -now.get(Calendar.MONTH));
        int months = temp.get(Calendar.MONTH);
     //   Log.d(TAG, "months:" + months);

        StringBuilder sb = new StringBuilder();
        String format = " %d days left";
        String formatStr = String.format(format, days);

        String result = sb.append(formatStr).toString();
        //Log.d(TAG, sb.toString());
        return result;
    }

    private Calendar setDate(int day, int month, int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Log.d(TAG, c.getTime().toString());
        return c;
    }

}
