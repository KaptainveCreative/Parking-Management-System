package casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {


    @RequestMapping(value = "/login/login", method = RequestMethod.GET)

    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/loginForm"); // must match the jsp file name

        return response;

    }
}



