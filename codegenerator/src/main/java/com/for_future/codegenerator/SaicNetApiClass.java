package com.for_future.codegenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于描述NetApi
 */
public class SaicNetApiClass {
    //生成java代码的包名
    private String javaPackageName;
    //生成java代码的类名
    private String className;
    //NetApi列表
    private List<SaicNetApiBean> saicNetApiBeanList;

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


    public void addNetApiBean(SaicNetApiBean saicNetApiBean) {
        if (saicNetApiBeanList == null) {
            saicNetApiBeanList = new ArrayList<>();
        }
        saicNetApiBeanList.add(saicNetApiBean);
    }
}
