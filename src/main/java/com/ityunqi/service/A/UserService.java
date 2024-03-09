package com.ityunqi.service.A;

import com.ityunqi.pojo.User;

public interface UserService {

    User login(String username);

    void register(String username, String password, String phone);

    //======================根据用户名查id===========================
    int selectUserid(String username);


}
