package casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString

public class ReviewBean {

    private Integer id;

    private String customerReviews;

    private Integer companyId;

}
