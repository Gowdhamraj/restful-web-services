package com.gow.microservices.restfulwebservices.users;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    @Size(min = 3, max = 9, message = "At least 3 characters")
    private String name;

    @Digits(integer = 1, fraction = 0)
    private Integer id;

    @Past
    @Nullable
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
