package com.firetech.blackghost.restclient;

public class ErrorResponse {

    private String errcode;
    private String errmsg;
    public String getErrcode() {
        return errcode;
    }
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    @Override
    public String toString() {
        return "ErrorResponse [errcode=" + errcode + ", errmsg=" + errmsg + "]";
    }
    
    
}
