package com.driver.models;

//import jdk.internal.util.random.RandomSupport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Username;
    private String password;
    private String firstName;
    private String lastName;

    public User(){}

    public User(String Username, String password, String firstName, String lastName) {
        this.Username = Username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Blog> blogList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}