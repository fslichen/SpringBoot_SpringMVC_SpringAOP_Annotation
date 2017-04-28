package evolution.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)// This annotation is allowed at the class level.
@Retention(RetentionPolicy.RUNTIME)
public @interface AnyAnnotation {
	
}
