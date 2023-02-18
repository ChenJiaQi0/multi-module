package top.chen.book.dao;

import org.junit.jupiter.api.Test;
import top.chen.book.dao.impl.BookDaoImpl;

public class BookDaoTest {
    private BookDao dao = new BookDaoImpl();
    @Test
    public void FindBooks(){
        System.out.println(dao.findBooks().toString());
    }
}
