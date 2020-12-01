package scanerpac.mybatisDao.user;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import scanerpac.entity.user.User;
import scanerpac.entity.user.UserQuery;

public interface UserDao {
	int countByExample(UserQuery example);

	int deleteByExample(UserQuery example);

	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserQuery example);

	User selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserQuery example);

	int updateByExample(@Param("record") User record, @Param("example") UserQuery example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}