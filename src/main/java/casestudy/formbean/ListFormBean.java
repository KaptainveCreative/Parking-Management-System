package casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class ListFormBean {


    private Integer id;

    @Digits(message = "Zipcode field is required", integer = 5, fraction = 0)
    @NotNull(message = "Zipcode field is required")
    private Integer zipcode;

    @NotNull(message = "Price field is required")
    private Double price;


    private Integer rating;

    @NotEmpty(message = "Status field is required")
    private String status;

    @NotEmpty(message = "State field is required")
    private String state;

    //@NotNull(message="Spot count field is required")
    private Integer quantity;

    @NotEmpty(message = "You must provide the name of the spot to be addressed as")
    private String companyName;


}