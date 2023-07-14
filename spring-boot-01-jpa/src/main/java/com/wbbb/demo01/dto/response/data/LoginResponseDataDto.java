package com.wbbb.demo01.dto.response.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDataDto {
    private String token;
    private BigInteger userId;
}
