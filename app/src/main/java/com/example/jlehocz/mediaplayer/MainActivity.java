package com.example.jlehocz.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.play);
        Button pauseButton = (Button) findViewById(R.id.pause);
        Button stopButton = (Button) findViewById(R.id.stop);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.nib);


        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
            }

        });

        pauseButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.pause();
                    int length = mp.getCurrentPosition();
                    mp.seekTo(length);
                }

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();

                    try {
                        mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            }
        });

    }


}
