package casestudy.controller;

import casestudy.database.DAO.UserDAO;
import casestudy.database.DAO.UserRoleDAO;
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
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
     * This is a generic page I created so that I can test the site for Tomcat connectivity*/
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {

        ModelAndView response = new ModelAndView();


        response.setViewName("index");

        return response;
    }

    @RequestMapping(value = "/login/Signup", method = RequestMethod.GET)
    public ModelAndView Signup() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/Signup");


        return response;

    }

    /*
     * This page sets up the form*/
    @RequestMapping(value = "/login/SignupSubmit", method = RequestMethod.POST)
    public ModelAndView SignupSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();


        log.debug(form.toString());
        response.setViewName("login/Signup");


        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                //errors.put(((FieldError) error).getField(), error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errorMessages", errorMessages);


            response.addObject("bindingResult", bindingResult);

            response.setViewName("login/Signup");

            return response;
        }


        User user = new User();
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        //user.setPassword(form.getPassword());
        user.setPaymentMethod(form.getPaymentMethod());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setDate(new Date());

        String password = passwordEncoder.encode(form.getPassword());

        user.setPassword(password);
        userDAO.save(user);


        Integer newUserId = userDAO.findByEmail(user.getEmail()).getId();
        UserRole newUserRole = new UserRole();
        newUserRole.setUserRole("USER");
        newUserRole.setUserId(newUserId);
        userRoleDAO.save(newUserRole);


        response.setViewName("redirect:/login/login");
        return response;

    }


}
