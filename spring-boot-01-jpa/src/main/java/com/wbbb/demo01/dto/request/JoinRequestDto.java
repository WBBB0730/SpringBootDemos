package com.wbbb.demo01.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequestDto {
    private String email;
    private String username;
    private String password;
}
