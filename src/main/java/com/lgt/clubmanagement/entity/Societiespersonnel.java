package com.lgt.clubmanagement.entity;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public class Societiespersonnel extends SocietiespersonnelKey {
    private Date date;

    private Userinfo userinfo;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}