package com.gow.microservices.restfulwebservices.users;

import com.google.common.collect.ImmutableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApiModel(description = "User model")
@Entity
public class User{

    @Size(min = 3, max = 9, message = "At least 3 characters")
    @Id
    private String myName;

    @NotNull
    private Integer myId;

    @Past
    @Nullable
    private Date myBirthDay;

    @OneToMany(mappedBy = "user")
    private List<Post> myPosts;

    public User()
    {

    }

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

    @ApiModelProperty(required = false)
    public List<Post> getPosts() {
        return ImmutableList.copyOf(myPosts);
    }

    public void setPosts(List<Post> myPosts) {
        this.myPosts = myPosts.stream().collect(Collectors.toList());
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
