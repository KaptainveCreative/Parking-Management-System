package casestudy.formbean;

import casestudy.validation.EmailUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class LoginFormBean {

    @NotBlank(message = "username is required")
    private String email;
    /*------------------------------*/


    @Length(min = 3, max = 15, message = "Password must be between 3 and 15 characters")
    @NotBlank(message = "password is required")
    private String password;
}
