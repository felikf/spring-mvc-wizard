package com.monster.mgs.test.web;

import com.monster.mgs.test.dao.TrainingCourseDao;
import com.monster.mgs.test.model.TrainingCourse;
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
import java.util.List;

import static com.monster.mgs.test.web.WizardForm.WIZARD_FORM_NAME;

/**
 * Start of the wizard.
 *
 * Creates a new session if not exists already.
 */
public class Step1Init extends HttpServlet {

    @Autowired
    private TrainingCourseDao trainingCourseDao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        WizardForm wizardForm = new WizardForm();
        session.setAttribute(WIZARD_FORM_NAME, wizardForm);

        wizardForm.setAvailableTrainingCourses(trainingCourseDao.findAll());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/step1.jsp");
        dispatcher.forward(req, resp);
    }

}