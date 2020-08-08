package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class song extends AppCompatActivity {

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void play(View v) {
        int s = getIntent().getIntExtra("key", 0);
        if (player == null) {
            switch (s) {
                case 0:
                    player = MediaPlayer.create(this, R.raw.makhna);
                    break;
                case 1:
                    player = MediaPlayer.create(this, R.raw.manwa);
                    break;
                case 2:
                    player = MediaPlayer.create(this, R.raw.osaathi);
                    break;
                case 3:
                    player = MediaPlayer.create(this, R.raw.raabta);
                    break;
                case 4:
                    player = MediaPlayer.create(this, R.raw.tareefan);
                    break;
                case 5:
                    player = MediaPlayer.create(this, R.raw.tera);
                    break;
                case 6:
                    player = MediaPlayer.create(this, R.raw.titli);
                    break;


                default:
                    break;
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


    public void pause(View v) {
        if (player != null) {
            player.pause();
        }


    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}

