package com.example.crud_spotify.data;

import com.example.crud_spotify.R;
import com.example.crud_spotify.model.User;

import java.util.ArrayList;

public class ListUsers {
    public static int count_id;

    public static int newID() {
        count_id++;
        return count_id;
    }


    public static ArrayList<User> users = new ArrayList<User>();
    static {
        users.add(new User("John", "Doe", 1, R.drawable.user_1, "john.doe@example.com", "1234567890", true, "john_doe", "password123"));
        users.add(new User("Jane", "Doe", 2, R.drawable.user_1, "jane.doe@example.com", "2345678901", true, "jane_doe", "password345"));
        users.add(new User("Bob", "Smith", 3, R.drawable.user_1, "bob.smith@example.com", "3456789012", true, "bob_smith", "password678"));
        users.add(new User("Alice", "Johnson", 4, R.drawable.user_1, "alice.johnson@example.com", "4567890123", true, "alice_johnson", "password910"));
        users.add(new User("David", "Nguyen", 5, R.drawable.user_1, "david.nguyen@example.com", "5678901234", true, "david_nguyen", "password234"));
        users.add(new User("Karen", "Lee", 6, R.drawable.user_1, "karen.lee@example.com", "6789012345", true, "karen_lee", "password567"));
        users.add(new User("Michael", "Brown", 7, R.drawable.user_1, "michael.brown@example.com", "7890123456", true, "michael_brown", "password890"));
        users.add(new User("Emily", "Davis", 8, R.drawable.user_1, "emily.davis@example.com", "8901234567", true, "emily_davis", "password1234"));
        users.add(new User("William", "Garcia", 9, R.drawable.user_1, "william.garcia@example.com", "9012345678", true, "william_garcia", "password5678"));
        users.add(new User("Sophia", "Rodriguez", 10, R.drawable.user_1, "sophia.rodriguez@example.com", "0123456789", true, "sophia_rodriguez", "password91011"));
        users.add(new User("James", "Martinez", 11, R.drawable.user_1, "james.martinez@example.com", "1234567890", true, "james_martinez", "password1213"));
        users.add(new User("Olivia", "Hernandez", 12, R.drawable.user_1, "olivia.hernandez@example.com", "2345678901", true, "olivia_hernandez", "password1415"));
        users.add(new User("Ethan", "Lopez", 13, R.drawable.user_1, "ethan.lopez@example.com", "3456789012", true, "ethan_lopez", "password1617"));
        users.add(new User("Ava", "Gonzalez", 14, R.drawable.user_1, "ava.gonzalez@example.com", "4567890123", true, "ava_gonzalez", "password1819"));
        users.add(new User("Mia", "Perez", 15, R.drawable.user_1, "mia.perez@example.com", "5678901234", true, "mia_perez", "password2021"));
        count_id = 15;
    }

    public static User getByID(int id) {
        return users.get(id);
    }

    public static void updateUser(User user){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getId() == user.getId()){
                users.set(i,user);
                break;
            }
        }
    }
}
