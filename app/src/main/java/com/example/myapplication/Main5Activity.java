package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;



import android.media.MediaPlayer;

import android.os.Bundle;



import android.view.View;

import android.view.WindowManager;


public class Main5Activity extends AppCompatActivity {



    MediaPlayer player;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main5);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);



    }



    public void play(View v)

    {

        int s= getIntent().getIntExtra("key",0);

        if(player==null)

        {

            switch(s)

            {

                case 0: player=MediaPlayer.create(this,R.raw.alladin);

                    break;

                case 1: player=MediaPlayer.create(this,R.raw.girls);

                    break;

                case 2: player=MediaPlayer.create(this,R.raw.memory);

                    break;

                case 3: player=MediaPlayer.create(this,R.raw.perfect);

                    break;

                case 4: player=MediaPlayer.create(this,R.raw.photograph);

                    break;

                case 5: player=MediaPlayer.create(this,R.raw.idc);

                    break;



                default:break;

            }



            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override

                public void onCompletion(MediaPlayer mp) {

                    stopPlayer();

                }

            });

        }

        player.start();



    }





    public void pause(View v)

    {

        if(player!=null) {

            player.pause();

        }





    }

    public void stop(View v)

    {

        stopPlayer();

    }

    private void stopPlayer()

    {

        if(player!=null) {

            player.release();

            player = null;

        }

    }



    protected void onStop()

    {

        super.onStop();

        stopPlayer();

    }

}


