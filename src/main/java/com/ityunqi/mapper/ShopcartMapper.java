package com.ityunqi.mapper;

import com.ityunqi.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShopcartMapper {


    //设置一个userid的cookie方法（用户登录时，根据用户名查找出userid，并将userid设置为cookie）

    //========================所有操作购物车的mapper方法======================

    /**
     * 1. 查询所有
     * @param userid
     * @return
     */
    List<ShopcartBean> selectAll(int userid);

    /**
     * 2. 更改购物车明细数据
     * @param milkteaid
     * @param count
     * @param userid
     */
    @Update("update shopcart_detail set count = #{count} where milkteaid = #{milkteaid} and userid = #{userid}")
    void update(@Param("milkteaid") int milkteaid,@Param("count") int count,@Param("userid") int userid);

    /**
     * 3. 删除购物车明细数据
     * @param milkteaid
     * @param userid
     */
    @Delete("delete from shopcart_detail where milkteaid = #{milkteaid} and userid = #{userid}")
    void delete(@Param("milkteaid") int milkteaid,@Param("userid") int userid);

    /**
     * 4. 增加购物车明细数据
     * @param shopcartDetail
     */
    @Insert("insert into shopcart_detail values (#{userid},#{milkteaid},#{count})")
    void add(ShopcartDetail shopcartDetail);

    /**
     * 5. 查询某个用户的购物车内所有商品id（用来判断是增加还是修改）
     * @param userid
     * @return
     */
    @Select("select milkteaid from shopcart_detail where userid = #{userid}")
    int[] selectIds(int userid);

    /**
     * 6. 修改购物车明细数据（针对于增加，执行的对count的修改是递增）
     * @param milkteaid
     * @param count
     * @param userid
     */
    @Update("update shopcart_detail set count = count + #{count} where milkteaid = #{milkteaid} and userid = #{userid}")
    void updateAdd(@Param("milkteaid") int milkteaid,@Param("count") int count,@Param("userid") int userid);


    //查询回显
    AddShopcartBean selectByid(int milkteaid);



    /*========================所有和订单相关联的购物车mapper方法======================
                  这里要实现的目标
                    1. 转移购物车数据到两个订单数据库
                    2. 要计算出总金额
                    3. 删除已完成支付的购物车
                  具体逻辑
                    一. 返回总金额（每次刷新页面执行）
                    1. 查询该用户所有购物车商品信息
                    2. 计算订单总金额
                    二. 创建订单 转移数据（结算并成功支付金额后执行）
                    1. 查询该用户所有购物车商品信息
                    2. 计算订单总金额
                    3. 创建订单
                    4. 将购物车中的商品信息转移到订单详情表中
                    5. 删除购物车中该用户的商品信息
     */

    /**
     * 1. 根据用户id查询购物车
     * @param userid
     * @return
     */
    List<ShopcartDetailBean2> selectAllBysd(int userid);

    /**
     * 2. 根据用户id删除购物车
     * @param userid
     */
    @Delete("Delete from shopcart_detail where userid = #{userid}")
    void deleteByUserid(int userid);

    /**
     * 3. 增加订单数据库
     * @param order
     */
    @Insert("insert into `order` (userid,price,status) values (#{userid},#{price},#{status})")
    void insertOrder(Order order);

    /**
     * 4. 增加订单明细数据库
     * @param orderDetail
     */
    @Insert("insert into order_detail (orderid, milkteaid, count) values (#{orderid}, #{milkteaid}, #{count})")
    void insertOrderDetail(OrderDetail orderDetail);

    /**
     * 5. 获取订单号
     * @return
     */
    @Select("select last_insert_id()")//last_insert_id用来获取最新的自增id
    int getOrderid();


    //========================所有和奶茶数据库相关联的购物车mapper方法======================

    /**
     * 结算购物车时修改奶茶销量
     * @param salenumber
     * @param id
     */
    @Update("update milktea set salenumber = salenumber + #{salenumber} where id = #{id};")
    void updateBymt(@Param("salenumber") int salenumber,@Param("id") int id);

    //=========================要有一个根据用户名查id的方法======================


    @Select("select id from user where username = #{username}")
    int selectUserid(String username);

}
