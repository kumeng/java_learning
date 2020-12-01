package pokerGameDDZ;

public class pokerFactory {
	private String poker_frontType1 = "红方块";
	private String poker_frontType2 = "红桃心";
	private String poker_frontType3 = "黑桃心";
	private String poker_frontType4 = "黑梅花";
	private String[] poker_frontr = new String[] { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2",
			"小王", "大王" };

	public void initporker() {
		poker[] p54 = new poker[54];
		for (int i = 0; i < poker_frontr.length - 2; i++) {
			p54[4 * i] = newpoker(poker_frontType1, poker_frontr[i], i, 4 * i);
			p54[4 * i + 1] = newpoker(poker_frontType2, poker_frontr[i], i, 4 * i + 1);
			p54[4 * i + 2] = newpoker(poker_frontType3, poker_frontr[i], i, 4 * i + 2);
			p54[4 * i + 3] = newpoker(poker_frontType4, poker_frontr[i], i, 4 * i + 3);
		}
		int i = poker_frontr.length - 2;
		p54[4 * i] = newpoker(poker_frontType1, poker_frontr[i], i, 4 * i);
		p54[4 * i + 1] = newpoker(poker_frontType1, poker_frontr[i + 1], i + 1, 4 * i + 1);
		SingletonBase getinstance = SingletonBase.getinstance();
		getinstance.porkerr = p54;
	}

	private poker newpoker(String porker_fronttype, String poker_frontr, int i, int index) {
		poker p = new poker();
		p.setPoker_front(poker_frontr);
		p.setPokerinnervalue(i);
		p.setPokerindexvalue(index);
		if (p.getPoker_front().length() < 2) {
			p.setPoker_frontType(porker_fronttype);
		}
		return p;
	}

}
