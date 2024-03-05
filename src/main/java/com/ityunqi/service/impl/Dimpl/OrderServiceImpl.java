package com.ityunqi.service.impl.Dimpl;

import com.ityunqi.mapper.OrderMapper;
import com.ityunqi.mapper.ShopcartMapper;
import com.ityunqi.pojo.OrderBean;
import com.ityunqi.pojo.ShopcartBean;
import com.ityunqi.service.D.OrderService;
import com.ityunqi.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<OrderBean> selectAll() {
        SqlSession sqlSession = factory.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<OrderBean> orderBeans = mapper.selectAll();

        sqlSession.close();

        return orderBeans;
    }

}
