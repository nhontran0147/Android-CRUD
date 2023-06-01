package com.example.crud_spotify;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crud_spotify.R;
import com.example.crud_spotify.data.ListPlaylist;
import com.example.crud_spotify.model.Playlist;

public class AddPlaylistActivity extends AppCompatActivity {

    private TextView tvId, tvName, tvUserId;
    private EditText etName, etUserId;
    private Button btnSavePlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_playlist);

        tvId = findViewById(R.id.tvIdDefaultap);
        tvName = findViewById(R.id.tvNameap);
        tvUserId = findViewById(R.id.tvUserIdap);
        etName = findViewById(R.id.etNameap);
        etUserId = findViewById(R.id.etUserIda);
        btnSavePlaylist = findViewById(R.id.button_save_playlist);
        int playlít_id = getIntent().getIntExtra("playlist",-1);
        if (playlít_id > -1) {
            Playlist playlist = ListPlaylist.playlists.get(playlít_id);
            etName.setText(playlist.getName());
            etUserId.setText(Integer.toString(playlist.getUserId()));
            tvId.setText(Integer.toString(playlist.getId()));
        }


        btnSavePlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String userId = etUserId.getText().toString();
                String idString = tvId.getText().toString();
                if (idString.length() > 0){
                    int id = Integer.parseInt(idString);
                    ListPlaylist.updatePlaylist(new Playlist(id, name,Integer.parseInt(userId),R.drawable.playlist_1));
                }else{
                    int idNew = ListPlaylist.newID();
                    ListPlaylist.playlists.add(new Playlist(idNew,name,Integer.parseInt(userId),R.drawable.playlist_1));
                }
                finish();
            }
        });
    }
}
