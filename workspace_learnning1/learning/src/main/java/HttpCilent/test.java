package HttpCilent;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:7100/pmsStartWorkApply202005/startWork";
		String sessionId = "SESSION=60deba3e-62f3-4953-9d68-5ec6d9d40d6c; isMenu=true";
		String paramJSon = "{\"ceramicLossNumber\":5,\"cupboardFlag\":0,\"listAttachment\":[\"group1/M00/25/2B/wKgB1V5YhPWAJqRTAAPU7zS2CIY704.png\"],\"picfileList1\":[\"group1/M00/25/2B/wKgB1V5YhO6AccSmAATcS1OY_oI216.png\"],\"picfileList2\":[\"group1/M00/25/2B/wKgB1V5YhPGAVUnCAAPU7zS2CIY900.png\"],\"startDisclosureTime\":1595375186000,\"trackId\":604666,\"wardrobeFlag\":0}";		
		Thread t1 = new testThreadExtends(url,sessionId,paramJSon);
		paramJSon = "{\"ceramicLossNumber\":5\"cupboardFlag\":0,\"listAttachment\":[\"group1/M00/25/2B/wKgB1V5YhYCAKRDVAATcS1OY_oI870.png\"],\"picfileList1\":[\"group1/M00/25/2B/wKgB1V5YhPuALiiLAAPU7zS2CIY046.png\"],\"picfileList2\":[\"group1/M00/25/2B/wKgB1V5YhPiABhfmAAHHisUia34816.png\"],\"startDisclosureTime\":1595375186000,\"trackId\":604666,\"wardrobeFlag\":0}";
		Thread t2 = new testThreadExtends(url,sessionId,paramJSon);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();t2.start();
	}

}
