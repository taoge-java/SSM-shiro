package com.ssm.aspect;


//@Aspect  
//@Component
public class AspectLog {

//	@Pointcut("execution(* com.ssm.controller.IndexController.index(..))")
//	public void log(){
//	 	System.err.println("before()方法");
//	}
//	
//	@Pointcut("execution(* com.ssm.controller.IndexController.index(..))")
//    public void after(){
//    	 System.err.println("after()方法");
//	}
//	@Before("execution(* com.ssm.service.IndexService.*(..))")
	public  void before(){
		System.err.println("before()方法");
	}
	
}
