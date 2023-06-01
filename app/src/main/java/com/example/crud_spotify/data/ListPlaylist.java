package com.example.crud_spotify.data;

import com.example.crud_spotify.R;
import com.example.crud_spotify.model.Album;
import com.example.crud_spotify.model.Playlist;
import com.example.crud_spotify.model.Song;
import com.example.crud_spotify.model.User;

import java.util.ArrayList;

public class ListPlaylist {
    public static int count_id;
    public static ArrayList<Playlist> playlists = new ArrayList<Playlist>();
    static {
        for (int i = 1; i <= 5; i++) {
            Playlist playlist = new Playlist(i,"Playlist " + i, i, R.drawable.playlist_1);
            playlists.add(playlist);
        }
        count_id = 5;
    }

    public static int newID() {
        count_id++;
        return count_id;
    }

    public static void updatePlaylist(Playlist playlist){
        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getId() == playlist.getId()) {
                playlists.set(i, playlist);
                break;
            }
        }
    }
}
