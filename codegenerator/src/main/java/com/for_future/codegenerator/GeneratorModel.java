package com.for_future.codegenerator;

public class GeneratorModel {
    //生成java代码的包名
    private String javaPackageName;
    //生成java代码的类名
    private String className;

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
}
