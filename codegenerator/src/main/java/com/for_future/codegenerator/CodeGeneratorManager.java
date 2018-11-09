package com.for_future.codegenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class CodeGeneratorManager {

    private CodeGeneratorManager() {

    }

    private static CodeGeneratorManager instance;

    public static CodeGeneratorManager getInstance() {
        if (instance == null) {
            instance = new CodeGeneratorManager();
        }
        return instance;
    }

    private String outDir;
    private String ftlFileDir;
    private String ftlFileName;
    private Template template;

    private void initFreeMarker() {
        try {
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(ftlFileDir));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            template = configuration.getTemplate(ftlFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process(Entity entity) {
        initFreeMarker();
        try {
            File outDirFile = toFileForceExists(outDir);
            HashMap<String, Object> root = new HashMap<>();
            root.put("entity", entity);

            File ex = this.toJavaFilename(outDirFile, entity.getJavaPackageName(), entity.getClassName());
            ex.getParentFile().mkdirs();

            FileWriter writer = new FileWriter(ex);

            template.process(root, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private File toJavaFilename(File outDirFile, String javaPackage, String javaClassName) {
        String packageSubPath = javaPackage.replace('.', '/');
        File packagePath = new File(outDirFile, packageSubPath);
        return new File(packagePath, javaClassName + ".java");
    }

    private File toFileForceExists(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new IOException(filename + " does not exist. This check is to prevent accidental file generation into a wrong path.");
        } else {
            return file;
        }
    }

    public void generate(String ftlFileDir, String ftlFileName, String outDir, Entity entity) {
        this.ftlFileDir = ftlFileDir;
        this.outDir = outDir;
        this.ftlFileName = ftlFileName;
        process(entity);
    }

    public static void main(String[] args) {
        String ftlFileDir = "codegenerator/src/main/java/com/for_future/codegenerator";
        String ftlFileName = "response.ftl";
        String outDir = "codegenerator/src/main/java/com/for_future/codegenerator";
        Entity entity = new Entity();
        entity.setClassName("LoginResponse");
        entity.setJavaPackageName("com.net.response");
        entity.addProperty("String", "mobile");
        entity.addProperty("String","identifyCode");
        entity.addProperty("boolean","hasToken");

        CodeGeneratorManager.getInstance().generate(ftlFileDir, ftlFileName, outDir, entity);
    }

}
