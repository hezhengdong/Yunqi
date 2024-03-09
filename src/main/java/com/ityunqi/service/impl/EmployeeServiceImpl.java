package com.ityunqi.service.impl;

import com.ityunqi.mapper.EmployeeMapper;
import com.ityunqi.pojo.Employee;
import com.ityunqi.service.EmployeeService;
import com.ityunqi.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmployeeServiceImpl implements EmployeeService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public Employee login(String number) {
        SqlSession sqlSession = factory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.login(number);

        sqlSession.close();
        return employee;
    }
}
