package com.wyx.proj.entity;

import com.wyx.proj.annotation.MapperClass;
import com.wyx.proj.dao.UserDao;


import javax.persistence.*;
import java.util.Date;

//@Table(name="t_user")
public class User extends BaseEntity {

    private int id;

    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString(){
        return "User=[id:"+ id +"; userName:"+ userName +"]";
    }

}
