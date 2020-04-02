package scanerpac.mybatisDao.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import scanerpac.entity.user.Account;
import scanerpac.entity.user.AccountQuery;

public interface AccountDao {
    int countByExample(AccountQuery example);

    int deleteByExample(AccountQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountQuery example);

    Account selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountQuery example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountQuery example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}