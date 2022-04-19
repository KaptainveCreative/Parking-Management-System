package casestudy.controller;


import casestudy.database.DAO.ReserveDAO;
import casestudy.database.Entity.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ReserveController {

    @Autowired
    private ReserveDAO reserveDAO;


    @RequestMapping( value = "/park/Reserve" , method = RequestMethod.GET)
    public ModelAndView reserveView() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("park/Reserve");

        return  response;
    }


//    ----------------------------------------------------
    @GetMapping(value = "/park/reserve/{zipcode}")
    @RequestMapping( value = "/park/ReserveSpot" , method = RequestMethod.GET)
    public ModelAndView reserveSpot(@PathVariable Integer zipcode) throws Exception {
        ModelAndView response = new ModelAndView();

        Reservation reserve = reserveDAO.getByZipcode(zipcode);

        response.setViewName("park/Reserve");



        return  response;
    }


}
