package com.ityunqi.pojo.milktea;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Milktea2 {
    private Integer id;
    private String milkteaname;
    private String introduce;
    private String kindname;
    private Integer price;
    private Integer count;
    private Integer salenumber;
    private String image;

}
