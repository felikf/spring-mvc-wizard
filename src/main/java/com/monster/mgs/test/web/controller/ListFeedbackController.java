package com.monster.mgs.test.web.controller;

import com.monster.mgs.test.dao.TrainingCourseFeedbackDao;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller: list available feedbacks.
 */
@Controller
public class ListFeedbackController {

    @Autowired
    private TrainingCourseFeedbackDao feedbackDao;

    @RequestMapping("/list")
    public String helloWorld(Model model, WebRequest request, HttpServletRequest httpServletRequest) {
        List<TrainingCourseFeedback> feedbacks = feedbackDao.findAll();
        model.addAttribute("feedbacks", feedbacks);

        Object message = httpServletRequest.getSession().getAttribute("message");

        if (message !=  null) {
            httpServletRequest.getSession().removeAttribute("message");
            model.addAttribute("message", message);
        }

        return "listFeedback";
    }

}
