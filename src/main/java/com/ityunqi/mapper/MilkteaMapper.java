package com.ityunqi.mapper;

import com.ityunqi.pojo.milktea.Milktea;
import com.ityunqi.pojo.milktea.Milktea2;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MilkteaMapper {
@Select("select * from dbyunqi.milktea")
    public List<Milktea> selectall();
    public List<Milktea2>  selectall2();

    @Insert("insert into dbyunqi.milktea values(null,#{milkteaname},#{introduce},#{kindid},#{price},#{count},#{salenumber},#{image}) ")
    void add(Milktea milktea);

    @Delete("delete from dbyunqi.milktea where id=#{id}")
    void deletebyid(int id);

    @Update("update dbyunqi.milktea set id=#{id},milkteaname=#{milkteaname},introduce=#{introduce},kindid=#{kindid},price=#{price},count=#{count},salenumber=#{salenumber} where id=#{id}")
    void update(Milktea milktea);


    public List<Milktea> kindidselect(int kindid);

    public List<Milktea> salenumberselect();

}
