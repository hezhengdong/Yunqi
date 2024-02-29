package com.ityunqi.service.impl;

import com.ityunqi.mapper.ShopcartMapper;
import com.ityunqi.pojo.*;
import com.ityunqi.service.C.ShopcartService;
import com.ityunqi.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ShopcartServiceImpl implements ShopcartService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<ShopcartBean> selectAll(int userid) {

        SqlSession sqlSession = factory.openSession();

        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);

        List<ShopcartBean> shopcarts = mapper.selectAll(userid);

        sqlSession.close();
        return shopcarts;
    }

    @Override
    public void add(ShopcartDetail shopcartDetail) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        mapper.add(shopcartDetail);

        sqlSession.commit();
        
        sqlSession.close();
    }

    @Override
    public void update(int milkteaid, int count, int userid) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        mapper.update(milkteaid, count, userid);
        sqlSession.commit();
        
        sqlSession.close();
    }

    @Override
    public void delete(int milkteaid, int userid) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        mapper.delete(milkteaid, userid);
        sqlSession.commit();
        
        sqlSession.close();
    }

    @Override
    public int[] selectids(int userid) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        int[] ids = mapper.selectIds(userid);
        
        sqlSession.close();

        return ids;
    }

    @Override
    public void updateAdd(int milkteaid, int count, int userid) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        mapper.updateAdd(milkteaid, count, userid);
        sqlSession.commit();
        
        sqlSession.close();
    }

    @Override
    public List<ShopcartDetailBean2> selectAllBysd(int userid) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        List<ShopcartDetailBean2> shopcartDetailBean2s = mapper.selectAllBysd(userid);
        
        sqlSession.close();

        return shopcartDetailBean2s;
    }

    @Override
    public void deleteByUserid(int userid) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        mapper.deleteByUserid(userid);
        sqlSession.commit();
        
        sqlSession.close();
    }

    @Override
    public void insertOrder(Order order) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        mapper.insertOrder(order);
        sqlSession.commit();
        
        sqlSession.close();
    }

    @Override
    public void insertOrderDetail(OrderDetail orderDetail) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        mapper.insertOrderDetail(orderDetail);
        sqlSession.commit();
        
        sqlSession.close();
    }

    @Override
    public int getOrderid() {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        int orderid = mapper.getOrderid();
        
        sqlSession.close();
        return orderid;
    }

    @Override
    public void updateBymt(int salenumber, int id) {
        
        SqlSession sqlSession = factory.openSession();
        
        ShopcartMapper mapper = sqlSession.getMapper(ShopcartMapper.class);
        
        mapper.updateBymt(salenumber,id);
        sqlSession.commit();
        
        sqlSession.close();
    }

}
