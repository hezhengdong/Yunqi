package com.ityunqi.web.servlet.Cservlet;

import com.ityunqi.service.C.ShopcartService;
import com.ityunqi.service.impl.ShopcartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//临时这么设置cookie吧

@WebServlet("/setCookie")
public class cookie extends HttpServlet {
    private ShopcartService shopcartService = new ShopcartServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("userid", "2");
        resp.addCookie(cookie);
        System.out.println("成功设置cookie");


    }


}
