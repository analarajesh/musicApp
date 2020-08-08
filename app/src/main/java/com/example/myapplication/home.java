package com.example.myapplication;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class home extends AppCompatActivity {

    Button b1,b2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        b1=(Button)findViewById(R.id.button4);

        b2=(Button)findViewById(R.id.button5);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Main4Activity.class);

                startActivity(i);

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent in=new Intent(getApplicationContext(),Main2Activity.class);

                startActivity(in);

            }

        });

    }

}
