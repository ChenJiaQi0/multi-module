package top.chen.book.service.impl;

import top.chen.book.dao.UserDao;
import top.chen.book.dao.impl.UserDaoImpl;
import top.chen.book.entity.User;
import top.chen.book.service.UserService;
import top.chen.book.util.Md5Util;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User signIn(String account, String password) {
        String Md5Password = Md5Util.crypt(password);
        User user = User.builder()
                .account(account)
                .password(Md5Password)
                .build();
        return userDao.findUser(user);
    }
}
