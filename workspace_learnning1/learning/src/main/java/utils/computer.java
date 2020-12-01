package utils;

public class computer {
	private String msgFdf;
	private String msgStr;

	public String getMsgFdf() {
		return msgFdf;
	}

	public void setMsgFdf(String msgFdf) {
		this.msgFdf = msgFdf;
	}

	public String getMsgStr() {
		return msgStr;
	}

	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	@Override
	public String toString() {
		return "computer [msgFdf=" + msgFdf + ", msgStr=" + msgStr + "]";
	}

}
