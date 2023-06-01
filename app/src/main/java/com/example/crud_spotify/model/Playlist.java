package com.example.crud_spotify.model;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String name;

    private int image;

    private int userId;
    private ArrayList<Song> songs;

    public Playlist(int id, String name, int userId, int image) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.image = image;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void clearPlaylist() {
        songs.clear();
    }

    public int getPlaylistSize() {
        return songs.size();
    }

    public int getImage() {
        return image;
    }

    public int getId(){
        return id;
    }

    public String getIdAndName() {
        return getId() + " - " + getName();
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}

