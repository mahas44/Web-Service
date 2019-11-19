package com.enes.webservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String _id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String email;

    public User(String _id, String name, String surname, String email) {
        this._id = _id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
