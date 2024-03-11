package com.ityunqi.mapper;

import com.ityunqi.pojo.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {

    @Select("select * from employee where number = #{number}")
    Employee login(String number);

}

