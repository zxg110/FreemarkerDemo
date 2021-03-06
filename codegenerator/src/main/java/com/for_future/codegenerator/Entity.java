package com.for_future.codegenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于描述request/response的实体类
 */
public class Entity extends GeneratorModel {
    //属性列表
    private List<Property> propertyList;

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    public void addProperty(String key, String value) {
        if (propertyList == null) {
            propertyList = new ArrayList<>();
        }
        propertyList.add(new Property(key, value));
    }
}
