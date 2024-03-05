package com.ityunqi.service.B;

import com.ityunqi.pojo.Milktea;

import java.util.List;

public interface Milkteaservice {
    public List<Milktea> selectall();
    void add(Milktea milktea);
    void deletebyid(int id);
    void update(Milktea milktea);

    List<Milktea> kindidselect(int kindid);
    List<Milktea> salenumberselect();
}
