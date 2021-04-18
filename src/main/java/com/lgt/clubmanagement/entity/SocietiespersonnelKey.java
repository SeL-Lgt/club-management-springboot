package com.lgt.clubmanagement.entity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class SocietiespersonnelKey {
    private Integer sid;

    private Integer uid;

    private Integer job;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "SocietiespersonnelKey{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", job=" + job +
                '}';
    }
}