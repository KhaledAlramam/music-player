package com.example.chucky.mylightplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongArrayAdapter extends ArrayAdapter<Song> {

    public SongArrayAdapter(Context context, ArrayList<Song> arr) {
        super(context, 0,arr);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSong=getItem(position);
        TextView songTitle=(TextView) listItemView.findViewById(R.id.song_title);
        songTitle.setText(currentSong.getmTitle());
        TextView songArtist=(TextView) listItemView.findViewById(R.id.song_artist);
        songArtist.setText(currentSong.getmArtist());
        return listItemView;
    }
}
