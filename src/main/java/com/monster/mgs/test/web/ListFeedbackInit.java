package com.monster.mgs.test.web;

import com.monster.mgs.test.dao.TrainingCourseDao;
import com.monster.mgs.test.dao.TrainingCourseFeedbackDao;
import com.monster.mgs.test.model.TrainingCourseFeedback;
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
import java.util.List;

import static com.monster.mgs.test.web.WizardForm.WIZARD_FORM_NAME;

/**
 * Start of the wizard.
 *
 * Creates a new session if not exists already.
 */
public class ListFeedbackInit extends HttpServlet {

    @Autowired
    private TrainingCourseFeedbackDao feedbackDao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<TrainingCourseFeedback> feedbacks = feedbackDao.findAll();

        req.setAttribute("feedbacks", feedbacks);

        Object message = req.getSession().getAttribute("message");

        if (message !=  null) {
            req.setAttribute("message", message);
            req.getSession().removeAttribute("message");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listFeedback.jsp");
        dispatcher.forward(req, resp);
    }

}