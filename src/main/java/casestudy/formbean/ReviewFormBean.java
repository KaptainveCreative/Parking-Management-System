package casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString

public class ReviewFormBean {

    //@NotNull(message = "Price field is required")
    private Integer id;

    private String customerReviews;

    @NotNull(message = "Price field is required")
    private Integer companyId;

    private String customerName;

}
