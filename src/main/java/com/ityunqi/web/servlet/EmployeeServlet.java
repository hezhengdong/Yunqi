package com.ityunqi.web.servlet;

import com.alibaba.fastjson.JSON;
import com.ityunqi.pojo.Employee;
import com.ityunqi.pojo.Result;
import com.ityunqi.service.EmployeeService;
import com.ityunqi.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/*")
public class EmployeeServlet extends BaseServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        String accesskey = req.getParameter("accesskey");
        Employee employee = employeeService.login(number);

        System.out.println(number);
        System.out.println(accesskey);


        String jsonString = null;

        if (number.length()==0){
            jsonString = JSON.toJSONString(Result.error("员工号不能为空"));
        } else if (employee==null) {
            jsonString = JSON.toJSONString(Result.error("员工号不存在"));
        } else if (accesskey.length()==0) {
            jsonString = JSON.toJSONString(Result.error("密码不能为空"));
        } else if (!employee.getAccesskey().equals(accesskey)) {
            jsonString = JSON.toJSONString(Result.error("密码输入错误"));
        } else {
            jsonString = JSON.toJSONString(Result.success());
        }
        System.out.println(jsonString);

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

}
