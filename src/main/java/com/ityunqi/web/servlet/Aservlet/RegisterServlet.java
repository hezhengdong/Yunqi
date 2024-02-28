package com.ityunqi.web.servlet.Aservlet;

import com.ityunqi.pojo.Result;
import com.ityunqi.pojo.User;
import com.ityunqi.service.A.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/registerServlet")

public class RegisterServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        boolean flag = service.register(user);
        if(flag){
            Result successResult = Result.success("注册成功");

            request.setAttribute("result", successResult);
            request.getRequestDispatcher("/userlogin.jsp").forward(request, response);

        }
        else {
            Result errorResult = Result.error("注册失败");
            request.setAttribute("result", errorResult);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}