package com.example.crud_spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.crud_spotify.adapter.AlbumAdapter;
import com.example.crud_spotify.adapter.PlaylistAdapter;
import com.example.crud_spotify.adapter.UserAdapter;
import com.example.crud_spotify.data.ListAlbum;
import com.example.crud_spotify.data.ListPlaylist;
import com.example.crud_spotify.data.ListUsers;

public class PlaylistActivity extends AppCompatActivity {
    private Button buttonAddPlaylist;
    private PlaylistAdapter playlistsViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        playlistsViewAdapter = new PlaylistAdapter(this, ListPlaylist.playlists);
        ListView playlistListView = findViewById(R.id.list_view_playlists);
        playlistsViewAdapter.setEditButtonClickListener(this::onEditButtonClick);
        playlistListView.setAdapter(playlistsViewAdapter);

        buttonAddPlaylist = findViewById(R.id.button_add_playlist);
        buttonAddPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistActivity.this, AddPlaylistActivity.class);
                startActivity(intent);
                refesh();
            }
        });
    }
    public void refesh(){
        playlistsViewAdapter.notifyDataSetChanged();
    }
    public void onEditButtonClick(int position){
        Intent intent = new Intent(PlaylistActivity.this, AddPlaylistActivity.class);
        intent.putExtra("playlist",position);
        startActivity(intent);
        playlistsViewAdapter.notifyDataSetChanged();
    }
}