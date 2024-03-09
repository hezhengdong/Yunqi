package com.ityunqi.service.impl;

import com.ityunqi.mapper.UserMapper;
import com.ityunqi.pojo.User;
import com.ityunqi.service.UserService;
import com.ityunqi.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public User login(String username) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.login(username);

        sqlSession.close();
        return user;
    }

    @Override
    public void register(String username, String password, String phone) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.register(username,password,phone);

        sqlSession.commit();

        sqlSession.close();
    }


    @Override
    public int selectUserid(String username) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int id = mapper.selectUserid(username);

        sqlSession.close();
        return id;
    }
}
