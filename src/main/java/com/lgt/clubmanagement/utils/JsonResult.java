package com.lgt.clubmanagement.utils;

public class JsonResult {
    private Object data;
    private String msg;
    private Integer code;

    public JsonResult() {
    }

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static JsonResult success(Object data, String msg) {
        JsonResult jr = new JsonResult();
        jr.setCode(200);
        jr.setData(data);
        jr.setMsg(msg);
        return jr;
    }

    public static JsonResult error(Object data, String msg) {
        JsonResult jr = new JsonResult();
        jr.setCode(500);
        jr.setData(data);
        jr.setMsg(msg);
        return jr;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
