package com.ityunqi.web.servlet.Aservlet;


import com.alibaba.fastjson.JSON;
import com.ityunqi.pojo.Result;
import com.ityunqi.pojo.User;
import com.ityunqi.service.A.UserService;
import com.ityunqi.service.impl.Aimpl.UserServiceImpl;
import com.ityunqi.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User user = userService.login(username);
        System.out.println("user");
        String jsonString = null;

        if (username.length()==0){
            jsonString = JSON.toJSONString(Result.error("用户名不能为空"));
        } else if (user==null) {
            jsonString = JSON.toJSONString(Result.error("用户名不存在"));
        } else if (password.length()==0) {
            jsonString = JSON.toJSONString(Result.error("密码不能为空"));
        } else if (!user.getPassword().equals(password)) {
            jsonString = JSON.toJSONString(Result.error("密码输入错误"));
        } else {
            jsonString = JSON.toJSONString(Result.success());
        }
        System.out.println(jsonString);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

}
