package com.ityunqi.service.impl.Aimpl;

import com.ityunqi.mapper.EmployeeMapper;
import com.ityunqi.mapper.ShopcartMapper;
import com.ityunqi.pojo.Employee;
import com.ityunqi.pojo.ShopcartBean;
import com.ityunqi.service.A.EmployeeService;
import com.ityunqi.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

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
