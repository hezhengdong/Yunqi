package com.ityunqi.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
//查询购物车所有时，使用的实体类
public class ShopcartBean {
    private Integer id;
    private String milkteaname;
    //购物车中奶茶的数量
    private Integer count;
    //该奶茶的单价
    private Integer price;


}
