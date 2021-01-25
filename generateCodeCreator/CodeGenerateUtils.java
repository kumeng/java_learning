package com.shj.mpms.code.generate;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
//引用freemarker-2.3.23.jar
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * 
 * <B>系统名称：BID系统</B><BR>
 * <B>模块名称：BID-SERVICE</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * <B>@version：v1.0</B><BR>
 * <B>版本		修改人		备注</B><BR>
 * @author : YangQingJian
 * @date   : 2018年5月12日
 */
public class CodeGenerateUtils {
    private final static String systemShort = "tams";
    private final static String tableName = "NEW_INSUR_DTL".toLowerCase();
    private final static String packageName = "com.shj."+systemShort;
    private final static String targetPath = "F://SHJ//target//"+systemShort+"//";
    private String tableComments = "TAMS新版保险账户明细";    
    
    SimpleDateFormat sp = new SimpleDateFormat("yyyy年MM月dd日");
    private final String AUTHOR = "jiawen";
    private final String CURRENT_DATE = sp.format(new Date());
    private final String tableNameUpper = tableName.toUpperCase();
    
    private final static String systemName = "TAMS交付系统";//系统名称：如物料系统，CRM系统
    private final static String serviceModuleName = (systemShort + "-service").toUpperCase();
    private final static String webmoduleName = (systemShort + "-web").toUpperCase();
    private final static String domainmoduleName = (systemShort + "-domain").toUpperCase();
    private final static String feignmoduleName = (systemShort + "-feign").toUpperCase();
    
    private final static String feighPath="api"+systemShort;
    private final static String domainPackageName=packageName + ".domain";
    
    private final static String controllerPackageName=packageName + ".web.controller";
    private final static String feignPackageName=packageName + ".feign";
    
    private final static String mapperLastPackage = "mapper";
    private final static String mapperPackageName=packageName + "."+mapperLastPackage;
    
    private final static String repositoryPackageName=packageName+".repository";
    private final static String repositoryImplPackageName=repositoryPackageName+".impl";
    
    private final static String servicePackageName=packageName+".service";
    private final static String serviceImplPackageName=servicePackageName+".impl";
    
    private final static String baseEntityRepotoryPackage = packageName + ".repository.pub";
    private final static String baseEntityServicePackage = packageName + ".service.pub";
    
    List<ColumnClass> columnClassList = new ArrayList<>();
    List<ColumnClass> allColumnClassList = new ArrayList<>();
    
    private final static String URL = "jdbc:oracle:thin:@192.168.2.218:1521/devdb1";
    private final static String USER = "tams";
    private final static String PASSWORD = "tams";
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    
    private final String changeTableName = replaceUnderLineAndUpperCase(tableName);

    public Connection getConnection() throws Exception{
        Properties prop = new Properties();
        prop.setProperty("user", USER);
        prop.setProperty("password", PASSWORD);
        prop.setProperty("remarks", "true");
        
        Class.forName(DRIVER);
        Connection connection= DriverManager.getConnection(URL,prop);
        return connection;
    }


    public static void main(String[] args) throws Exception{
       //先把目录创建好
        File file = new File(targetPath);
        if(!file.exists()){
            file.mkdirs();
        }
        CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();
        codeGenerateUtils.generate();
    }

