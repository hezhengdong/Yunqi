package com.ityunqi.pojo.Order;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderDetail {
    private Integer orderid;
    private Integer milkteaid;
    private Integer count;

}
