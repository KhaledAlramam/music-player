package com.example.chucky.mylightplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SongScreen extends AppCompatActivity {
    MediaPlayer mediaPlayer=null;
    int len,current;
    ProgressBar seekSong;
    String songTitle;
    TextView titleTextview;
    int song_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_screen);


        Intent recievedIntent=getIntent();
        song_id=recievedIntent.getIntExtra(MainActivity.SONG_ID,0);
        songTitle=recievedIntent.getStringExtra(MainActivity.SONG_TITLE);

        if (mediaPlayer!=null&&mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }

        mediaPlayer=MediaPlayer.create(getApplicationContext(),song_id);
        mediaPlayer.start();

        titleTextview=(TextView) findViewById(R.id.playing_title);
        titleTextview.setText(songTitle);

        len=mediaPlayer.getDuration();
        current=mediaPlayer.getCurrentPosition();
        seekSong=(ProgressBar) findViewById(R.id.songProgress);
        seekSong.setProgress(current/len*100);

    }

}
