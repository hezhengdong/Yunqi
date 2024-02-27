package com.ityunqi.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AddShopcartBean {
    private Integer userId;
    private Integer milkteaId;
    private Integer milkteaCount;

}
