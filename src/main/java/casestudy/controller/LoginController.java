package casestudy.controller;


import casestudy.formbean.LoginFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class LoginController {


    @RequestMapping(value = "/login/login", method = RequestMethod.GET)

    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/loginForm"); // must match the jsp file name

        return response;

    }

    @RequestMapping(value = "/login/loginSubmit", method = RequestMethod.POST)

    public ModelAndView loginSubmit(@Valid LoginFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info(form.toString());

        log.debug(form.toString());

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


        response.setViewName("login/loginForm"); // must match the jsp file name

        return response;

    }
}



