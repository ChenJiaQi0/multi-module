package top.chen.book.controller;

import top.chen.book.dao.BookDao;
import top.chen.book.dao.impl.BookDaoImpl;
import top.chen.book.entity.User;
import top.chen.book.service.BookService;
import top.chen.book.service.UserService;
import top.chen.book.service.impl.BookServiceImpl;
import top.chen.book.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        User user = service.signIn(account, password);
        if (user!=null){
            req.setAttribute("user",user);
            req.setAttribute("bookList",bookService.findAllBooks());
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('用户名或密码错误');location.href='/';</script>");
            writer.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
