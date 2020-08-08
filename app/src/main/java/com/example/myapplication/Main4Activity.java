package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ListView;

import android.widget.SimpleAdapter;

import java.util.ArrayList;

import java.util.HashMap;



public class Main4Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    SimpleAdapter sa;

    ListView l;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);

        HashMap<String,String> item;

        for(int i=0;i<Songs.length;i++){

            item = new HashMap<String,String>();

            item.put( "line1", Songs[i][0]);

            item.put( "line2", Songs[i][1]);

            list.add( item );

        }

        sa = new SimpleAdapter(this, list,

                R.layout.layout,

                new String[] { "line1","line2" },

                new int[] {R.id.line_a, R.id.line_b});



        l = (ListView) findViewById(R.id.l1);

        l.setAdapter(sa);

        l.setOnItemClickListener(this);

    }



    String[][] Songs =

            {
                    {"A Whole New World","Zayn,Zhavia Ward"},

                    {"Girls Like You","Maroon 5"},

                   // {"Havana","Camila Cabello"},

                    {"Memories","Maroon 5"},

                    {"Perfect","one direction"},

                    {"Photograph","Ed Sheeran"},


                    {"I Don't Care","Justin Bieber Ft Ed Sheeran"}};


                   // {"Night Changes","One direction"},

                    //{"One Call Away","Charlie Puth"},

                   // {"Old Town Road","Lil Nas X"},


                   // {"Shape Of You","Ed Sheeran"},

                    //{"Señorita","Camila Cabello Ft Shawn Mendes"},

                   // {"Story Of My Life","One Direction"},

                    //{"You Need To Calm Down","Taylor Swift"},


                   // {"Faded","Alan Walker"},

                   // {"Rockabye","Anne Marie"},

                    //{"Lover","Taylor Swift"},

                   // {"No Tears Left To Cry","Ariana Grande"},


                   // {"Sucker","Jonas Brothers"},

                    //{"Closer","The Chainsmokers Ft Halsey"}};





    @Override

    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

        Intent in=new Intent(this,Main5Activity.class);

        in.putExtra("key",i);

        startActivity(in);

    }

}

