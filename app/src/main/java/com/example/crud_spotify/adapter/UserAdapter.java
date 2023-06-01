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
import com.example.crud_spotify.UserActivity;
import com.example.crud_spotify.data.ListUsers;
import com.example.crud_spotify.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private List<User> users;
    private Context context;
    private EditButtonClickListener editButtonClickListener;

    public void setEditButtonClickListener(EditButtonClickListener listener) {
        this.editButtonClickListener = listener;
    }

    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
        this.users = users;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View currentItemView = view;

        if (currentItemView == null){
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_users, viewGroup, false);
        }
        User currentUserPosition = getItem(position);
        ImageView userImage = currentItemView.findViewById(R.id.image_view_user);
        assert currentUserPosition != null;
        userImage.setImageResource(currentUserPosition.getImage());

        TextView userTextView = currentItemView.findViewById(R.id.text_view_user);
        userTextView.setText(currentUserPosition.getIdAndFullName());

        Button buttonDelete = currentItemView.findViewById(R.id.button_delete_user);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users.remove(position);
                notifyDataSetChanged();
            }
        });

        Button buttonEdit = currentItemView.findViewById(R.id.button_edit_user);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editButtonClickListener != null) {
                    editButtonClickListener.onEditButtonClick(position);
                }
            }
        });

        return currentItemView;
    }
}
