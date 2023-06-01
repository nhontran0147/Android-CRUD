package com.example.crud_spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.crud_spotify.data.ListAlbum;
import com.example.crud_spotify.model.Album;

public class AddAlbumActivity extends AppCompatActivity {

    private EditText etTitle, etArtistId, etGenre;
    private TextView tvIdDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_album);

        tvIdDefault = findViewById(R.id.tvIdDefaulta);
        etTitle = findViewById(R.id.etTitlea);
        etArtistId = findViewById(R.id.etArtistIda);
        etGenre = findViewById(R.id.etGenrea);
        Button btnSaveAlbum = findViewById(R.id.button_save_album);

        int id = getIntent().getIntExtra("album",-1);
        if (id > -1){
            Album album = ListAlbum.albums.get(id);
            tvIdDefault.setText(Integer.toString(album.getId()));
            etTitle.setText(album.getTitle());
            etArtistId.setText(Integer.toString(album.getArtistId()));
            etGenre.setText(album.getGenre());
        }

        btnSaveAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String artistId = etArtistId.getText().toString();
                String genre = etGenre.getText().toString();
                if (tvIdDefault.getText().toString().length() > 0) {
                    int id = Integer.parseInt(tvIdDefault.getText().toString());
                    ListAlbum.updateAlbum(new Album(id,title,R.drawable.album_1, Integer.parseInt(artistId),2022, genre,null));
                }else{
                    int idNew = ListAlbum.newID();
                    ListAlbum.albums.add(new Album(idNew,title,R.drawable.album_1,Integer.parseInt(artistId),2022, genre,null));
                }
                finish();
            }
        });
    }
}
