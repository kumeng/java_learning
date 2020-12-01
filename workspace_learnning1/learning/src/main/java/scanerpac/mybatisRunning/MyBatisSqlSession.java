package scanerpac.mybatisRunning;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import common.CommonLoggerObj;
import scanerpac.entity.user.Account;
import scanerpac.entity.user.AccountQuery;
import scanerpac.mybatisDao.user.AccountDao;

@Repository("myBatisSqlSession")
@Scope("singleton")
public class MyBatisSqlSession extends CommonLoggerObj {

	@Resource(name = "sqlSessionFactory")
	protected SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;

	protected void createSqlSession() {
		if (sqlSessionFactory == null) {
			throw new RuntimeException("sqlSessionFactory is null");
		} else {
			sqlSession = sqlSessionFactory.openSession();
		}

	}

	protected void closeSession() {
		sqlSession.commit();
		sqlSession.close();
	}

	public void select() {
		createSqlSession();
		// 使用Mapper映射器，保证sqlsession不会读取到其他同名的查询语句
		AccountDao mapper = sqlSession.getMapper(AccountDao.class);
		AccountQuery query = new AccountQuery();
		List<Account> selectList = mapper.selectByExample(query);
		closeSession();
		log.debug("已经查出 " + selectList.size() + "条" + ",1L");

	}

	public List<Object> selectAllBusineTables() {
		createSqlSession();
		List<Object> selectList = sqlSession.selectList("sys.select1_allBusiTables");
		closeSession();
		log.debug("已经查出 " + selectList.size() + "条" + ",1L");
		return selectList;
	}

	//
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	// 验证下注入是否会执行 set方法
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
		log.debug("执行setSqlSessionFactory");
	}

	// 注入是否会执行 无参构造
	public MyBatisSqlSession() {

		log.debug("执行午参构造MyBatisSqlSession");
	}

	// 注入是否会执行 有参构造
	public MyBatisSqlSession(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
		log.debug("执行有参构造MyBatisSqlSession");
	}

}
