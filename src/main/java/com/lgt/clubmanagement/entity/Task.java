package com.lgt.clubmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Task {
    private Integer id;

    private String name;

    private Integer sid;

    private Integer publisher;

    private Integer number;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private Integer status;

    private Integer type;

    private String introduction;

    private Userinfo publisherInfo;

    private Userinfo numberInfo;

    private Societies societies;

    public Societies getSocieties() {
        return societies;
    }

    public void setSocieties(Societies societies) {
        this.societies = societies;
    }

    public Userinfo getPublisherInfo() {
        return publisherInfo;
    }

    public void setPublisherInfo(Userinfo publisherInfo) {
        this.publisherInfo = publisherInfo;
    }

    public Userinfo getNumberInfo() {
        return numberInfo;
    }

    public void setNumberInfo(Userinfo numberInfo) {
        this.numberInfo = numberInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPublisher() {
        return publisher;
    }

    public void setPublisher(Integer publisher) {
        this.publisher = publisher;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}