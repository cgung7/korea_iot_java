package org.example.chapter09_practice.model;

import org.example.chapter09_practice.util.DateUtil;

public class User {
    private int id;
    private String name;
    private String email;
    private String createdAt;
    private String updateAt;

    public User(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = DateUtil.now();
        this.updateAt = DateUtil.now();
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public String getEmail() { return email;}
    public String  getCreatedAt() { return createdAt;}
    public String getUpdateAt() {return updateAt;}

    public void setEmail(String email){
        this.email = email;
        this.updateAt = DateUtil.now();
    }

    @Override
    public String toString() {
        return "Id: " + id
                + ", Name: " + name
                + ", Email: " + email
                + ", CreatedAt: " + createdAt
                + ", UpdateAt: " + updateAt;
    }
}
