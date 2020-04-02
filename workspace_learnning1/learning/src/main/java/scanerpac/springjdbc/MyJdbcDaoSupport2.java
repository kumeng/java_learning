package scanerpac.springjdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import utils.UtilsJudge;

/**
 * @author Administrator
 *
 */
@Repository("myJdbcDaoSupport") 
@Scope("singleton")  
public class MyJdbcDaoSupport2  {
	@Resource(name="jdbcDaoSupport")
	protected JdbcDaoSupportEntity  jdbcDaoSupportdddddd;		
	public MyJdbcDaoSupport2(){
		System.out.println("springJdbcDao2 hashcode:"+this.hashCode());
	}
	public void initsql() throws IOException {
		String sql="";
		String sqlpth="initsql/init.sql";
		String[] limitLinestr = {"/","*","-"," "};
		String tempsqlstr=null;
		ClassPathResource classPathResource = new ClassPathResource(sqlpth);
		InputStreamReader inreader = new InputStreamReader(classPathResource.getInputStream());
		BufferedReader bureader = new BufferedReader(inreader);
		while(bureader.ready()){
			tempsqlstr=bureader.readLine();
			System.err.println(tempsqlstr);
			if(tempsqlstr==null||tempsqlstr.trim()==""||tempsqlstr.trim().length()<2){
				continue;
			}
			if(!UtilsJudge.OneExitArray(tempsqlstr.trim().substring(0, 1), limitLinestr)){
				sql += " ";
				sql += tempsqlstr ;
			}				
		}			
		inreader.close();
		bureader.close();
		String[] split = sql.split(";");		
		if(split!=null&&split.length>0){
			for(String strsql:split){
				jdbcDaoSupportdddddd.getJdbcTemplate().execute(strsql);
			}
		}
		
	}
	public int querylogin(String name,String pwd){
		String sql = "select count(1) from basic_account where loginname ='"+name+"' and pwd='"+pwd+"' ";
		return jdbcDaoSupportdddddd.getJdbcTemplate().queryForInt(sql);
	}
	
}
