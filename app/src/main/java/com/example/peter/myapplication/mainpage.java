package com.example.peter.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class mainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_books);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        Button button = (Button) findViewById(R.id.btnbook);
        Button button2 = (Button) findViewById(R.id.checkout);
        Button button3 = (Button) findViewById(R.id.btnreserve);
        Button button4 = (Button) findViewById(R.id.btnmap);
        button.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          startActivity(new Intent(mainpage.this, books.class));
                                      }
                                  }

        );
        button2.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           startActivity(new Intent(mainpage.this, checkbook.class));
                                       }
                                   }

        );
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(mainpage.this, reserve.class));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          startActivity(new Intent(mainpage.this, map.class));
                                      }
                                  }

        );
    }

}



