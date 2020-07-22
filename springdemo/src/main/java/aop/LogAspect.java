package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
//	@Pointcut("execution (* aop.Order.*(..))")
//	public void orderMethods() {
//	}

	@Before(value = "execution (* aop.Order.*(..))")
	public void beforeAdviceMethod(JoinPoint jp) {
		System.out.println("Before Advice --> " + jp.getSignature());
	}

//	@After(value = "execution (* aop.Order.get*(..))")
//	public void afterAdviceMethod(JoinPoint jp) {
//		System.out.println("After Advice --> " + jp.getSignature());
//	}

	
//	@After(value = "execution (* aop.Order.*(..))")
//	public void beforeAdvice(JoinPoint jp) {
//		System.out.println("After Advice 2 --> " + jp.getSignature());
//	}

//	@After("orderMethods()")
//	public void afterAdviceOrderMethods(JoinPoint jp) {
//		System.out.println("After Advice With Order Method --> " + jp.getSignature());
//	}

//	@Around(value = "execution (* aop.Order.get*(..))")
//	public void aroundAdviceMethod(ProceedingJoinPoint pjp) {
//		System.out.println("Before calling : " + pjp.getSignature());
//		try {
//			Object obj = pjp.proceed(pjp.getArgs()); // Call method in Target 
//			System.out.println("Returned : " + obj);
//		} catch (Throwable ex) {
//
//		}
//		System.out.println("After completing : " + pjp.getSignature());
//	}

}
