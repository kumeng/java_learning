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
@TableName("BASIC_ACCOUNT")
public class ACCOUNT extends Model<ACCOUNT> {

    private static final long serialVersionUID = 1L;

	private Long ID;
	private String LOGINNAME;
	private String PWD;


	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getLOGINNAME() {
		return LOGINNAME;
	}

	public void setLOGINNAME(String LOGINNAME) {
		this.LOGINNAME = LOGINNAME;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String PWD) {
		this.PWD = PWD;
	}

	@Override
	protected Serializable pkVal() {
		return this.ID;
	}

	@Override
	public String toString() {
		return "ACCOUNT [ID=" + ID + ", LOGINNAME=" + LOGINNAME + ", PWD=" + PWD + "]";
	}

}
