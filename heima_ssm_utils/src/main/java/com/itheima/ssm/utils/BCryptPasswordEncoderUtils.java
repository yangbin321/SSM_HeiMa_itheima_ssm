package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Yangbin
 * @create 2020-05-11 21:17
 * @Description     自定义加密的类
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";
        String pwd = encodePassword(password);
        //$2a$10$MidZ3W44SSqgNaJDww1SDOTwSJGbkK7Lo1HjXcptOvWwMD4ZkpLmm
        //$2a$10$7N44wSGToAitfGJRW5ssiud2Vcg1NWBQsm0huGm7AOp4r0plHuas2
        System.out.println(pwd);

    }
}
