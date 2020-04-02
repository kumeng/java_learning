package scanerpac.mybatisDao.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import scanerpac.entity.user.User1AccountKey;
import scanerpac.entity.user.User1AccountQuery;

public interface User1AccountDao {
    int countByExample(User1AccountQuery example);

    int deleteByExample(User1AccountQuery example);

    int deleteByPrimaryKey(User1AccountKey key);

    int insert(User1AccountKey record);

    int insertSelective(User1AccountKey record);

    List<User1AccountKey> selectByExample(User1AccountQuery example);

    int updateByExampleSelective(@Param("record") User1AccountKey record, @Param("example") User1AccountQuery example);

    int updateByExample(@Param("record") User1AccountKey record, @Param("example") User1AccountQuery example);
}