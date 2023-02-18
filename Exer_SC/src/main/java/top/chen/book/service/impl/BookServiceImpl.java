package top.chen.book.service.impl;

import top.chen.book.dao.BookDao;
import top.chen.book.dao.impl.BookDaoImpl;
import top.chen.book.entity.Book;
import top.chen.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> findAllBooks() {
        return bookDao.findBooks();
    }
}
