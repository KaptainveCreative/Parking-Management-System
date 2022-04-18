package casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class ListFormBean {

    private Integer id;

    //@NotBlank(message="Zipcode field is required")
    private Integer zipcode;

    //@NotBlank(message="Price field is required")
    private BigDecimal price;


    private Integer rating;

    //@NotBlank(message="Status field is required")
    private String status;

   // @NotBlank(message="State field is required")
    private String state;

    //@NotBlank(message="Spot count field is required")
    private int quantity;

    private String companyName;


}