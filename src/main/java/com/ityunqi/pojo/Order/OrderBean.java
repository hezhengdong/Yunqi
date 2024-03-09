package com.ityunqi.pojo.Order;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderBean {
    private Integer orderid;
    private String username;
    private String milkteaDetails;
    private Integer price;
}
