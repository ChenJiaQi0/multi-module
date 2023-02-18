package top.chen.book.controller;

import top.chen.book.entity.User;
import top.chen.book.service.UserService;
import top.chen.book.service.impl.UserServiceImpl;
import top.chen.book.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String account = req.getParameter("account");
        String password = Md5Util.crypt(req.getParameter("password"));
        User user = User.builder()
                .account(account)
                .password(password)
                .nickname(nickname).build();
        int row = userService.addUser(user);
        if (row>0){
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('注册成功，请登录!');location.href='/';</script>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
