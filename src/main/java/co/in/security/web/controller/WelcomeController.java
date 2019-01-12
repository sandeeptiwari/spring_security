package co.in.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This displays the welcome screen that shows what will be happening in this chapter.
 *
 * @author Sandeep Tiwari
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
        return "home";
    }
}
