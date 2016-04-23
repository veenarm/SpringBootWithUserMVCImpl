package controllers;

import exceptions.GlobalExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {
    private static final String PATH = "/error";

    /**
     * Overrides the generic errors
     * @param req
     * @param exception
     * @return
     */
    @RequestMapping(value = PATH)
    public ModelAndView error(HttpServletRequest req, Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.addObject("date", new Date());
        mav.addObject("url", req.getRequestURL());
        mav.addObject("ip", req.getRemoteAddr());
        mav.addObject("isAjax", isAjax(req));
        mav.addObject("request", req);
        mav.setViewName(GlobalExceptionHandler.DEFAULT_ERROR_VIEW);
        return mav;
    }

    private boolean isAjax(HttpServletRequest request) {
        String requestedWithHeader = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestedWithHeader);
    }


    @Override
    public String getErrorPath() {
        return PATH;
    }


    @RequestMapping(value = PATH +"/test")
    public String errorTest() {
        throw new RuntimeException("horrible exception");
    }
}
