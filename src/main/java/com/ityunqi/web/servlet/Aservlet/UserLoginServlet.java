/*package com.ityunqi.web.servlet.Aservlet;

import com.ityunqi.pojo.Result;
import com.ityunqi.pojo.User;
import com.ityunqi.service.A.UserService2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/userLoginServlet")

public class UserLoginServlet extends HttpServlet {
    private UserService2 service=new UserService2();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = service.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // 返回登录成功的 Result 对象
            Result successResult = Result.success("登录成功");
            response.getWriter().write(successResult.toString());
        } else {
            request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doGet(request,response);
    }
}*/