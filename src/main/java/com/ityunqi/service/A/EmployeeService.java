package com.ityunqi.service.A;

import com.ityunqi.mapper.EmployeeMapper;
import com.ityunqi.mapper.UserMapper;
import com.ityunqi.pojo.Employee;
import com.ityunqi.pojo.User;
import com.ityunqi.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmployeeService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public Employee login(String number, String accesskey) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.select(number, accesskey);
        sqlSession.close();
        return employee;
    }
}
