package com.shj.mpms.code.generate;

import java.io.File;
import java.io.IOException;

import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
/**
 * 
 * <B>系统名称：VMS系统</B><BR>
 * <B>模块名称：VMS-SERVICE</B><BR>
 * <B>中文类名：VMS</B><BR>
 * <B>概要说明：</B><BR>
 * <B>@version：v1.0</B><BR>
 * <B>版本		修改人		备注</B><BR>
 * @author : Administrator
 * @date   : 2018年5月12日
 */
public class FreeMarkerTemplateUtils {

    private FreeMarkerTemplateUtils(){}
    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    static{
        //这里比较重要，用来指定加载模板所在的路径
        try {
            String path = FreeMarkerTemplateUtils.class.getResource("/").toString().replaceAll("file:/", "");
            CONFIGURATION.setDirectoryForTemplateLoading(new File(path + "/templates"));
        } catch (IOException e) {
            e.printStackTrace();
        }   
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }

    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }
    
}
