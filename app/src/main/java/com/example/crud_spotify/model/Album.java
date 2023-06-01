package com.example.crud_spotify.model;

import java.util.ArrayList;

import java.util.ArrayList;

public class Album {
    private int id;
    private String title;
    private int image;
    private int artistId;
    private int releaseYear;
    private String genre;
    private ArrayList<Song> tracklist;

    public Album(int id, String title, int image, int artistId, int releaseYear, String genre, ArrayList<Song> tracklist) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.tracklist = tracklist;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public ArrayList<Song> getTracklist() {
        return tracklist;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTracklist(ArrayList<Song> tracklist) {
        this.tracklist = tracklist;
    }

    public String getIdAndTitle() {
        return getId() + " - " + getTitle();
    }
}

