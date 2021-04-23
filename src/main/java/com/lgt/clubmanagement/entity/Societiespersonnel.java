package com.lgt.clubmanagement.entity;

import jdk.jfr.DataAmount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Mapper
public class Societiespersonnel extends SocietiespersonnelKey {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Userinfo userinfo;

    private Societies societies;

    public Societies getSocieties() {
        return societies;
    }

    public void setSocieties(Societies societies) {
        this.societies = societies;
    }

    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}