package com.zhc.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    public static String createJwt(Map<String, Object> claims, long timeMill, String secretKey) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Long expMills = System.currentTimeMillis()+timeMill;
        Date exp = new Date(expMills);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .signWith(signatureAlgorithm, secretKey.getBytes(StandardCharsets.UTF_8))
                .setExpiration(exp);

        return builder.compact();

    }

    public static Claims parseJwt(String secretKey,String jwt) {
        Claims claims = Jwts.parser().setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(jwt).getBody();
        return claims;
    }

}
