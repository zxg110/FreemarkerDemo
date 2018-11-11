package com.for_future.codegenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于描述request/response的实体类
 */
public class Entity {
    //生成java代码的包名
    private String javaPackageName;
    //生成java代码的类名
    private String className;
    //属性列表
    private List<Property> propertyList;

    public String getJavaPackageName() {
        return javaPackageName;
    }

    public void setJavaPackageName(String javaPackageName) {
        this.javaPackageName = javaPackageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    public void addProperty(String key,String value){
        if(propertyList == null){
            propertyList = new ArrayList<>();
        }
        propertyList.add(new Property(key,value));
    }
}
