package com.wbbb.demo01.util;

import com.wbbb.demo01.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * Token生成、校验、解析工具
 */
public class TokenUtil {
    private static final String key = "YOUR_SECRET_KEY";

    /**
     * 根据账户信息生成Token
     */
    public static String generateToken(User user) {
        return Jwts.builder()
                .claim("userId", user.getUserId())
                .signWith(Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    /**
     * 验证并解析Token
     */
    public static BigInteger parseToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .get("userId", BigInteger.class);
        } catch (JwtException e) {
            return null;
        }
    }
}
