package scanerpac.springjdbc;


import javax.annotation.Resource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("baseDao")
public class baseDao {
	
	public baseDao(){
		System.out.println("baseDao hashcode:"+this.hashCode());
	}
	
	@Resource
	protected JdbcTemplate  jdbcTemplate;
//	@Resource(name="jdbcDaoSupport")
//	protected JdbcDaoSupport  jdbcDaoSupportdddddd;	
}
