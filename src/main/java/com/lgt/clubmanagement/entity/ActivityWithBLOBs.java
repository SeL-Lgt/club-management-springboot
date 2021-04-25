package com.lgt.clubmanagement.entity;

public class ActivityWithBLOBs extends Activity {
    private String location;

    private String introduction;

    private Societies societies;

    private Userinfo userinfo;

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public Societies getSocieties() {
        return societies;
    }

    public void setSocieties(Societies societies) {
        this.societies = societies;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}