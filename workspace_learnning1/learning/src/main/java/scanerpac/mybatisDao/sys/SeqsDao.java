package scanerpac.mybatisDao.sys;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import scanerpac.entity.sys.Seqs;
import scanerpac.entity.sys.SeqsQuery;

public interface SeqsDao {
    int countByExample(SeqsQuery example);

    int deleteByExample(SeqsQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Seqs record);

    int insertSelective(Seqs record);

    List<Seqs> selectByExample(SeqsQuery example);

    Seqs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Seqs record, @Param("example") SeqsQuery example);

    int updateByExample(@Param("record") Seqs record, @Param("example") SeqsQuery example);

    int updateByPrimaryKeySelective(Seqs record);

    int updateByPrimaryKey(Seqs record);
}