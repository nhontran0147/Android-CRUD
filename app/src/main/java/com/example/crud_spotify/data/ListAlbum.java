package com.example.crud_spotify.data;

import com.example.crud_spotify.model.Album;
import com.example.crud_spotify.model.Song;
import com.example.crud_spotify.R;
import com.example.crud_spotify.model.User;

import java.util.ArrayList;

public class ListAlbum {
    public static int count_id;
    public static ArrayList<Album> albums = new ArrayList<Album>();

    static {
        // Album 1
        int album1Id = 1;
        String album1Title = "Album 1";
        int album1Image = R.drawable.album_1;
        int album1ArtistId = 1;
        int album1ReleaseYear = 2020;
        String album1Genre = "Pop";
        ArrayList<Song> album1Tracklist = new ArrayList<Song>();
        Album album1 = new Album(album1Id, album1Title, album1Image, album1ArtistId, album1ReleaseYear, album1Genre, album1Tracklist);
        albums.add(album1);

        // Album 2
        int album2Id = 2;
        String album2Title = "Album 2";
        int album2Image = R.drawable.album_1;
        int album2ArtistId = 2;
        int album2ReleaseYear = 2018;
        String album2Genre = "Rock";
        ArrayList<Song> album2Tracklist = new ArrayList<Song>();
        Album album2 = new Album(album2Id, album2Title, album2Image, album2ArtistId, album2ReleaseYear, album2Genre, album2Tracklist);
        albums.add(album2);
        count_id = 2;
    }

    public static int newID() {
        count_id++;
        return count_id;
    }

    public static void updateAlbum(Album album){
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getId() == album.getId()) {
                albums.set(i, album);
                break;
            }
        }
    }
}
