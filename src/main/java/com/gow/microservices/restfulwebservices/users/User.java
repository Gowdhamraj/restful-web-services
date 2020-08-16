package com.gow.microservices.restfulwebservices.users;

import java.util.Date;

public class User {
    private String name;
    private Integer id;
    private Date birthDay;

    public User(String name, Integer id, Date birthDay) {
        this.name = name;
        this.id = id;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", birthDay=" + birthDay +
                '}';
    }
}
