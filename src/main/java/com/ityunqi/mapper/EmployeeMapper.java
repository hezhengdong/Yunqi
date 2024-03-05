package com.ityunqi.mapper;

import com.ityunqi.pojo.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {

    @Select("select * from employee where number = #{number}")
    Employee login(String number);

    /**
     * 根据用户名查询用户对象
     * @param number
     * @return
     */
    @Select("select * from employee where number = #{number}")
    Employee selectByUsername(String number);

    /**
     * 添加用户
     * @param employee
     */
    @Insert("insert into employee values(null,#{number},#{accesskey})")
    void register(Employee employee);
}

