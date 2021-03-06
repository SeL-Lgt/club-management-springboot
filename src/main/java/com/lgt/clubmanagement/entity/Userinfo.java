package com.lgt.clubmanagement.entity;

import java.util.ArrayList;
import java.util.List;

public class Userinfo {
    private Integer id;

    private String number;

    private String password;

    private String name;

    private String classname;

    private Integer type;

    private Long phone;

    private List<Societiespersonnel> societiesPersonnel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public List<Societiespersonnel> getSocietiesPersonnel() {
        return societiesPersonnel;
    }

    public void setSocietiesPersonnel(List<Societiespersonnel> societiesPersonnel) {
        this.societiesPersonnel = societiesPersonnel;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", type=" + type +
                ", phone=" + phone +
                ", societiesPersonnel=" + societiesPersonnel +
                '}';
    }
}