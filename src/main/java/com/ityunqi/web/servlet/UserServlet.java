package com.ityunqi.web.servlet;


import com.alibaba.fastjson.JSON;
import com.ityunqi.pojo.Result;
import com.ityunqi.pojo.User;
import com.ityunqi.service.UserService;
import com.ityunqi.service.impl.UserServiceImpl;
import com.ityunqi.util.Email;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username);
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
            int userid = userService.selectUserid(username);

            Cookie cookie = new Cookie("userid", String.valueOf(userid));
            cookie.setPath("/");
            resp.addCookie(cookie);

            jsonString = JSON.toJSONString(Result.success());
        }
        System.out.println(jsonString);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String phone = req.getParameter("phone");
        System.out.println("前端发过来的手机号:"+phone);
        
        //用来判断用户名是否已经存在

        String jsonString = null;
        if (phone.length()!=11) {
            //这个好像API就能返回各种错误信息
            jsonString = JSON.toJSONString(Result.error("手机号格式错误"));
        }else {
            //userService.register(username,password);

            //把数据存储到session中
            session.setAttribute("phone",phone);

            //1. 获取前端传来的手机号
            //前面获取了，就是phone

            //2. 生成随机验证码
            String code = generateRandomString(6);
            System.out.println("===============");
            System.out.println("进入了发送验证码的逻辑，随机生成的验证码为:"+code);
            //3. 调用接口发短信
            Email email = new Email();
            //这个方法好像能自动返回报错数据
            email.sendSms(phone,code);
            System.out.println("短信发送成功");

            //4. 把验证码保存到Session
            session.setAttribute("code",code);

            jsonString = JSON.toJSONString(Result.success());
        }

        System.out.println("响应的json数据:"+jsonString);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);

    }

    public static String generateRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }


    public void getSms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Sms : Short message service

        //获取用户输入的验证码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userCode = req.getParameter("verification");
        System.out.println(userCode);

        //从Session中获取验证码
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("code");
        String phone = (String) session.getAttribute("phone");

        System.out.println("==========");
        System.out.println("正确验证码为:"+code);
        System.out.println("用户输入的验证码为:"+userCode);
        System.out.println("用户输入的用户名为:"+username);
        System.out.println("用户输入的密码为:"+password);
        System.out.println("用户输入的手机号为:"+phone);


        //进行验证码的比对
        //判断是否比对成功
        String jsonString = null;
        if(code.equals(userCode)){
            userService.register(username,password,phone);
            System.out.println("增加方法执行成功");
            jsonString = JSON.toJSONString(Result.success());
        } else if (code==null) {
            System.out.println("你没在session中获取到验证码");
            jsonString = JSON.toJSONString(Result.error("你没在session中获取到验证码"));
        }else {
            System.out.println("验证码错误");
            jsonString = JSON.toJSONString(Result.error("验证码错误"));
        }
        //给前端响应信息

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);


    }



}
