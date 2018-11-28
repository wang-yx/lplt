package com.wyx.proj.entity;


import java.util.Date;

//@Table(name="t_user")
public class User extends BaseEntity {

    private int id;

    private String userName;

    private String passWord;

    private String nickName;

    private int isAdmin;

    private Date createTime;


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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString(){
        return "User=[id:"+ id +"; userName:"+ userName +"; passWord="+ passWord +"; nickName="+ nickName +"; isAdmin="+ isAdmin
                +"; createTime="+ createTime +"]";
    }

}
