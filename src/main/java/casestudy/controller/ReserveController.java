package casestudy.controller;


import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.DAO.ReserveDAO;
import casestudy.database.Entity.ParkingSpot;
import casestudy.database.Entity.Reservation;
import casestudy.database.Entity.User;
import casestudy.security.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class ReserveController {


    @Autowired
    UserDetailsServiceImpl userService;
    @Autowired
    private ReserveDAO reserveDAO;

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;


    @RequestMapping(value = {"/park/Reserve/{parkingSpotId}","/park/Reserve"} , method = RequestMethod.GET)
    public ModelAndView reserveView(@PathVariable ( required = false) Integer parkingSpotId) throws Exception {
        ModelAndView response = new ModelAndView();



        response.setViewName("park/Reserve");

    //userService.getCurrentUser() -- > grab the logged in user from the database
        //getReservations() ---> getting reservations that belongs to this user ( it is joining on a user ID )
        response.addObject("reservationList", userService.getCurrentUser().getReservations());

        response.addObject("hideForm", parkingSpotId==null);

        return response;
    }

// add erad me


    // /js unit
    // add preauth
    // if statment in JSTL
    // use log.debug really important
    // have a dropdown to the ids
    // Make sure you show Junit
    // Make sure you show security

    //    -------------------------------------------------------------------------------
    //@GetMapping(value = "/park/reserve/{parkingSpotId}")
    @PostMapping(value = "/park/reserve/{parkingSpotId}")
    //@Date_TimeFormat(iso = DateTimeFormat.ISO.DATE) Date date)
    public String reserveSpot(@PathVariable Integer parkingSpotId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  Date date) throws Exception {


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


        return "redirect:/park/Search";



    }


}
