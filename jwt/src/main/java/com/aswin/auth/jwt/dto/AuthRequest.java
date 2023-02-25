package com.aswin.auth.jwt.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AuthRequest {
    String userName;
    String password;
}
