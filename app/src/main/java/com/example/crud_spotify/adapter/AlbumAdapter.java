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
import com.example.crud_spotify.model.User;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends ArrayAdapter<Album> {
    private List<Album> albums;
    private Context context;

    private EditButtonClickListener editButtonClickListener;

    public void setEditButtonClickListener(EditButtonClickListener listener) {
        this.editButtonClickListener = listener;
    }

    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        super(context, 0, albums);
        this.albums = albums;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View currentItemView = view;

        if (currentItemView == null){
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_album, viewGroup, false);
        }
        Album currentAlbumPosition = getItem(position);
        ImageView albumImage = currentItemView.findViewById(R.id.image_view_album);
        assert currentAlbumPosition != null;
        albumImage.setImageResource(currentAlbumPosition.getImage());

        TextView albumTextView = currentItemView.findViewById(R.id.text_view_album);
        albumTextView.setText(currentAlbumPosition.getIdAndTitle());

        Button buttonDelete = currentItemView.findViewById(R.id.button_delete_album);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                albums.remove(position);
                notifyDataSetChanged();
            }
        });

        Button buttonEdit = currentItemView.findViewById(R.id.button_edit_album);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editButtonClickListener != null) {
                    editButtonClickListener.onEditButtonClick(position);
                    notifyDataSetChanged();
                }
            }
        });
        return currentItemView;
    }
}
