package testSpringApplication;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import scanerpac.entity.user.Account;
import scanerpac.mybatisRunning.MybatisBusiness;
import scanerpac.mybatisServer.AccountService;
import scanerpac.mybatisServer.SeqsService;
import scanerpac.springjdbc.MyJdbcDaoSupport2;
import scanerpac.springjdbc.baseDao;
import scanerpac.springjdbc.springJdbcDao;

public class FistSpringProgram  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化容器   classpath路径下
		FistSpringProgram sdf = new FistSpringProgram();
		
//		sdf.testMybatis3();
		sdf.testMybatis4();
			
		
	}
	public  void test() {
		System.out.println(System.getProperty("java.class.path")); 
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springbasic/SpringMVC.xml");
		String id = applicationContext.getId();
		System.out.println("applicationContext id:"+id);
	
		//初始化容器   系统文件路径下
/*		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"workspace"+File.separator+"JAVABasic"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"springbasic"+File.separator+"SpringMVC.xml");
		String id = applicationContext.getId();
		System.out.println("applicationContext2 id:"+id);*/
		
		
		AnimalsServices service = (AnimalsServices)applicationContext.getBean("animalServicecat");
		service.run();
		AnimalsServices service2 = (AnimalsServices)applicationContext.getBean("animalServicedog");
		service2.run();
	}
	@Test
	public void testSpringJdbcDao(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springbasic\\SpringMVC.xml");
		String id = applicationContext.getId();
		System.out.println("applicationContext id:"+id);
		

		baseDao base =  (baseDao)applicationContext.getBean("baseDao");
		baseDao base2 =  (baseDao)applicationContext.getBean("baseDao");
		System.out.println(base2.hashCode());
		System.out.println("===============");
		
		springJdbcDao  dao1 = (springJdbcDao)applicationContext.getBean("springJdbcDao");
		springJdbcDao  dao2 = (springJdbcDao)applicationContext.getBean("springJdbcDao");

			
	}
	
	@Test
	public void testSpringJdbcDao2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springbasic\\SpringMVC.xml");
		String id = applicationContext.getId();
		System.out.println("applicationContext id:"+id);
		MyJdbcDaoSupport2  dao2 = (MyJdbcDaoSupport2)applicationContext.getBean("myJdbcDaoSupport");
//		int querylogin = dao2.querylogin("n1", "p1");
//		System.out.println(querylogin);
		try {
			dao2.initsql();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testMybatis3(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springbasic\\SpringMVC.xml");		
		MybatisBusiness  myta = (MybatisBusiness)applicationContext.getBean("mybatisBusiness");
		myta.initAllTablePrimaryKeySeqs();
//		myta.initAllAccount();
	}	
	
	public void testMybatis4(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springbasic\\SpringMVC.xml");		
		AccountService  se2 = (AccountService)applicationContext.getBean("accountService");
		Account   acc = new Account();
		SeqsService  se3 = (SeqsService)applicationContext.getBean("sys_seqService");
		acc.setId(se3.nextSeqsBySeqId(3).getSeqCurrno().longValue());
		acc.setLoginname("username");
		try {
			acc.setPwd(com.alibaba.druid.filter.config.ConfigTools.encrypt("pwd456"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		se2.InsertAccount(acc);		
		
		
	}
	
	
	

}
