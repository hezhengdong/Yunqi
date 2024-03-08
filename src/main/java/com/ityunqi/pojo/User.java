package com.ityunqi.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private String phone;
}
