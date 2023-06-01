package com.example.crud_spotify.model;

public class Song {
    private int id;
    private String title;
    private int artist_id;
    private int duration;
    private String genre;
    private int album_id;

    public Song(String title, int artist_id, int duration, String genre, int album_id) {
        this.title = title;
        this.artist_id = artist_id;
        this.duration = duration;
        this.genre = genre;
        this.album_id = album_id;
    }

    public String getTitle() {
        return title;
    }

    public int getArtist() {
        return artist_id;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public int getAlbum() {
        return album_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(int artist_id) {
        this.artist_id = artist_id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAlbum(int album) {
        this.album_id = album;
    }
}
