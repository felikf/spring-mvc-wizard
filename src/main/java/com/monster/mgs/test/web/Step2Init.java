package com.monster.mgs.test.web;

import com.monster.mgs.test.dao.TrainingCourseSectionDao;
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
 * Start of the wizard.
 *
 * Creates a new session if not exists already.
 */
public class Step2Init extends HttpServlet {

    @Autowired
    private TrainingCourseSectionDao trainingCourseSectionDao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        WizardForm wizardForm = (WizardForm) session.getAttribute(WIZARD_FORM_NAME);

        wizardForm.setAvailableTrainingCourseSections(trainingCourseSectionDao.findAllForCourse(wizardForm.getTrainingCourseId()));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/step2.jsp");
        dispatcher.forward(req, resp);
    }

}