package testMybatisPlusMapper.test.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author ${author}
 * @since 2018-11-29
 */
@TableName("BASIC_SEQS")
public class SEQS extends Model<SEQS> {

    private static final long serialVersionUID = 1L;

	private Integer ID;
	private String SEQ_NAME;
	private String SEQ_TABLENAME;
	private Integer SEQ_CURRNO;
	private Integer SEQ_STEP;


	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getSEQ_NAME() {
		return SEQ_NAME;
	}

	public void setSEQ_NAME(String SEQ_NAME) {
		this.SEQ_NAME = SEQ_NAME;
	}

	public String getSEQ_TABLENAME() {
		return SEQ_TABLENAME;
	}

	public void setSEQ_TABLENAME(String SEQ_TABLENAME) {
		this.SEQ_TABLENAME = SEQ_TABLENAME;
	}

	public Integer getSEQ_CURRNO() {
		return SEQ_CURRNO;
	}

	public void setSEQ_CURRNO(Integer SEQ_CURRNO) {
		this.SEQ_CURRNO = SEQ_CURRNO;
	}

	public Integer getSEQ_STEP() {
		return SEQ_STEP;
	}

	public void setSEQ_STEP(Integer SEQ_STEP) {
		this.SEQ_STEP = SEQ_STEP;
	}

	@Override
	protected Serializable pkVal() {
		return this.ID;
	}

}
