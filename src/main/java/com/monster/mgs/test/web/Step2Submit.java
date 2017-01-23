package com.monster.mgs.test.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.monster.mgs.test.web.WizardForm.WIZARD_FORM_NAME;

/**
 */
public class Step2Submit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        WizardForm wizardForm = (WizardForm) session.getAttribute(WIZARD_FORM_NAME);

        String trainingCourseSection = req.getParameter("trainingCourseSection");
        String rating = req.getParameter("trainingCourseSection");
        String comments = req.getParameter("comments");

        wizardForm.setTrainingCourseSectionId(Long.valueOf(trainingCourseSection));
        wizardForm.setRating(Integer.valueOf(rating));
        wizardForm.setComments(comments);

        String nextJSP = "/step3.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
