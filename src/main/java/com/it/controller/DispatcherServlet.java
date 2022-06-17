package com.it.controller;

/**
 * @ClassName: DisoatcherServlet
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */

import com.it.controller.frontend.MainPageController;
import com.it.controller.superadmin.HeadLineOperationController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作为派发类，派发请求
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("request path is: "+req.getServletPath());
        System.out.println("request methods is: "+req.getMethod());

        if(req.getServletPath()=="/frontend/getmainpageinfo" && req.getMethod()=="GET"){
            new MainPageController().getMainPageInfo(req,resp);
        }else if(req.getServletPath()=="/superadmin/addheadline" && req.getMethod()=="POST"){
            new HeadLineOperationController().addHeadLine(req,resp);
        }
    }

}
