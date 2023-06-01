package com.example.crud_spotify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crud_spotify.R;
import com.example.crud_spotify.model.Album;
import com.example.crud_spotify.model.Playlist;
import com.example.crud_spotify.model.User;

import java.util.ArrayList;
import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    private List<Playlist> playlists;
    private Context context;

    private EditButtonClickListener editButtonClickListener;

    public void setEditButtonClickListener(EditButtonClickListener listener) {
        this.editButtonClickListener = listener;
    }

    public PlaylistAdapter(Context context, ArrayList<Playlist> playlists) {
        super(context, 0, playlists);
        this.playlists = playlists;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View currentItemView = view;

        if (currentItemView == null){
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_playlists, viewGroup, false);
        }
        Playlist currentPlaylistPosition = getItem(position);
        ImageView playlistImage = currentItemView.findViewById(R.id.image_view_playlist);
        assert currentPlaylistPosition != null;
        playlistImage.setImageResource(currentPlaylistPosition.getImage());

        TextView playlistTextView = currentItemView.findViewById(R.id.text_view_playlist);
        playlistTextView.setText(currentPlaylistPosition.getIdAndName());

        Button buttonDelete = currentItemView.findViewById(R.id.button_delete_playlist);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playlists.remove(position);
                notifyDataSetChanged();
            }
        });

        Button buttonEdit = currentItemView.findViewById(R.id.button_edit_playlist);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {notifyDataSetChanged();

                if (editButtonClickListener != null) {
                    editButtonClickListener.onEditButtonClick(position);
                }
            }
        });
        return currentItemView;
    }
}
