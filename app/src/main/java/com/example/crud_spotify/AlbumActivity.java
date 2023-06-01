package com.example.crud_spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.crud_spotify.adapter.AlbumAdapter;
import com.example.crud_spotify.adapter.UserAdapter;
import com.example.crud_spotify.data.ListAlbum;
import com.example.crud_spotify.data.ListUsers;

public class AlbumActivity extends AppCompatActivity {

    private AlbumAdapter albumViewAdapter;
    private Button buttonAddAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        albumViewAdapter = new AlbumAdapter(this, ListAlbum.albums);
        ListView usersListView = findViewById(R.id.list_view_albums);
        albumViewAdapter.setEditButtonClickListener(this::onEditButtonClick);
        usersListView.setAdapter(albumViewAdapter);

        buttonAddAlbum = findViewById(R.id.button_add_album);
        buttonAddAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumActivity.this, AddAlbumActivity.class);
                startActivity(intent);
                refesh();
            }
        });
    }

    public void refesh(){
        albumViewAdapter.notifyDataSetChanged();
    }

    public void onEditButtonClick(int position){
        Intent intent = new Intent(AlbumActivity.this, AddAlbumActivity.class);
        intent.putExtra("album",position);
        startActivity(intent);
        albumViewAdapter.notifyDataSetChanged();
    }
}