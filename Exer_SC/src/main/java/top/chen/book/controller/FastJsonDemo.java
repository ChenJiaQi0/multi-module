package top.chen.book.controller;

import com.alibaba.fastjson.JSON;
import top.chen.book.entity.User;

public class FastJsonDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setNickname("chen");
        user.setPassword("123");
        String json = JSON.toJSONString(user);
        System.out.println(json);

        User u = JSON.parseObject(json, User.class);
        System.out.println(u);
    }
}
