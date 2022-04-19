package casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class ReserveFormBean {

    private Integer id;

    private String zicode;

    private Timestamp date;



}
