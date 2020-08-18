package com.gow.microservices.restfulwebservices.users;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "User model")
public class User {

    @Size(min = 3, max = 9, message = "At least 3 characters")
    private String myName;

    private Integer myId;

    @Past
    @Nullable
    private Date myBirthDay;

    public User(String name, Integer id, Date myBirthDay) {
        this.myName = name;
        this.myId = id;
        this.myBirthDay = myBirthDay;
    }

    @ApiModelProperty(required = true, allowEmptyValue = false, notes = "3-9 characters")
    public String getName() {
        return myName;
    }

    public void setName(String myName) {
        this.myName = myName;
    }

    @ApiModelProperty(required = true)
    public Integer getId() {
        return myId;
    }

    public void setId(Integer myId) {
        this.myId = myId;
    }

    @ApiModelProperty(required = false)
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
