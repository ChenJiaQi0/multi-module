package top.chen.book.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.chen.book.dao.BookDao;
import top.chen.book.entity.Book;
import top.chen.book.util.JdbcUtil;

import java.util.List;
import java.util.Map;

public class BookDaoImpl implements BookDao {
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public List<Book> findBooks() {
        String sql = "select * from t_book";
        return template.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }
}
