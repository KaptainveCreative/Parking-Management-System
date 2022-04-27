/*
* The ReserveController class helps to reserve a parking spot
* The set-up:
*  It uses a path variable to grab the id of the parking spot.
* Once done, that idea will be  mapped to current spots and prompt user for time and date and shows current user their reservations
* if not, then it would stay at the search page for all parking spots*/

package casestudy.controller;


import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.DAO.ReserveDAO;
import casestudy.database.DAO.UserDAO;
import casestudy.database.Entity.ParkingSpot;
import casestudy.database.Entity.Reservation;
import casestudy.database.Entity.User;
import casestudy.security.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class ReserveController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    UserDetailsServiceImpl userService;
    @Autowired
    private ReserveDAO reserveDAO;

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;


    @RequestMapping(value = {"/park/Reserve/{parkingSpotId}", "/park/Reserve"}, method = RequestMethod.GET)
    public ModelAndView reserveView(@PathVariable(required = false) Integer parkingSpotId) throws Exception {
        ModelAndView response = new ModelAndView();


        response.setViewName("park/Reserve");

        //userService.getCurrentUser() -- > grab the logged in user from the database
        //getReservations() ---> getting reservations that belongs to this user ( it is joining on a user ID )
        response.addObject("reservationList", userService.getCurrentUser().getReservations());


        response.addObject("hideForm", parkingSpotId == null);

        return response;
    }


    //    -------------------------------------------------------------------------------

    @PostMapping(value = "/park/Reserve/{parkingSpotId}")

    public String reserveSpot(@PathVariable Integer parkingSpotId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date date) throws Exception {

        log.debug("The current logged in user");


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userObj = userDAO.findByEmail(username);
        log.info(userObj.toString());


        User user = new User();
        ParkingSpot parkingSpot = parkingSpotDAO.getById(parkingSpotId); //getting the entity from the database using the id so you can set the relationship
        parkingSpot.setStatus("Not Available");

        Reservation reserve = new Reservation();

        reserve.setDate(date);
        reserve.setZipcode(parkingSpot.getZipcode());
        reserve.setParkingspot(parkingSpot);


        reserve.setUser(userService.getCurrentUser());


        reserveDAO.save(reserve);


        return "redirect:/park/Search";


    }


}
