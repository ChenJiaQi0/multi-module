package top.chen.book.service;

import top.chen.book.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
}
