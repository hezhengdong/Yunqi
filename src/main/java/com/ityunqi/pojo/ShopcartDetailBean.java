package com.ityunqi.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
//这个实体类用来接收添加购物车时前端传来的json数据
public class ShopcartDetailBean {
    private Integer milkteaid;
    private Integer count;


}
