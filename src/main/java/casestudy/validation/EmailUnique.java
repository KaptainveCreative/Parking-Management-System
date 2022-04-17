package casestudy.validation;


import javax.validation.*;
import java.lang.*;
import java.lang.annotation.*;


@Documented
@Constraint( validatedBy = EmailUniqueImpl.class)
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnique {

    String message() default "{UserEmailUnique}";
    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};

}
