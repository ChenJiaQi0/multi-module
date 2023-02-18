package top.chen.book.service;

import top.chen.book.entity.User;

public interface UserService {
    /**
     *用户登录
     * @param account
     * @param password
     * @return登录用户信息
     */
    User signIn(String account, String password);

    User findUser(String account);

    User findUser(String account,String password);

    int addUser(User user);
}
