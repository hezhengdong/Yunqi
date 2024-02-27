package com.ityunqi.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Milktea {
    private Integer id;
    private String milkteaname;
    private String introduce;
    private Integer kindid;
    private Integer price;
    private Integer count;
    private Integer salenumber;

}
