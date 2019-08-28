package com.likai.api.Responesmodel;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.likai.api.model.User;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {


    @XmlElementWrapper(name = "User")
    @XmlElement(name = "User", type = User.class)
    @JsonProperty(value = "User")
    private List<User> userList;

    public Users() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Users(List<User> userList) {
        this.userList = userList;
    }
}
