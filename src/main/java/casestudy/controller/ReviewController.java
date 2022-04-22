package casestudy.controller;

import casestudy.database.DAO.CompanyDAO;
import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.DAO.ReviewDAO;
import casestudy.database.Entity.*;
import casestudy.formbean.ReviewFormBean;
import casestudy.security.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


import java.util.List;

@Slf4j
@Controller
public class ReviewController {

    @Autowired
    private ReviewDAO reviewDAO;

    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;

    @RequestMapping(value ="/park/Review", method = RequestMethod.GET)
    public ModelAndView review() throws Exception {

        ModelAndView response = new ModelAndView();

        List<Review> allReviews = reviewDAO.findAll();

        List<ParkingSpot> allparkingSpots = parkingSpotDAO.findAll(); // finding All spots


        response.addObject("allparkingSpots", allparkingSpots);
        response.addObject("allReviews", allReviews);

        response.setViewName("/park/Review");

        return response;
    }





    @RequestMapping(value = "/park/ReviewSubmit", method = {RequestMethod.POST,RequestMethod.GET })

    public ModelAndView reviewSubmit(@Valid ReviewFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info(form.toString());


        Review review = new Review();

        Company company = companyDAO.getById(form.getCompanyId());

        review.setCompany(company);

        review.setCustomerReviews(form.getCustomerReviews());
        review.setCustomerName(form.getCustomerName());

        reviewDAO.save(review);

       response.setViewName("redirect:/park/Review");
        return response;

    }




     @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping( "/park/Review/{id}")
    public ModelAndView deleteReviews(@PathVariable Integer id ) {
        ModelAndView response = new ModelAndView();

        response.setViewName("park/Review");


        // This method will populate the all the companies and let the user giver a review using the id

         Review deleteReview = reviewDAO.getById(id); // finding All spots
         log.info(id.toString());

         reviewDAO.deleteById(id);
         log.info(deleteReview.toString());




       // response.addObject("deleteReview", deleteReview);

        response.setViewName("redirect:/park/Review");

        return response;
    }




}
