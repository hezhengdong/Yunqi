package com.ityunqi.service.A;

import com.ityunqi.pojo.User;

public interface UserService {

    User login(String username);

    void register(User user);

}
