package casestudy.controller;

import casestudy.database.Entity.User;
import casestudy.database.Entity.UserRole;
import casestudy.formbean.RegisterFormBean;
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


    @RequestMapping(value ="/park/Review", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {

        ModelAndView response = new ModelAndView();


        response.setViewName("/park/Review");

        return response;
    }

}
