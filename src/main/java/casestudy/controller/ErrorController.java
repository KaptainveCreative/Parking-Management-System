package casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(AccessDeniedException.class)
    @RequestMapping(value = "/error/404")
    public ModelAndView handleAllException(HttpServletRequest request, Exception ex) {
        log.error("Error page exception : " + getRequestURL(request), ex);

        ModelAndView model = new ModelAndView("error/500");

        String stackTrace = getHTMLStackTrace(ExceptionUtils.getStackFrames(ex));

        model.addObject("requestUrl", getRequestURL(request));
        model.addObject("message", ex.getMessage());
        model.addObject("stackTrace", stackTrace);

        if (ex.getCause() != null) {
            Throwable root = ExceptionUtils.getRootCause(ex);
            model.addObject("rootcause", root);

            String rootTrace = getHTMLStackTrace(ExceptionUtils.getStackFrames(ex));
            model.addObject("rootTrace", rootTrace);
        }

        return model;
    }

    private String getHTMLStackTrace(String[] stack) {

        StringBuffer result = new StringBuffer();

        for (String frame : stack) {
            if (frame.contains("casestudy")) {
                result.append(" &nbsp; &nbsp; &nbsp;" + frame.trim().substring(3) + "<br>\n");
            } else if (frame.contains("Caused by:")) {
                result.append("Cause By: " + frame + "<br>");
            }
        }

        return result.toString();
    }

    private String getRequestURL(HttpServletRequest request) {
        String result = request.getRequestURL().toString();
        if (request.getQueryString() != null) {
            result = result + "?" + request.getQueryString();
        }

        return result;
    }
}