package com.ityunqi.service;

import com.ityunqi.pojo.milktea.Milktea;
import com.ityunqi.pojo.milktea.Milktea2;

import java.util.List;

public interface Milkteaservice {
    public List<Milktea> selectall();
    void add(Milktea milktea);
    void deletebyid(int id);
    void update(Milktea milktea);

    List<Milktea> kindidselect(int kindid);
    List<Milktea> salenumberselect();
    public List<Milktea2> selectall2();
}
