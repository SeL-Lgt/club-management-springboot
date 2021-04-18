package com.lgt.clubmanagement.entity;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public class Societiespersonnel extends SocietiespersonnelKey {
    private Date date;

    private Userinfo userinfo;

    private Societies societies;

    public Societies getSocieties() {
        return societies;
    }

    public void setSocieties(Societies societies) {
        this.societies = societies;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }
}