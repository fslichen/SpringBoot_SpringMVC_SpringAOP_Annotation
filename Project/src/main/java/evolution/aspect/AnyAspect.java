package evolution.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component// Don't forget to make AnyAspect a component so that it is added as a bean within spring container.
public class AnyAspect {
	@Before("publicMethodWithAnnotation()")
	public void before() throws Throwable {
		System.out.println("Before method has been called.");
	}
	
	@After("publicMethodWithAnnotation()")
	public void after() throws Throwable {
		System.out.println("After method has been called.");
	}
	
	@Pointcut("within(@evolution.annotation.AnyAnnotation *)")// Intercept classes annotated by @AnyAnnotation.
	public void annotation() {
		
	}
	
	@Pointcut("execution(public * *(..))")// Intercept public methods.
	public void publicMethod() {
		
	}
	
	@Pointcut("publicMethod() && annotation()")// Intercept public methods within a class annotated by @AnyAnnotation.
	public void publicMethodWithAnnotation() {
		
	}
	
	@Around("publicMethodWithAnnotation()")
	public Object around(ProceedingJoinPoint point) throws Throwable {// ProceedingJoinPoint is only supported for around advice.
		System.out.println("Around method has been called.");
		Object[] objects = point.getArgs();
		for (Object object : objects) {
			System.out.println("Object = " + object);
		}
		return point.proceed();
	}
}
