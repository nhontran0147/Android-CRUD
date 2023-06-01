package com.example.crud_spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.crud_spotify.adapter.EditButtonClickListener;
import com.example.crud_spotify.adapter.UserAdapter;
import com.example.crud_spotify.data.ListUsers;
import com.example.crud_spotify.model.User;

import java.io.Serializable;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    private Button buttonAddUser;
    private UserAdapter usersViewAdapter;

    private ListView usersListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        usersViewAdapter = new UserAdapter(this,ListUsers.users);
        usersListView = findViewById(R.id.list_view_users);
        usersViewAdapter.setEditButtonClickListener(this::onEditButtonClick);
        usersListView.setAdapter(usersViewAdapter);

        buttonAddUser = findViewById(R.id.button_add_user);
        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, AddUserActivity.class);
                startActivity(intent);
                refesh();
            }
        });


    }
    public void refesh(){
        usersViewAdapter.notifyDataSetChanged();

    }
    public void onEditButtonClick(int position){
        Intent intent = new Intent(UserActivity.this, AddUserActivity.class);
        intent.putExtra("user",position);
        startActivity(intent);
    }

}