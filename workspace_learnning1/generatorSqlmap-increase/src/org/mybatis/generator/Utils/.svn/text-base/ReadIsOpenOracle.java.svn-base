package org.mybatis.generator.Utils;

import java.util.Properties;

import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Context;

/**
 * 读取配置文件中 的isopenoracle属性
 * @author Administrator
 *
 */
public class ReadIsOpenOracle {
    public static boolean isopenOracle(Context context){
        CommentGeneratorConfiguration commentGeneratorConfiguration = context.getCommentGeneratorConfiguration();
        if(commentGeneratorConfiguration==null){
        	return false;
        }
        Properties properties = commentGeneratorConfiguration.getProperties();
        if(properties==null){
        	return false;
        }        
        String property = properties.getProperty("isopenoracle"); 
        if("true".equals(property)){
        	return true;
        }else{
        	return false;
        }
    }
}
