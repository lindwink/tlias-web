package com.itheima;

import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void genJwt(){
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"itheima") //签名算法
                .setClaims(claims) //自定义内容
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))  //有效期
                .compact();
        System.out.println(jwt);

    }

    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5MTQ4NDk4Nn0.YJC4KmJeQxL-uZki8cYfFAFSBXfg1J7RRtiBw48zQqM")
                .getBody();
        System.out.println(claims);
    }

}
