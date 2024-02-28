package com.ityunqi.web.servlet.Aservlet;

import com.ityunqi.pojo.Employee;
import com.ityunqi.pojo.Result;
import com.ityunqi.service.A.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/employeeLoginServlet")

public class EmployeeLoginServlet extends HttpServlet {
    private EmployeeService service=new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");
        String accesskey = request.getParameter("accesskey");
        String remember = request.getParameter("remember");
        Employee employee = service.login(number, accesskey);

        if (employee != null) {
            if("1".equals(remember)){
                Cookie c_number=new Cookie("number",number);
                Cookie c_accesskey=new Cookie("accesskeyr",accesskey);
                c_number.setMaxAge(60*60*24*7);
                c_accesskey.setMaxAge(60*60*24*7);
                response.addCookie(c_number);
                response.addCookie(c_accesskey);
            }

            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);

            // 返回登录成功的 Result 对象
            Result successResult = Result.success("登录成功");
            response.getWriter().write(successResult.toString());
        } else {
            request.getRequestDispatcher("/employeelogin.jsp").forward(request, response);
        }}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}