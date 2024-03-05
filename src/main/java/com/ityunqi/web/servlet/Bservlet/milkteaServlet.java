package com.ityunqi.web.servlet.Bservlet;

import com.alibaba.fastjson.JSON;
import com.ityunqi.pojo.Milktea;
import com.ityunqi.pojo.Result;
import com.ityunqi.service.B.Milkteaservice;
import com.ityunqi.service.impl.Bimpl.Milkteaserviceimpl;
import com.ityunqi.web.servlet.BaseServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/milktea/*")

public class milkteaServlet extends BaseServlet {

    private Milkteaservice milkteaservice = new Milkteaserviceimpl();

    public void selectall(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Milktea> milkteas = milkteaservice.selectall();
        String jsonString = JSON.toJSONString(Result.success(milkteas));
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        BufferedReader bufferedReader = httpServletRequest.getReader();
        String params = bufferedReader.readLine();
        Milktea milktea = JSON.parseObject(params, Milktea.class);
        milkteaservice.add(milktea);
        Result result = Result.success(milktea);
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }

    public void deleteid(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String id = httpServletRequest.getParameter("id");
        milkteaservice.deletebyid(Integer.parseInt(id));
        Result result = Result.success();
        httpServletResponse.getWriter().write(JSON.toJSONString(result));

    }







    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        BufferedReader br = httpServletRequest.getReader();
        String params = br.readLine();
        String _id = httpServletRequest.getParameter("id");
        int id = Integer.parseInt(_id);
        Milktea milktea = JSON.parseObject(params, Milktea.class);
        Milktea milktea1 = new Milktea();

        milktea1.setId(id);

        milktea1.setIntroduce(milktea.getIntroduce());

        milktea1.setKindid(milktea.getKindid());

        milktea1.setPrice(milktea.getPrice());

        milktea1.setCount(milktea.getCount());
        milktea1.setImage(milktea.getImage());
        milktea1.setSalenumber(milktea.getSalenumber());
        milkteaservice.update(milktea1);
        String jsonString = JSON.toJSONString(Result.success(milktea1));
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(jsonString));
    }


    public void kindidselect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        BufferedReader br = httpServletRequest.getReader();
        String params = br.readLine();
        Milktea milktea = JSON.parseObject(params, Milktea.class);
        String _kindid = httpServletRequest.getParameter("kindid");

        int kindid = Integer.parseInt(_kindid);
        List<Milktea> milkteas = milkteaservice.kindidselect(kindid);
        String jsonString = JSON.toJSONString(Result.success(milkteas));
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(jsonString);



    }

    public void salenumberselect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        BufferedReader br = httpServletRequest.getReader();
        String params = br.readLine();
        Milktea milktea = JSON.parseObject(params, Milktea.class);
        List<Milktea> milkteas = milkteaservice.salenumberselect();
        httpServletResponse.setContentType("application/json;charset=utf-8");
        String jsonString = JSON.toJSONString(Result.success(milkteas));
        httpServletResponse.getWriter().write(jsonString);


    }


}