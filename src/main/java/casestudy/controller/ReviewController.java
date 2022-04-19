package casestudy.controller;

import casestudy.database.DAO.CompanyDAO;
import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.DAO.ReviewDAO;
import casestudy.database.Entity.*;
import casestudy.formbean.ReviewFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


        response.addObject("allReviews", allReviews);

        response.setViewName("/park/Review");

        return response;
    }





    @GetMapping( "/park/ReviewAll")
    public ModelAndView showReviews( ) {
        ModelAndView response = new ModelAndView();

        response.setViewName("park/Review");


        // This method will populate the all the companies and let the user giver a review using the id
        List<ParkingSpot> allparkingSpots = parkingSpotDAO.findAll(); // finding All spots


        response.addObject("allparkingSpots", allparkingSpots);

        response.setViewName("park/Review");

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

//        companyDAO.save(company);


        response.setViewName("redirect:/park/Review");
        return response;

    }


//    @GetMapping(value = "/park/Review"/*, method = {RequestMethod.POST,RequestMethod.GET }*/)
//
//    public ModelAndView reviewReturn() throws Exception {
//        ModelAndView response = new ModelAndView();
//
//        Company company = new Company();
//
////        company.getCompanyName();
//
//
////                Review review = new Review();
//
//        List<Review> allReviews = reviewDAO.findAll();
//
//
//        response.addObject("allReviews", allReviews);
////        companyDAO.save(company);
//
//
//        response.setViewName("/park/Review");
//        return response;
//
//    }

    }
