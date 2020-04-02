package scanerpac.mybatisServer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.CommonLoggerObj;
import scanerpac.entity.sys.Seqs;
import scanerpac.entity.sys.SeqsQuery;
import scanerpac.entity.sys.SeqsQuery.Criteria;
import scanerpac.mybatisDao.sys.SeqsDao;
import utils.UtilsList;

@Service("sys_seqService")
public class SeqsService extends CommonLoggerObj{
	private final String seqsstr1="_seq";
	@Resource
	private SeqsDao  seqsDao;
	public void  createSeqsByTableName(String tablename){
		int countByExample = seqsDao.countByExample(null);
		countByExample++;
		Seqs se1 = new Seqs();
		se1.setId(countByExample);
		se1.setSeqName(tablename+seqsstr1+countByExample);
		se1.setSeqTablename(tablename);
		se1.setSeqCurrno(0);
		se1.setSeqStep(1);
		seqsDao.insertSelective(se1);
		log.info("创建索引成功:"+se1.toString());
	}	
	public Seqs  createSeqsByTableNameAndNext(String tablename){
		int countByExample = seqsDao.countByExample(null);
		countByExample++;
		Seqs se1 = new Seqs();
		se1.setId(countByExample);
		se1.setSeqName(tablename+seqsstr1+countByExample);
		se1.setSeqTablename(tablename);
		se1.setSeqCurrno(1);
		se1.setSeqStep(1);
		seqsDao.insertSelective(se1);
		log.info("创建索引成功:"+se1.toString());
		return se1;	
	}
	public   void  createSeqs(String seqname,String tablename,Integer initno,Integer step ){
		int countByExample = seqsDao.countByExample(null);
		countByExample++;
		Seqs se1 = new Seqs();
		se1.setId(countByExample);
		se1.setSeqName(seqname);
		se1.setSeqTablename(tablename);
		se1.setSeqCurrno(initno);
		se1.setSeqStep(step);
		seqsDao.insertSelective(se1);
		log.info("创建索引成功:"+se1.toString());
	}
	public   Seqs  createSeqsAndNext(String seqname,String tablename,Integer initno,Integer step ){
		int countByExample = seqsDao.countByExample(null);
		countByExample++;
		Seqs se1 = new Seqs();
		se1.setId(countByExample);
		se1.setSeqName(seqname);
		se1.setSeqTablename(tablename);
		se1.setSeqCurrno(initno+step);
		se1.setSeqStep(step);
		seqsDao.insertSelective(se1);
		log.info("创建索引成功:"+se1.toString());
		return se1;		
	}	
	public   Seqs  nextSeqsBySeqName(String seqname){
		return this.nextSeqsBySeqNameWithStep(seqname, null);
	}
	public   Seqs  nextSeqsBySeqId(Integer id){
		return this.nextSeqsBySeqIdWithStep(id, null);
	}	
	public   Seqs  nextSeqsBySeqNameWithStep(String seqname,Integer step){
		step = step==null?1:step;
		Seqs seq = selectCurrSeqBySeqName(seqname);		
		doNextSeq(step, seq);
		log.info("根据索引名称["+seqname+"]搜到索引,并按步长["+step+"]增长一次:"+seq.toString());
		return seq;		
	}
	
	public   Seqs  nextSeqsBySeqIdWithStep(Integer id,Integer step){
		step = step==null?1:step;
		Seqs seq = SelectCurrSeqById(id);
		doNextSeq(step, seq);
		log.info("根据索引ID["+id+"]搜到索引,并按步长["+step+"]增长一次:"+seq.toString());
		return seq;
	}
		
	public  boolean ModifyStepBySeqName(String seqname,Integer step){
		Seqs seq = selectCurrSeqBySeqName(seqname);
		seq.setSeqStep(step);
		int updateByPrimaryKey = seqsDao.updateByPrimaryKey(seq);
		return updateByPrimaryKey==1;
	}
	public List<Seqs>  SelectCurrSeqByQuery(SeqsQuery query){
		List<Seqs> selectByExample = seqsDao.selectByExample(query);
		return selectByExample;		
	}
	public Seqs SelectCurrSeqById(Integer id){
		return seqsDao.selectByPrimaryKey(id);
	}
	
	
	private void doNextSeq(Integer step, Seqs seq) {	
		step = step==null?1:step;
		Integer seqCurrno = seq.getSeqCurrno()+step;
		seq.setSeqCurrno(seqCurrno);
		seqsDao.updateByPrimaryKeySelective(seq);
	}	
	private Seqs selectCurrSeqBySeqName(String seqname) {
		SeqsQuery query = new SeqsQuery();		
		query.or().andSeqNameEqualTo(seqname);
		List<Seqs> selectCurrSeqByQuery = this.SelectCurrSeqByQuery(query);
		UtilsList utils1 = new UtilsList();
		Seqs seq = (Seqs)utils1.getFistFromList(selectCurrSeqByQuery);
		return seq;
	}	
}
