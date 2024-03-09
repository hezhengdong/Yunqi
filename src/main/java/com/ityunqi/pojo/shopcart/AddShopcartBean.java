package com.ityunqi.pojo.shopcart;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
//用来给前端响应增加购物车界面上的信息
public class AddShopcartBean {
    private Integer id;
    private String milkteaname;
    private String introduce;
    private Integer price;
    private String image;

}
