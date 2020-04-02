package pokerGameDDZ;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class gameContent {
	/**
	 * 斗地主个人版
	 * 1牌桌初始化                     （指定玩家位置，顺时针） 	 * 3扑克牌初始化    （扑克存储器）  
	 * 2等待玩家就位，准备   （标记玩家顺序,全员准备完毕才能开始3）

	 * 4洗牌，自动发牌，随机指定首家叫牌   （扑克按顺序发）
	 * 5顺时针判定地主与农民，若是一圈未能定出地主，则重复步骤4-5 （标记轮次2），若第二轮依然未决出，则自动判定首家地主
	 * 6地主优先出牌，顺时针判定玩家是否可以接牌 (比较牌组大小）,判定玩家剩余卡牌是否=0，=0时获胜。
	 * =0时本轮牌局结束,打印结果,给出是否继续按钮
	 */
	
	private gameTable table;
	//本桌牌序，初始化时，和数组索引一致，0-53分别对应poker[]中对应索引的唯一一张牌 ,洗牌时打乱本数组顺序
	private int[] inr = new int[54];
	private SingletonBase getinstance;
	//标记谁是首家,不变动，随机到就是谁
	private int indexspiltint=-1;
	//标记谁是地主，变动
	private int indexspiltint2=-1;	
	
	//当局全员放弃轮次
	private int curremtluc = 0;
	
	private String stA =table.getSeatA().getPlayerDisplayName();
	private String stB =table.getSeatB().getPlayerDisplayName();
	private String stC =table.getSeatC().getPlayerDisplayName();	
		
	public void start(){
		curremtluc = 0;
		getinstance = SingletonBase.getinstance();
		this.step1();
		this.step3();
		this.step2();
	}
	//初始化牌桌
	public void step1(){
		Long createTableToQuence = gameTableFactory.createTableToQuence();
		table = getinstance.getMaptable().get(createTableToQuence);
	}	
	//初始化玩家
	public void step2(){
		player createPlayerToQuence = playerFactory.createPlayerToQuence("花湖", "1");
		player createPlayerToQuenc2 = playerFactory.createPlayerToQuence("花火", "2");
		player createPlayerToQuenc3 = playerFactory.createPlayerToQuence("花花", "3");
		table.setSeatA(createPlayerToQuence);
		table.setSeatB(createPlayerToQuenc2);
		table.setSeatC(createPlayerToQuenc3);
		if(table.getReadypersonnumer()==3){
			this.step4();
		}
	}
	//初始化扑克
	public void step3(){
		new pokerFactory().initporker();
		for(int i=0;i<inr.length;i++){
			inr[i]=i;
		}
	}
	//洗牌，加发牌
	public void step4(){
		//开始洗牌
		//先来左向的100次
		int m = 0;
		while(m<50){
			oneMovePoker1(inr);
			m++;
		}
		//再来右向的60次
		m = 0;
		while(m<60){
			oneMovePoker2(inr);
			m++;
		}		
		System.out.println("洗牌完毕");

		//洗牌完毕,打印一下牌序
		System.out.println(Arrays.toString(inr));	
		
		//发牌前，初始化每人手牌
		table.getSeatA().setPokerrpnumber(0);
		table.getSeatB().setPokerrpnumber(0);
		table.getSeatC().setPokerrpnumber(0);
		//发牌，留三张
		for(int i=0;i<inr.length-3;i++){
			poker poker = getinstance.porkerr[inr[i]];
			if(i%3==0){				
				table.getSeatA().giveOnePoker(poker);
			}
			if(i%3==1){
				table.getSeatB().giveOnePoker(poker);
			}
			if(i%3==2){
				table.getSeatC().giveOnePoker(poker);
			}			
		}
		System.out.println("发牌完毕");
		printAllplayerpoker();		
		
		this.step5();		
	}
	public void printAllplayerpoker() {
		//再次打印下各家的牌组
		System.out.println("玩家"+table.getSeatA().getInfoOfPlayer());
		System.out.println("玩家"+table.getSeatB().getInfoOfPlayer());
		System.out.println("玩家"+table.getSeatC().getInfoOfPlayer());
	}
	@Test
	public void testxipai() {
		int[] inrtmp = new int[54];
		for(int i=0;i<inrtmp.length;i++){
			inrtmp[i]=i;
		}		
		System.out.println("洗牌前:"+Arrays.toString(inrtmp));	
		//先来左向的50次
		int m = 0;
		while(m<50){
			oneMovePoker1(inrtmp);
			m++;
		}
		//再来右向的50次
		m = 0;
		while(m<50){
			oneMovePoker2(inrtmp);
			m++;
		}		
		System.out.println("洗牌完毕");

		//洗牌完毕,打印一下牌序
		System.out.println(Arrays.toString(inrtmp));	
	}
	private int callDZ(String st, String st2,player pl,int indexspilt) {
		System.out.println(st2+st);
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()){
			String next = sc.next();
			if("是".equals(next)){
				giveDZ(pl);
			}else{
				return (indexspilt+1)%3;
			}			
		}
		return -1;
	}
	private void giveDZ(player pl) {
		poker poker = getinstance.porkerr[inr[51]];
		pl.giveOnePoker(poker);
		poker = getinstance.porkerr[inr[52]];
		pl.giveOnePoker(poker);
		poker = getinstance.porkerr[inr[53]];
		pl.giveOnePoker(poker);
		printAllplayerpoker();
		this.step6();
	}
	//随机移动一张牌到第一张
	private void oneMovePoker1(int[] inrtmp) {
		int indexspilt =  (int)(Math.random()*53);
		while(indexspilt==0||indexspilt>53){
			indexspilt =  (int)(Math.random()*53);
		}
		int tmp = inrtmp[indexspilt];
		for(int j=indexspilt;j>0;j--){
			inrtmp[j]=inrtmp[j-1];
		}
		inrtmp[0]=tmp;
	}	
	//随机移动一张牌到最后一张
	private void oneMovePoker2(int[] inrtmp) {
		int indexspilt =  (int)(Math.random()*53);
		while(indexspilt>53||indexspilt<0){
			indexspilt =  (int)(Math.random()*53);
		}
		int tmp = inrtmp[indexspilt];
		for(int j=indexspilt;j<53;j++){
			inrtmp[j]=inrtmp[j+1];
		}
		inrtmp[53]=tmp;
	}	
	//叫地主
	public void step5(){
		//随机首家叫牌
		int indexspilt =  (int)(Math.random()*3);
		if(indexspilt<2){
			//首家,不变动，随机到就是谁
			indexspiltint = indexspilt;
			//地主，变动
			indexspiltint2 = indexspilt;			
		}else{
			//首家,不变动，随机到就是谁
			indexspiltint = 2;
			//地主，变动
			indexspiltint2 = 2;			
		}
		
		String st = "是否叫地主?请输入是或否";
		while(indexspiltint2>-1){
			if(indexspiltint2==0){
				indexspiltint2 = callDZ(st, stA,table.getSeatA(),indexspiltint2);
			}else if(indexspiltint2==1){
				indexspiltint2 = callDZ(st, stB,table.getSeatB(),indexspiltint2);
			}else{
				indexspiltint2 = callDZ(st, stC,table.getSeatC(),indexspiltint2);
			}
			curremtluc++;
			if(curremtluc/3 ==1&& curremtluc%3 ==0){
				this.step4();
				break;
			}
			if(curremtluc/3 ==2&& curremtluc%3 ==0){
				if(indexspiltint==0){
					giveDZ(table.getSeatA());
				}else if(indexspiltint==1){
					giveDZ(table.getSeatB());
				}else{
					giveDZ(table.getSeatC());
				}
				indexspiltint2 = indexspiltint;
				break;
			}			
		}		
	}	
	//开战
	public void step6(){
		//地主先出
		if(indexspiltint2==0){
			System.out.println(stA+"请出牌,请输入打出的牌组！");
			Scanner sc = new Scanner(System.in);
			if(sc.hasNext()){
				String next = sc.next();
				next = next.trim();
			}
		}else if(indexspiltint2==1){
			
		}else{
			
		}
	}	
	public void end(){
		
	}	
}
