package top.chen.book.dao;

import org.junit.jupiter.api.Test;
import top.chen.book.dao.impl.UserDaoImpl;
import top.chen.book.entity.User;

import java.util.Date;

public class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();
////    @Test
////    public void findUser(){
////        User userdto = User.builder().account("chen@qq.com").password("698d51a19d8a121ce581499d7b701668").build();
////        User user = userDao.findUser(userdto);
////        System.out.println(user);
//    }

    @Test
    public void AddUser(){
        User user = new User(null,"chen@qq.com","698d51a19d8a121ce581499d7b701668","chen","https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/me.jpg","江苏常州",null);
        int row = userDao.addUser(user);
        System.out.println(row);
    }
}
