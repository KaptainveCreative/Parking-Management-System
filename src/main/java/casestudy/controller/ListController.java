package casestudy.controller;

import casestudy.database.DAO.CompanyDAO;
import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.Entity.Company;
import casestudy.database.Entity.ParkingSpot;
import casestudy.formbean.ListFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@Controller
public class ListController {


    @Autowired
    ParkingSpotDAO parkingSpotDAO;


    @Autowired
    CompanyDAO companyDAO;

    @RequestMapping(value = "/park/List", method = RequestMethod.GET)

    public ModelAndView list() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("park/List");

        return response;

    }

    @RequestMapping(value = "/park/ListSubmit", method = {RequestMethod.POST,RequestMethod.GET })

    public ModelAndView listSubmit(@Valid ListFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info(form.toString());

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                //errors.put(((FieldError) error).getField(), error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage() )   ;
            }

            response.addObject("form", form);
            response.addObject("errorMessages", errorMessages);


            response.addObject("bindingResult", bindingResult);

            response.setViewName("/park/List");

            return response;
        }



/*-------------------------------------------------------------------*/

        ParkingSpot parkingSpot = new ParkingSpot();
        Company company = new Company();

        company.setCompanyName(form.getCompanyName());
        companyDAO.save(company);
            parkingSpot.setCompany(company);

        parkingSpot.setDate((new Date()));
        parkingSpot.setZipcode((form.getZipcode()));
        parkingSpot.setPrice((form.getPrice()));
        parkingSpot.setRating((form.getRating()));
        parkingSpot.setStatus((form.getStatus()));
        parkingSpot.setState((form.getState()));
        parkingSpot.setQuantity(1);

        parkingSpotDAO.save(parkingSpot);



        response.setViewName("redirect:/park/Search");
        return response;

    }


}
