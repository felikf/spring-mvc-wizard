package com.monster.mgs.test.web;

import com.monster.mgs.test.BeanHelper;
import com.monster.mgs.test.dao.GenericDaoImpl;
import com.monster.mgs.test.dao.VisitorDao;
import com.monster.mgs.test.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 */
public class Test extends HttpServlet {

    @Autowired
    VisitorDao visitorDao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }


    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {

//        Visitor visitor = visitorDao.get(0L);
//
//        System.out.println(visitor);
    }
}
