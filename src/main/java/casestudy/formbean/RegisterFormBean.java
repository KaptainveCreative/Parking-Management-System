package casestudy.formbean;
import casestudy.validation.EmailUnique; //--> it is not working for me
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id; // This id will be null in the case of a create

    @NotBlank ( message =  "First Name is required")
    private String firstName;
        /*------------------------------*/

    @NotBlank ( message =  "Last Name is required")
    private String lastName;
    /*------------------------------*/

    @NotBlank(message="Email is required")
    @EmailUnique(message="Email is already in use.") //--> it is not working for me
    @Email(message = "Not a valid email format")
    //@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}\n", message = "Email format invalid") //--> not working for me
    private String email;
    /*------------------------------*/

    @NotBlank ( message =  "Payment Method is required")
    private String paymentMethod;
    /*------------------------------*/

    @Length(min=10, max=10, message = "Phone Number must be 10 digits long")
    @NotBlank ( message =  "Phone Number is required")
    private String phoneNumber;
    /*------------------------------*/

    @Length(min=3, max=15, message = "Password must be between 3 and 15 characters")
    @NotBlank ( message =  "Password is required")
    private String password;
    /*------------------------------*/

    @NotBlank ( message =  "Confirm Password is required")
    private String confirmPassword;





    //@AssertTrue(message = "Checkbox is required")
    //private boolean checkbox;
}
