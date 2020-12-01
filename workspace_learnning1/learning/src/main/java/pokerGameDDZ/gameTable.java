package pokerGameDDZ;

/**
 * 牌桌 座位顺时针 A B C
 * 
 * @author jiawen
 *
 */
public class gameTable {

	// 座位A
	private player seatA;
	// 座位B
	private player seatB;
	// 座位C
	private player seatC;

	private Integer readypersonnumer = 0;

	public player getSeatA() {
		return seatA;
	}

	public void setSeatA(player seatA) {
		if (this.seatA == null) {
			this.seatA = seatA;
			readypersonnumer++;
		}
	}

	public void removeSeatA() {
		if (this.seatA != null) {
			this.seatA = null;
			readypersonnumer--;
		}
	}

	public player getSeatB() {
		return seatB;
	}

	public void setSeatB(player seatB) {
		if (this.seatB == null) {
			this.seatB = seatB;
			readypersonnumer++;
		}
	}

	public void removeSeatB() {
		if (this.seatB != null) {
			this.seatB = null;
			readypersonnumer--;
		}
	}

	public player getSeatC() {
		return seatC;
	}

	public void setSeatC(player seatC) {
		if (this.seatC == null) {
			this.seatC = seatC;
			readypersonnumer++;
		}
	}

	public void removeSeatC() {
		if (this.seatC != null) {
			this.seatC = null;
			readypersonnumer--;
		}
	}

	public Integer getReadypersonnumer() {
		return readypersonnumer;
	}

	public void setReadypersonnumer(Integer readypersonnumer) {
		this.readypersonnumer = readypersonnumer;
	}
}
