package pokerGameDDZ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingletonBase {
	private static SingletonBase enity = new SingletonBase();

	private SingletonBase() {

	}

	public static SingletonBase getinstance() {
		if (enity == null) {
			synchronized (enity) {
				enity = new SingletonBase();
			}
		}
		return enity;
	}

	// 房间流水号
	private Long tableno = 0L;
	// 全部房间
	private List<Long> tablelist;
	// 房间号对应的房间
	private Map<Long, gameTable> maptable = new HashMap<Long, gameTable>();
	// 在线的玩家
	private Map<String, player> mapplayer = new HashMap<String, player>();
	// 所有扑克牌
	public poker[] porkerr = new poker[54];

	public Long getTableno() {
		return tableno;
	}

	public void setTableno(Long tableno) {
		this.tableno = tableno;
	}

	public List<Long> getTablelist() {
		return tablelist;
	}

	public void setTablelist(List<Long> tablelist) {
		this.tablelist = tablelist;
	}

	public Map<Long, gameTable> getMaptable() {
		return maptable;
	}

	public void setMaptable(Map<Long, gameTable> maptable) {
		this.maptable = maptable;
	}

	public Map<String, player> getMapplayer() {
		return mapplayer;
	}

	public void setMapplayer(Map<String, player> mapplayer) {
		this.mapplayer = mapplayer;
	}
}
