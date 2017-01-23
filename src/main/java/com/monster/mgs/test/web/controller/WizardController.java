package com.monster.mgs.test.web.controller;

import com.monster.mgs.test.dao.TrainingCourseDao;
import com.monster.mgs.test.dao.TrainingCourseSectionDao;
import com.monster.mgs.test.service.FeedbackService;
import com.monster.mgs.test.web.WizardForm;
import com.monster.mgs.test.web.validator.WizardFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.monster.mgs.test.web.controller.WizardController.WIZARD_FORM;

/**
 * Controller to handle wizard pages, data initialization, redirect after POST, custom per page validation.
 */
@Controller
@SessionAttributes(WIZARD_FORM)
public class WizardController {

    public static final String WIZARD_FORM = "wizardForm";

    @Autowired
    private TrainingCourseDao trainingCourseDao;

    @Autowired
    private TrainingCourseSectionDao trainingCourseSectionDao;

    @Autowired
    private FeedbackService feedbackService;

    private WizardFormValidator validator = new WizardFormValidator();

    @RequestMapping("/step1Wizard")
    public String step1Wizard() {
        return "/step1";
    }

    @RequestMapping(value = "/step2Wizard")
    public String step2Wizard() {
        return "/step2";
    }

    @RequestMapping(value = "/step3Wizard")
    public String step3Wizard() {
        return "/step3";
    }


    @RequestMapping("/step1Init")
    public String step1(Model model) {

        if (!model.containsAttribute(WIZARD_FORM)) {
            WizardForm wizardForm = new WizardForm();
            wizardForm.setAvailableTrainingCourses(trainingCourseDao.findAll());
            model.addAttribute(WIZARD_FORM, wizardForm);
        }

        return "redirect:/step1Wizard";
    }

    @RequestMapping(value = "/step2Init")
    public String step2(@ModelAttribute(WIZARD_FORM)  WizardForm wizardForm, BindingResult result, RedirectAttributes attr) {
        validator.validatePage1Form(wizardForm, result);
        attr.addFlashAttribute("org.springframework.validation.BindingResult.wizardForm", result);

        if (result.hasErrors()) {
            return "redirect:/step1Wizard";
        }

        wizardForm.setAvailableTrainingCourseSections(trainingCourseSectionDao.findAllForCourse(wizardForm.getTrainingCourseId()));
        return "redirect:/step2Wizard";
    }

    @RequestMapping(value = "/step3Init")
    public String step3(@ModelAttribute(WIZARD_FORM)  @Valid WizardForm wizardForm, BindingResult result, RedirectAttributes attr) {
        if (wizardForm.getStepTypeBack() != null) {
            wizardForm.setStepTypeBack(null);
            return "redirect:/step1Wizard";
        }

        wizardForm.setStepTypeForward(null);
        validator.validate(wizardForm, result);
        attr.addFlashAttribute("org.springframework.validation.BindingResult.wizardForm", result);

        if (result.hasErrors()) {
            return "redirect:/step2Wizard";
        }

        return "redirect:/step3Wizard";
    }

    @RequestMapping(value = "/wizardFinish")
    public String wizardFinish(@ModelAttribute(WIZARD_FORM)  @Valid WizardForm wizardForm,
                               WebRequest request, HttpServletRequest httpServletRequest, SessionStatus status) {

        if (wizardForm.getStepTypeBack() != null) {
            wizardForm.setStepTypeBack(null);
            return "redirect:/step2Wizard";
        }

        feedbackService.storeFeedback(wizardForm.createVisitor(), wizardForm.createFeedback());

        request.removeAttribute(WizardController.WIZARD_FORM, WebRequest.SCOPE_SESSION);
        httpServletRequest.getSession().setAttribute("message", "Feedback saved successfully.");
        status.setComplete();
        return "redirect:/list";
    }

    @RequestMapping(value = "/wizardStop", method = RequestMethod.GET)
    public String wizardStop(@ModelAttribute(WIZARD_FORM)  @Valid WizardForm wizardForm, WebRequest request, SessionStatus status) {
        status.setComplete();
        request.removeAttribute(WizardController.WIZARD_FORM, WebRequest.SCOPE_SESSION);
        return "redirect:/";
    }

}