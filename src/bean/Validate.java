package bean;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

    public String name() default "";

    public int min();

    public int max();

    public boolean isNotNull() default false;
}
