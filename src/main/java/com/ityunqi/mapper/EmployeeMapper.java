package com.ityunqi.mapper;

import com.ityunqi.pojo.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {
    /**
     * 根据用户名和密码查询用户对象
     * @param number
     * @param accesskey
     * @return
     */
    @Select("select * from employee where number = #{number} and accesskey = #{accesskey}")
    Employee select(@Param("number") String number, @Param("password")  String accesskey);

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
    void add(Employee employee);
}

