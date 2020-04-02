package scanerpac.mybatisServerInterface;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import scanerpac.entity.user.Account;
import scanerpac.entity.user.AccountQuery;

public interface AccountIF {
	public boolean InsertAccount(Account record);	
	public boolean UpdateAccount(Account record);
	public boolean DelAccount(Long id);
	public int     InsertAccount(List<Account> list);
	public List<Account> selectAccount(AccountQuery example);
	//RowBounds mybatis内存分页对象 //建议使用物理分页 AccountQuery中的 	pageNo startRow pageSize
//	public List<Account> selectAccount(AccountQuery example,RowBounds rowBounds);
	
	public List<Account> selectAccountAll();
	public Account selectAccountById(Long id);
}
