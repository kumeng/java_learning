package scanerpac.entity.sys;

import java.io.Serializable;

public class Seqs implements Serializable {
	private Integer id;

	private String seqName;

	private String seqTablename;

	private Integer seqCurrno;

	private Integer seqStep;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName == null ? null : seqName.trim();
	}

	public String getSeqTablename() {
		return seqTablename;
	}

	public void setSeqTablename(String seqTablename) {
		this.seqTablename = seqTablename == null ? null : seqTablename.trim();
	}

	public Integer getSeqCurrno() {
		return seqCurrno;
	}

	public void setSeqCurrno(Integer seqCurrno) {
		this.seqCurrno = seqCurrno;
	}

	public Integer getSeqStep() {
		return seqStep;
	}

	public void setSeqStep(Integer seqStep) {
		this.seqStep = seqStep;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", seqName=").append(seqName);
		sb.append(", seqTablename=").append(seqTablename);
		sb.append(", seqCurrno=").append(seqCurrno);
		sb.append(", seqStep=").append(seqStep);
		// sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}