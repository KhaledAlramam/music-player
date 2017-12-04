package com.example.chucky.mylightplayer;

/**
 * Created by chucky on 12/4/17.
 */

public class Song {
    private String mTitle;
    private String mArtist;
    private int mId;

    public Song(String title,String artist,int id){
        mTitle=title;
        mArtist=artist;
        mId=id;
    }

    public String getmArtist() {
        return mArtist;
    }

    public String getmTitle() {
        return mTitle;
    }

    public int getmId() {
        return mId;
    }
}
