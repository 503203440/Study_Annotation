
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 包的所有者
 */
@Retention(RetentionPolicy.RUNTIME)//此注解在运行时起作用
@Target({ElementType.METHOD,ElementType.TYPE})//此注解用在方法上
public @interface PackageOwner {

    public String value() default "null";

    public Class getInfoClass() default Object.class;

    public String getInfoString() default "null";
}
