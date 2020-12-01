package pokerGameDDZ;

import java.util.Map;

public class playerFactory {
	public static player createPlayerToQuence(String name1, String loginnumber) {
		SingletonBase getinstance = SingletonBase.getinstance();
		Map<String, player> mapplayer = getinstance.getMapplayer();
		player p1 = new player();
		p1.setAmountReminas(80000L);
		p1.setPlayerDisplayName(name1);
		p1.setPlayerLoginId(loginnumber);
		mapplayer.put(p1.getPlayerLoginId(), p1);
		return p1;
	}
}
