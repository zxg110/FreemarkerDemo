package com.for_future.codegenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        String ftlFileDir = "codegenerator/src/main/java/com/for_future/codegenerator";
        String outDir = "codegenerator/src/main/java/com/for_future/codegenerator";
        //生成request
        Entity request = new Entity();
        request.setJavaPackageName("com.saic.network.model.request");
        request.setClassName("LoginRequest");
        request.addProperty(PropertyType.TYPE_STRING,"mobile");
        request.addProperty(PropertyType.TYPE_STRING,"identifyCode");
        CodeGeneratorManager.getInstance().generate(ftlFileDir, "request.ftl", outDir, request);
        //生成response
        Entity response = new Entity();
        response.setClassName("LoginResponse");
        response.setJavaPackageName("com.saic.network.model.response");
        response.addProperty(PropertyType.TYPE_STRING, "accessToken");
        response.addProperty(PropertyType.TYPE_STRING,"uid");
        response.addProperty(PropertyType.TYPE_BOOLEAN,"realNameCertificated");
        response.addProperty(PropertyType.TYPE_BOOLEAN,"nameMobileBinded");
        response.addProperty(PropertyType.TYPE_BOOLEAN,"registration");
        response.addProperty(PropertyType.TYPE_STRING,"imToken");
        CodeGeneratorManager.getInstance().generate(ftlFileDir, "response.ftl", outDir, response);
        //生成RequestFactory
        SaicNetApiClass saicNetApiClass = new SaicNetApiClass();
        saicNetApiClass.setClassName("RequestFactory");
        saicNetApiClass.setJavaPackageName("com.saic.network.model.api");
        SaicNetApiBean saicNetApiBean = new SaicNetApiBean();
        saicNetApiBean.setMethodName("phoneLogin");
        saicNetApiBean.setRequest(new Property("LoginRequest","loginRequest"));
        saicNetApiBean.setResponse(new Property("LoginResponse","loginResponse"));
        saicNetApiBean.setUrl("(AppUrl.LOGIN_URL");
        saicNetApiClass.addNetApiBean(saicNetApiBean);
    }

}
