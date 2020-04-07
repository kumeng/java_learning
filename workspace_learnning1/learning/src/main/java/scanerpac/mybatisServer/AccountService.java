package scanerpac.mybatisServer;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import common.CommonLoggerObj;
import scanerpac.entity.user.Account;
import scanerpac.entity.user.AccountQuery;
import scanerpac.mybatisDao.user.AccountDao;
import scanerpac.mybatisServerInterface.AccountIF;

@Service
public class AccountService  extends CommonLoggerObj implements AccountIF  {
	
	@Resource
	private AccountDao  accountDao;
	
	public boolean InsertAccount(Account record) {
		// TODO Auto-generated method stub
		int a = accountDao.insertSelective(record);
		log.info("创建ACCOUNT成功:"+record.toString());
		return a==1;
	}

	public boolean UpdateAccount(Account record) {
		// TODO Auto-generated method stub
		int updateByPrimaryKey = accountDao.updateByPrimaryKey(record);
		log.info("修改ACCOUNT成功:"+record.toString());
		return updateByPrimaryKey==1;
	}

	public boolean DelAccount(Long id) {
		// TODO Auto-generated method stub
		int deleteByPrimaryKey = accountDao.deleteByPrimaryKey(id);
		log.info("删除ACCOUNT成功,id:"+id);
		return deleteByPrimaryKey==1;
	}

	public int InsertAccount(List<Account> list) {
		// TODO Auto-generated method stub
		int a =0;
		if(list!=null&&!list.isEmpty()){
			for(int j=0;j<list.size();j++){
				a += accountDao.insertSelective(list.get(j));
			}
		}
		log.info("批量创建ACCOUNT成功,总条目："+a);
		return a;
	}

	public List<Account> selectAccount(AccountQuery example) {
		// TODO Auto-generated method stub
		return accountDao.selectByExample(example);
	}


	public List<Account> selectAccountAll() {
		// TODO Auto-generated method stub
		AccountQuery example = new AccountQuery();
		return selectAccount(example);
	}

	public Account selectAccountById(Long id) {
		// TODO Auto-generated method stub
		return accountDao.selectByPrimaryKey(id);
	}

}
