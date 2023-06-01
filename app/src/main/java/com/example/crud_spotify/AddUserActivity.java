package com.example.crud_spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.crud_spotify.data.ListUsers;
import com.example.crud_spotify.model.User;

public class AddUserActivity extends AppCompatActivity {

    private TextView tvFirstName;
    private EditText etFirstName;
    private TextView tvLastName;
    private EditText etLastName;
    private TextView tvEmail;
    private EditText etEmail;
    private TextView tvPhoneNumber;
    private EditText etPhoneNumber;
    private CheckBox cbIsArtist;
    private TextView tvUsername;
    private EditText etUsername;
    private TextView tvPassword;
    private EditText etPassword;
    private Button btnSaveUser;

    private TextView tvID;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        tvFirstName = findViewById(R.id.tvFirstName);
        etFirstName = findViewById(R.id.etFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        etLastName = findViewById(R.id.etLastName);
        tvEmail = findViewById(R.id.tvEmail);
        etEmail = findViewById(R.id.etEmail);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        cbIsArtist = findViewById(R.id.cbIsArtist);
        tvUsername = findViewById(R.id.tvUsername);
        etUsername = findViewById(R.id.etUsername);
        tvPassword = findViewById(R.id.tvPassword);
        etPassword = findViewById(R.id.etPassword);
        btnSaveUser = findViewById(R.id.button_save_user);
        tvID = findViewById(R.id.tvIdDefault);


        int user_id = getIntent().getIntExtra("user",-1);
        if (user_id > -1) {
            User user = ListUsers.getByID(user_id);
            etFirstName.setText(user.getFirstName());
            etLastName.setText(user.getLastName());
            etEmail.setText(user.getEmail());
            etPhoneNumber.setText(user.getPhoneNumber());
            if (user.isArtist()){
                cbIsArtist.setChecked(true);
            }
            etUsername.setText(user.getUsername());
            etPassword.setText(user.getPassword());
            tvID.setText(Integer.toString(user.getId()));
        }

        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();
                String email = etEmail.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();
                boolean isArtist = cbIsArtist.isChecked();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (tvID.getText().toString().length() > 0) {
                    int id = Integer.parseInt(tvID.getText().toString());
                    ListUsers.updateUser(new User(firstName, lastName, id,R.drawable.user_1, email, phoneNumber, isArtist,username,password));
                }else{
                    int idNew = ListUsers.newID();
                    User user = new User(firstName, lastName, idNew,R.drawable.user_1, email, phoneNumber, isArtist,username,password);
                    ListUsers.users.add(user);
                    Intent intent = new Intent();
                    intent.putExtra("key", user);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }
}