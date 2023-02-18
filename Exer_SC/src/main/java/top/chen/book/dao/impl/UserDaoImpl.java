package top.chen.book.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.chen.book.dao.UserDao;
import top.chen.book.entity.User;
import top.chen.book.util.JdbcUtil;


/**
 * 用户Dao实现类
 */
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public int addUser(User user) {
        String sql = "insert into t_user(account,password,nickname,avatar,address) values(?,?,?,?,?)";
        return template.update(sql, user.getAccount(), user.getPassword(), user.getNickname(), user.getAvatar(), user.getAddress());
    }

    @Override
    public User findUser(String account) {
        String sql = "select * from t_user where account=?";
        try {
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),account);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User findUser(String account, String password) {
        String sql = "select * from t_user where account=? and password=?";
        try {
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),account,password);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}
