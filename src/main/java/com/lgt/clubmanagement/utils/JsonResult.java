package com.lgt.clubmanagement.utils;

public class JsonResult {
    private Object obj;
    private String msg;
    private Integer code;

    public JsonResult() {
    }

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static JsonResult success(Object obj, String msg){
        JsonResult jr = new JsonResult();
        jr.setCode(200);
        jr.setObj(obj);
        jr.setMsg(msg);
        return jr;
    }

    public static JsonResult error(Object obj, String msg) {
        JsonResult jr = new JsonResult();
        jr.setCode(500);
        jr.setObj(obj);
        jr.setMsg(msg);
        return jr;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
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
