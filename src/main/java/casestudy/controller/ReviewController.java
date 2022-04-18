package casestudy.controller;

import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.DAO.ReviewDAO;
import casestudy.database.Entity.ParkingSpot;
import casestudy.database.Entity.Review;
import casestudy.database.Entity.User;
import casestudy.database.Entity.UserRole;
import casestudy.formbean.ListFormBean;
import casestudy.formbean.RegisterFormBean;
import casestudy.formbean.ReviewBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;


import java.util.List;

@Slf4j
@Controller
public class ReviewController {

    @Autowired
    private ReviewDAO reviewDAO;


    @Autowired
    private ParkingSpotDAO parkingSpotDAO;

    @RequestMapping(value ="/park/Review", method = RequestMethod.GET)
    public ModelAndView review() throws Exception {

        ModelAndView response = new ModelAndView();


        response.setViewName("/park/Review");

        return response;
    }





    @GetMapping( "/park/ReviewAll")
    public ModelAndView search( ) {
        ModelAndView response = new ModelAndView();

        response.setViewName("park/Review");


        // This method will populate the all the companies and let the user giver a review using the id
        List<ParkingSpot> allparkingSpots = parkingSpotDAO.findAll(); // finding All spots


        response.addObject("allparkingSpots", allparkingSpots);

        response.setViewName("park/Review");

        return response;
    }


    @RequestMapping(value = "/park/ReviewSubmit", method = {RequestMethod.POST,RequestMethod.GET })

    public ModelAndView listSubmit(@Valid ReviewBean form) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info(form.toString());


        Review review = new Review();

        review.setId(form.getCompanyId());
        review.setCustomerReviews(form.getCustomerReviews());

        reviewDAO.save(review);

        response.setViewName("/park/Review");
        return response;

    }


    }
