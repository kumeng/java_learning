package scanerpac.springjdbc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * 这里将子类springJdbcDao改为原型（多实例），继承单例 baseDao 测试继承 与 实例化的 之间是否影响
 * @author Administrator
 *
 */
@Repository("springJdbcDao")
@Scope("prototype")   
//@Scope("singleton")  
public class springJdbcDao extends baseDao {
	public springJdbcDao(){
		System.out.println("springJdbcDao hashcode:"+this.hashCode());
	}	
	public int querylogin(String name,String pwd){
		String sql = "select count(1) from basic_account where loginname ='"+name+"' and pwd='"+pwd+"' ";
		return jdbcTemplate.queryForInt(sql);
	}
}
