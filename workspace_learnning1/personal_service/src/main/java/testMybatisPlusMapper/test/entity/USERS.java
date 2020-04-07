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
@TableName("BASIC_USERS")
public class USERS extends Model<USERS> {

    private static final long serialVersionUID = 1L;

	private Double ID;
	private String USERNAME;
	private String PSNCODE;
	private String SEX;
	private Double AGE;
	private String IDCARD;
	private String PHONE;


	public Double getID() {
		return ID;
	}

	public void setID(Double ID) {
		this.ID = ID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME) {
		this.USERNAME = USERNAME;
	}

	public String getPSNCODE() {
		return PSNCODE;
	}

	public void setPSNCODE(String PSNCODE) {
		this.PSNCODE = PSNCODE;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String SEX) {
		this.SEX = SEX;
	}

	public Double getAGE() {
		return AGE;
	}

	public void setAGE(Double AGE) {
		this.AGE = AGE;
	}

	public String getIDCARD() {
		return IDCARD;
	}

	public void setIDCARD(String IDCARD) {
		this.IDCARD = IDCARD;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String PHONE) {
		this.PHONE = PHONE;
	}

	@Override
	protected Serializable pkVal() {
		return this.ID;
	}

}
