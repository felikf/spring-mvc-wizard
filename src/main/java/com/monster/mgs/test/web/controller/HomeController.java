package com.monster.mgs.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import static com.monster.mgs.test.web.WizardForm.WIZARD_FORM;

/**
 * Home controller. Initialize model, bla, bla bla.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String helloWorld(WebRequest request) {
        request.removeAttribute(WIZARD_FORM, WebRequest.SCOPE_SESSION);

        return "index";
    }

}