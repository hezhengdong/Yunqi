package com.ityunqi.service.B;

import com.ityunqi.pojo.Milktea;

import java.util.List;

public interface Milkteaservice {
    public List<Milktea> selectall();
    void add(Milktea milktea);
    int deletebyid(int id);
    int update(Milktea milktea);

    List<Milktea> kindidselect(int kindid);
    List<Milktea> salenumberselect();
}