    public void generate() throws Exception{
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String sql = "select * from user_tab_comments where 1=1 and TABLE_NAME='"+tableName.toUpperCase()+"'";
            PreparedStatement pstmt =connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                tableComments = resultSet.getString("COMMENTS");
            }
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getColumns(null,"%", tableName.toUpperCase(),"%");
            //生成Model文件
            generateModelFile(resultSet);
            //mapper
            generateMapperFile(resultSet);
            //生成Mapper文件
            generateMapperXmlFile(resultSet);
            //生成Repository文件
            generateRepositoryFile(resultSet);
            //生成RepositoryImpl文件
            generateRepositoryImplFile(resultSet);
            //生成服务层接口文件
            generateServiceInterfaceFile(resultSet);
            //生成服务实现层文件
            generateServiceImplFile(resultSet);
            // 还需要生成feigh和controller
            generateControllerFile(resultSet);
            generateFeignFile(resultSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
             if(null!=resultSet){
                 resultSet.close();
             }
             if(null!=connection){
                 connection.close();
             }
        }
    }

    private void generateModelFile(ResultSet resultSet) throws Exception{

        final String suffix = ".java";
        final String path = targetPath + changeTableName + suffix;
        final String templateName = "Model.ftl";
        File mapperFile = new File(path);
       
        ColumnClass columnClass = null;
        while(resultSet.next()){
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME").toLowerCase());
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setChangeColumnName(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME").toLowerCase()));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            String tempNullAble = resultSet.getString("NULLABLE");
            columnClass.setNullAble(null!=tempNullAble  && tempNullAble.equals("1") ? "false" : "true" );
            columnClass.setColumnSize(Integer.valueOf(resultSet.getString("COLUMN_SIZE")));
            String tempDecimal = resultSet.getString("DECIMAL_DIGITS");
            columnClass.setDecimalDigits(null!=tempDecimal ? Integer.valueOf(resultSet.getString("DECIMAL_DIGITS")) : 0);
            allColumnClassList.add(columnClass);
            //通用字段直接忽略
            if(
                    resultSet.getString("COLUMN_NAME").equals("ID") ||
                    resultSet.getString("COLUMN_NAME").equals("CREATED_TIME") || 
                    resultSet.getString("COLUMN_NAME").equals("CREATED_BY") || 
                    resultSet.getString("COLUMN_NAME").equals("MODIFIED_BY") || 
                    resultSet.getString("COLUMN_NAME").equals("IS_DELETED") || 
                    resultSet.getString("COLUMN_NAME").equals("LAST_UPDATED_TIME") 
                    ){
                continue;
            }
            columnClassList.add(columnClass);
        }
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column",columnClassList);
        dataMap.put("all_model_column",allColumnClassList);
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateControllerFile(ResultSet resultSet) throws Exception{
        final String suffix = "Controller.java";
        final String path = targetPath + changeTableName + suffix;
        final String templateName = "Controller.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }
    
    private void generateFeignFile(ResultSet resultSet) throws Exception{
        final String suffix = "Feign.java";
        final String path = targetPath + changeTableName + suffix;
        final String templateName = "Feign.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateServiceImplFile(ResultSet resultSet) throws Exception{
        final String suffix = "ServiceImpl.java";
        final String path = targetPath + changeTableName + suffix;
        final String templateName = "ServiceImpl.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateServiceInterfaceFile(ResultSet resultSet) throws Exception{
        final String prefix = "";
        final String suffix = "Service.java";
        final String path = targetPath + prefix + changeTableName + suffix;
        final String templateName = "service.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateRepositoryFile(ResultSet resultSet) throws Exception{
        final String suffix = "Repository.java";
        final String path = targetPath + changeTableName + suffix;
        final String templateName = "Respontory.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }
    
    private void generateMapperFile(ResultSet resultSet) throws Exception{
        final String suffix = "Mapper.java";
        final String path = targetPath + changeTableName + suffix;
        final String templateName = "Mapper.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }
    
    private void generateRepositoryImplFile(ResultSet resultSet) throws Exception{
        final String suffix = "RepositoryImpl.java";
        final String path = targetPath + changeTableName + suffix;
        final String templateName = "RespontoryImpl.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateMapperXmlFile(ResultSet resultSet) throws Exception{
        final String suffix = "Mapper.xml";
        final String path = targetPath + changeTableName + suffix;
        final String templateName = "MapperXml.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("all_model_column",allColumnClassList);
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateFileByTemplate(final String templateName,File file,Map<String,Object> dataMap) throws Exception{
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small",tableName);
        dataMap.put("table_name",changeTableName);
        dataMap.put("tableNameUpper",tableNameUpper);
        dataMap.put("systemName",systemName);
        dataMap.put("serviceModuleName",serviceModuleName);
        dataMap.put("webmoduleName",webmoduleName);
        dataMap.put("domainmoduleName",domainmoduleName);
        dataMap.put("feignmoduleName",feignmoduleName);
        dataMap.put("domainPackageName",domainPackageName);
        dataMap.put("feighPath",feighPath);
        dataMap.put("mapperPackageName",mapperPackageName);
        dataMap.put("repositoryPackageName",repositoryPackageName);
        dataMap.put("repositoryImplPackageName",repositoryImplPackageName);
        
        dataMap.put("servicePackageName",servicePackageName);
        dataMap.put("serviceImplPackageName",serviceImplPackageName);
        
        dataMap.put("baseEntityRepotoryPackage",baseEntityRepotoryPackage);
        dataMap.put("baseEntityServicePackage",baseEntityServicePackage);
        
        dataMap.put("controllerPackageName",controllerPackageName);
        dataMap.put("feignPackageName",feignPackageName);
        
        dataMap.put("author",AUTHOR);
        dataMap.put("date",CURRENT_DATE);
        dataMap.put("package_name",packageName);
        dataMap.put("tableComments",tableComments);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }

    
    public String replaceUnderLineAndUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return StringUtils.capitalize(result);
    }

}