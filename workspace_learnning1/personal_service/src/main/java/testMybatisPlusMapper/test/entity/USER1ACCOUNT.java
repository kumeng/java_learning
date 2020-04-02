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
@TableName("BASIC_USER1ACCOUNT")
public class USER1ACCOUNT extends Model<USER1ACCOUNT> {

    private static final long serialVersionUID = 1L;

	private Double USERID;
	private Double ACCOUNTID;


	public Double getUSERID() {
		return USERID;
	}

	public void setUSERID(Double USERID) {
		this.USERID = USERID;
	}

	public Double getACCOUNTID() {
		return ACCOUNTID;
	}

	public void setACCOUNTID(Double ACCOUNTID) {
		this.ACCOUNTID = ACCOUNTID;
	}

	@Override
	protected Serializable pkVal() {
		return this.USERID;
	}

}
