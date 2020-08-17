package com.gow.microservices.restfulwebservices.users;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    @Size(min = 3, max = 9, message = "At least 3 characters")
    private String myName;

    @Digits(integer = 1, fraction = 0)
    private Integer myId;

    @Past
    @Nullable
    private Date myBirthDay;

    public User(String name, Integer id, Date myBirthDay) {
        this.myName = name;
        this.myId = id;
        this.myBirthDay = myBirthDay;
    }

    public String getName() {
        return myName;
    }

    public void setName(String myName) {
        this.myName = myName;
    }

    public Integer getId() {
        return myId;
    }

    public void setId(Integer myId) {
        this.myId = myId;
    }

    public Date getBirthDay() {
        return myBirthDay;
    }

    public void setBirthDay(Date myBirthDay) {
        this.myBirthDay = myBirthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + myName + '\'' +
                ", id=" + myId +
                ", birthDay=" + myBirthDay +
                '}';
    }
}
