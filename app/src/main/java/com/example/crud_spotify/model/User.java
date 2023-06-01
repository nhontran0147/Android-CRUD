package com.example.crud_spotify.model;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private int id;
    private int image;
    private String email;
    private String phoneNumber;

    private boolean isArtist;

    private String username;

    private String password;

    public User(String firstName, String lastName, int id, int image, String email, String phoneNumber, boolean isArtist, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.image = image;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isArtist = isArtist;
        this.username = username;
        this.password = password;
    }

    // Getters và setters cho các thuộc tính

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdAndFullName() {
        return getId() + " - " + getLastName() + " " + getFirstName();
    }

    public boolean isArtist() {
        return isArtist;
    }

    public void setArtist(boolean artist) {
        isArtist = artist;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
