package com.ityunqi.web.servlet;

import com.alibaba.fastjson.JSON;
import com.ityunqi.pojo.Order.OrderBean;
import com.ityunqi.pojo.Result;
import com.ityunqi.service.OrderService;
import com.ityunqi.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order/*")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();


    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<OrderBean> orderBeans = orderService.selectAll();

        String jsonString = JSON.toJSONString(Result.success(orderBeans));
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

}
