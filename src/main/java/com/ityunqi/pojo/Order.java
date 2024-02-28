package com.ityunqi.pojo;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Order {
    private Integer orderid;
    private Integer userid;
    private Integer price;
    private Integer status;

}
