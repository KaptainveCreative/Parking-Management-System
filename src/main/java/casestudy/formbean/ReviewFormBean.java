package casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ReviewFormBean {

    private Integer id;

    private String customerReviews;

    private Integer companyId;

    private String customerName;

}
