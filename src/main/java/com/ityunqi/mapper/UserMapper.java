package com.ityunqi.mapper;

import com.ityunqi.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User login(String username);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);


    @Insert("insert into user values(null,#{username},#{password},#{phone})")
    void register(@Param("username") String username, @Param("password") String password, @Param("phone") String phone);

}
