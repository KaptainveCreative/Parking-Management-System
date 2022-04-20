package casestudy.controller;


import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.DAO.ReserveDAO;
import casestudy.database.Entity.ParkingSpot;
import casestudy.database.Entity.Reservation;
import casestudy.security.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Slf4j
@Controller
public class ReserveController {


    @Autowired
    UserDetailsServiceImpl userService;
    @Autowired
    private ReserveDAO reserveDAO;

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;


    @RequestMapping( value = "/park/Reserve" , method = RequestMethod.GET)
    public ModelAndView reserveView() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("park/Reserve");

        return  response;
    }

// add erad me


    // /js unit
    // add preauth
    // if statment in JSTL
    // use log.debug really important
    // have a dropdown to the ids
    // Make sure you show Junit
    // Make sure you show security

//    ----------------------------------------------------
    //@GetMapping(value = "/park/reserve/{parkingSpotId}")
    @PostMapping ( value = "/park/reserve/{parkingSpotId}" )
    public ModelAndView reserveSpot(@PathVariable Integer parkingSpotId ,@RequestParam Date date) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("park/Reserve");


        ParkingSpot parkingSpot = parkingSpotDAO.getById(parkingSpotId); //getting the entity from the database using the id so you can set the relationship

        // 1 - Grab the id and map it to the database
        Reservation reserve = new Reservation();

        reserve.setDate(date);
        reserve.setZipcode(parkingSpot.getZipcode());
        reserve.setParkingspot(parkingSpot);


        reserve.setUser(userService.getCurrentUser());

        reserveDAO.save(reserve);

        // 2 - update the quantity for both the total count and for what the user is reserving

        // 3 - Have a join query that does show Quantity, time, and zipcode of that particular spot



       //response.addObject("form", form);



        return  response;
    }


}
