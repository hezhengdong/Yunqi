package com.ityunqi.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
//调用servletAllBysd，用来封装集合
//这个实体类用来获取一个购物车中的奶茶id，奶茶数量，奶茶价格，奶茶销量这些属性
//  将数据从购物车转移到订单 或者对于其他需要这些属性的方法，调用起来很方便
public class ShopcartDetailBean2 {
    private Integer id;
    private Integer count;
    private Integer price;
    private Integer salenumber;
}
