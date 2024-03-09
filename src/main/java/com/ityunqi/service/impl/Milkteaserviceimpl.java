package com.ityunqi.service.impl;

import com.ityunqi.mapper.MilkteaMapper;
import com.ityunqi.pojo.Milktea;
import com.ityunqi.service.Milkteaservice;
import com.ityunqi.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Milkteaserviceimpl implements Milkteaservice {

    SqlSessionFactory sessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Milktea> selectall() {
        SqlSession sqlSession = sessionFactory.openSession();
        MilkteaMapper mapper = sqlSession.getMapper(MilkteaMapper.class);
        List<Milktea> milkteas = mapper.selectall();
        sqlSession.close();
        return milkteas;
    }



    @Override
    public void add(Milktea milktea) {
        SqlSession sqlSession = sessionFactory.openSession();
        MilkteaMapper mapper = sqlSession.getMapper(MilkteaMapper.class);
        mapper.add(milktea);
        sqlSession.commit();
        sqlSession.close();


    }

    @Override
    public void deletebyid(int id) {
        SqlSession sqlSession = sessionFactory.openSession();
        MilkteaMapper mapper = sqlSession.getMapper(MilkteaMapper.class);
        mapper.deletebyid(id);
        sqlSession.commit();
        sqlSession.close();



    }

    @Override
    public void update(Milktea milktea) {
        SqlSession sqlSession = sessionFactory.openSession();
        MilkteaMapper mapper = sqlSession.getMapper(MilkteaMapper.class);
        mapper.update(milktea);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public List<Milktea> kindidselect(int kindid) {
        SqlSession sqlSession = sessionFactory.openSession();
        MilkteaMapper mapper = sqlSession.getMapper(MilkteaMapper.class);
        List<Milktea> milkteas = mapper.kindidselect(kindid);
        sqlSession.commit();
        sqlSession.close();
        return milkteas;
    }



    @Override
    public List<Milktea> salenumberselect() {
        SqlSession sqlSession = sessionFactory.openSession();
        MilkteaMapper mapper = sqlSession.getMapper(MilkteaMapper.class);
        List<Milktea> milkteas = mapper.salenumberselect();
        sqlSession.commit();
        sqlSession.close();
        return milkteas;
    }

    @Override
    public List<Milktea> selectall2() {
        SqlSession sqlSession = sessionFactory.openSession();
        MilkteaMapper mapper = sqlSession.getMapper(MilkteaMapper.class);
        List<Milktea> milkteas = mapper.selectall2();
        sqlSession.close();
        return milkteas;

    }


}
