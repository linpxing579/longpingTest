package bean;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

    public String name() default "";

    public boolean isNotNull() default false;

    public int min() default Integer.MIN_VALUE;

    public int max() default Integer.MAX_VALUE;

    public int minLength() default -1;

    public int maxLength() default -1;

    public String validValue() default "";
}
