package com.for_future.codegenerator;

/**
 * 用于描述NetApi的数据结构
 */
public class SaicNetApiBean {
    //方法名
    private String methodName;
    //url
    private String url;
    //request参数描述
    private Property request;
    //response泛型参数描述
    private Property response;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Property getRequest() {
        return request;
    }

    public void setRequest(Property request) {
        this.request = request;
    }

    public Property getResponse() {
        return response;
    }

    public void setResponse(Property response) {
        this.response = response;
    }

    public SaicNetApiBean(String methodName, String url, Property request, Property response) {
        this.methodName = methodName;
        this.url = url;
        this.request = request;
        this.response = response;
    }

    public SaicNetApiBean() {

    }
}
