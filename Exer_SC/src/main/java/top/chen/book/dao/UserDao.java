package top.chen.book.dao;

import top.chen.book.entity.User;

public interface UserDao {
    /**
     * 新增一个用户
     * @param user
     * @return 受影响的行数
     */
    int addUser(User user);

    /**
     * 根据查询对象查询用户是否存在
     * @param userDto
     * @return  查询结果
     */
    User findUser(User userDto);
}
