package pokerGameDDZ;

public class poker {
	private String poker_front;
	private String poker_frontType;
	// 牌面大小，单牌比大小用
	private Integer pokerinnervalue;
	// 初始化的牌索引
	private Integer pokerindexvalue;

	public poker() {

	}

	public String getPoker_front() {
		return poker_front;
	}

	public void setPoker_front(String poker_front) {
		this.poker_front = poker_front;
	}

	public String getPoker_frontType() {
		return poker_frontType;
	}

	public void setPoker_frontType(String poker_frontType) {
		this.poker_frontType = poker_frontType;
	}

	public Integer getPokerinnervalue() {
		return pokerinnervalue;
	}

	public void setPokerinnervalue(Integer pokerinnervalue) {
		this.pokerinnervalue = pokerinnervalue;
	}

	public Integer getPokerindexvalue() {
		return pokerindexvalue;
	}

	public void setPokerindexvalue(Integer pokerindexvalue) {
		this.pokerindexvalue = pokerindexvalue;
	}

	// 返回卡牌信息
	public String getInfoOfpoker() {
		StringBuffer sf = new StringBuffer();
		sf.append(poker_frontType);
		sf.append(poker_front);
		return sf.toString();
	}

	public String getInfoOfpokerNotype() {
		StringBuffer sf = new StringBuffer();
		sf.append(poker_front);
		return sf.toString();
	}
}
