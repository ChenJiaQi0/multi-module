package top.chen.book.service;

import org.junit.jupiter.api.Test;
import top.chen.book.entity.User;
import top.chen.book.service.impl.UserServiceImpl;

public class UserServiceTest {
    private UserService service = new UserServiceImpl();
    @Test
    public void signIn(){
        User user = service.signIn("chen@qq.com", "111");
        System.out.println(user);
    }
}
