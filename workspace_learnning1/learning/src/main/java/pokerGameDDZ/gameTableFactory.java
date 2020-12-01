package pokerGameDDZ;

import java.util.Map;

public class gameTableFactory {
	public static Long createTableToQuence() {
		SingletonBase getinstance = SingletonBase.getinstance();
		long nextno = getinstance.getTableno() + 1L;
		Map<Long, gameTable> maptable = getinstance.getMaptable();
		maptable.put(nextno, new gameTable());
		return nextno;
	}
}
