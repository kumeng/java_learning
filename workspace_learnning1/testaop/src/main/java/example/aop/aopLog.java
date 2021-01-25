package example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class aopLog {
	@Before("execution(* example.service.inputServiceImpl.*(..))")
	public void beforeLog(){
		System.out.println("前置日志");
	}
	@AfterReturning("execution(* example.service.inputServiceImpl.*(..))")
	public void afterReturnLog(){
		System.out.println("后置日志@AfterReturning");
	}
	@After("execution(* example.service.inputServiceImpl.*(..))")
	public void afterLog(){
		System.out.println("后置日志@After");
	}	
	@Around("execution(* example.service.inputServiceImpl.*(..))")
	public void aroundLog(ProceedingJoinPoint pj){
//		System.out.println(pj.getTarget());
//		System.out.println(pj.getKind());
//		System.out.println(pj.getThis());
		System.out.println("环绕前:"+pj.getArgs()[0]);
		try {
			Object proceed = pj.proceed();
			System.out.println("环绕后:"+proceed);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
