package com.for_future.codegenerator;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    private String javaPackageName;
    private String className;
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
