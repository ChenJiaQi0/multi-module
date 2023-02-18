package top.chen.book.dao;

import top.chen.book.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> findBooks();
}
