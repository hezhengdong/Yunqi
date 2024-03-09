package com.ityunqi.service;

import com.ityunqi.pojo.*;

import java.util.List;

public interface ShopcartService {

    //======================只跟购物车相关的===========================
    List<ShopcartBean> selectAll(int userid);

    AddShopcartBean selectByid(int id);

    void update(int milkteaid, int count, int userid);

    void delete(int milkteaid, int userid);

    int[] selectids(int userid);

    void add(ShopcartDetail shopcartDetail);

    void updateAdd(int milkteaid, int count, int userid);

    //======================跟订单相关的===========================

    List<ShopcartDetailBean2> selectAllBysd(int userid);

    void deleteByUserid(int userid);

    void insertOrder(Order order);

    void insertOrderDetail(OrderDetail orderDetail);

    int getOrderid();

    //======================跟奶茶相关的===========================

    void updateBymt(int salenumber, int id);

}
