package com.monster.mgs.test.web;

import com.monster.mgs.test.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.monster.mgs.test.web.WizardForm.WIZARD_FORM_NAME;

/**
 */
public class Step3Submit extends HttpServlet {

    @Autowired
    private FeedbackService feedbackService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        WizardForm wizardForm = (WizardForm) session.getAttribute(WIZARD_FORM_NAME);

        feedbackService.storeFeedback(wizardForm.createVisitor(), wizardForm.createFeedback());

        session.removeAttribute(WIZARD_FORM_NAME);
        session.setAttribute("message", "Feedback saved successfully.");

        resp.sendRedirect("/listFeedbackInit");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
