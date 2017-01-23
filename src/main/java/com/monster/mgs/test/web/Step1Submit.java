package com.monster.mgs.test.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.monster.mgs.test.web.WizardForm.WIZARD_FORM_NAME;

/**
 */
public class Step1Submit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        WizardForm wizardForm = (WizardForm) session.getAttribute(WIZARD_FORM_NAME);

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String emailAddress = req.getParameter("emailAddress");
        String trainingCourse = req.getParameter("trainingCourse");
        String trainingCourseDate = req.getParameter("trainingCourseDate");

        wizardForm.setFirstName(firstName);

        wizardForm.setLastName(lastName);
        wizardForm.setEmailAddress(emailAddress);
//        try {
//            wizardForm.setTrainingCourseDate(new SimpleDateFormat("dd/mm/yy").parse(trainingCourseDate));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        wizardForm.setTrainingCourseId(Long.valueOf(trainingCourse));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/step2Init");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
