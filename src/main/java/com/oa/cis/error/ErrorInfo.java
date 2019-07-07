package com.oa.cis.error;

/**
 * Created by yyt on 2018/7/27.
 */
public class ErrorInfo {

    //发生时间
    private String time;

    //访问Url
    private String url;

    //错误类型
    private String error;

    //错误的堆栈轨迹
    String stackTrace;

    //状态码
    private int statusCode;

    //原因短语
    private String reasonPhrase;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }
}
