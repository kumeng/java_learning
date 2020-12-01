package pokerGameDDZ;

import java.util.Arrays;

import org.apache.poi.util.ArrayUtil;

public class player {
	// 昵称
	private String playerDisplayName;
	// 登陆ID
	private String playerLoginId;
	// 余额
	private Long amountReminas;

	// 个人持牌最多20张
	private poker[] pokerrp = new poker[20];
	// 个人持牌实时张数
	private Integer pokerrpnumber = 0;

	public String getPlayerDisplayName() {
		return playerDisplayName;
	}

	public void setPlayerDisplayName(String playerDisplayName) {
		this.playerDisplayName = playerDisplayName;
	}

	public String getPlayerLoginId() {
		return playerLoginId;
	}

	public void setPlayerLoginId(String playerLoginId) {
		this.playerLoginId = playerLoginId;
	}

	public Long getAmountReminas() {
		return amountReminas;
	}

	public void setAmountReminas(Long amountReminas) {
		this.amountReminas = amountReminas;
	}

	public poker[] getPokerrp() {
		return pokerrp;
	}

	public void setPokerrp(poker[] pokerrp) {
		this.pokerrp = pokerrp;
	}

	public Integer getPokerrpnumber() {
		return pokerrpnumber;
	}

	public void setPokerrpnumber(Integer pokerrpnumber) {
		this.pokerrpnumber = pokerrpnumber;
	}

	// 发一张牌给该玩家
	public void giveOnePoker(poker value) {
		Integer end = value.getPokerindexvalue();
		int x = 0;
		// 只有一张牌时，
		if (pokerrpnumber == 1) {
			Integer old = pokerrp[0].getPokerindexvalue();
			if (end < old) {
				x = 0;
				pokerrp[pokerrpnumber] = pokerrp[0];
			} else {
				x = 1;
			}
		} else if (pokerrpnumber > 1) {
			x = pokerrpnumber;
			// 至少两张牌时,先定位新牌位置，然后移动右边部分
			for (int i = 0; i < pokerrpnumber - 1; i++) {
				Integer old = pokerrp[i].getPokerindexvalue();
				Integer old2 = pokerrp[i + 1].getPokerindexvalue();
				if (i == 0 && end < old2 && end < old) {
					x = 0;
					break;
				}
				if (end < old2 && end > old) {
					x = i + 1;
					break;
				}
			}
			for (int i = pokerrpnumber; i > x; i--) {
				pokerrp[i] = pokerrp[i - 1];
			}
		}
		pokerrp[x] = value;
		pokerrpnumber++;
	}

	// 返回玩家的信息及当前牌组
	public String getInfoOfPlayer() {
		StringBuffer sf = new StringBuffer();
		sf.append(playerDisplayName);
		sf.append(" ");
		sf.append(playerLoginId);
		sf.append(" ");
		sf.append(amountReminas);
		sf.append("手牌一共");
		sf.append(pokerrpnumber);
		sf.append("张");
		for (int i = 0; i < pokerrpnumber; i++) {
			sf.append(pokerrp[i].getInfoOfpokerNotype());
			sf.append(" ");
		}
		return sf.toString();
	}
}
