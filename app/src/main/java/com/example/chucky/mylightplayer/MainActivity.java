package com.example.chucky.mylightplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final static String SONG_ID = "songId";
    public final static String SONG_TITLE="songTitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array to hold songs
        ArrayList<Song> songs=new ArrayList<>();
        songs.add(new Song("Black Ant","Unknown",R.raw.black_ant));
        songs.add(new Song("Mozart Syp","Mozart",R.raw.mozart));
        songs.add(new Song("Tequilla","John",R.raw.tequilla));
        songs.add(new Song("Junior","Unknown",R.raw.junior));

        //creating adapter and linking it to the list view
        SongArrayAdapter adapter=new SongArrayAdapter(this,songs);
        final ListView listView=(ListView) findViewById(R.id.main_listview);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(MainActivity.this,SongScreen.class);
                Song s=(Song) listView.getItemAtPosition(position);
                intent.putExtra(SONG_ID,s.getmId());
                intent.putExtra(SONG_TITLE,s.getmTitle());
                startActivity(intent);
            }
        });
    }
}
