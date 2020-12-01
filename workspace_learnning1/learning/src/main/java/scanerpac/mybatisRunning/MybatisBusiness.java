package scanerpac.mybatisRunning;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import common.CommonLoggerObj;
import scanerpac.entity.sys.Seqs;
import scanerpac.mybatisServer.SeqsService;

@Repository("mybatisBusiness")
public class MybatisBusiness extends CommonLoggerObj {
	@Resource(name = "sys_seqService")
	private SeqsService seqsService;

	@Resource(name = "myBatisSqlSession")
	private MyBatisSqlSession myBatisSqlSession;

	public void initAllTablePrimaryKeySeqs() {
		List<Object> selectAllBusineTables = myBatisSqlSession.selectAllBusineTables();
		for (Object obj : selectAllBusineTables) {
			Seqs se2 = (Seqs) obj;
			seqsService.createSeqsByTableName(se2.getSeqTablename());
		}
	}

	public void initAllAccount() {
		myBatisSqlSession.select();
	}
}
