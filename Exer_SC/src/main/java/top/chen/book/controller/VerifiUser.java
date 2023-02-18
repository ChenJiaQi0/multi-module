package top.chen.book.controller;

import top.chen.book.entity.User;
import top.chen.book.service.UserService;
import top.chen.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verifi")
public class VerifiUser extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = String.valueOf(req.getParameter("account"));
        User user = userService.findUser(account);
        if (user!=null){
            resp.getWriter().write("false");
        }else{
            resp.getWriter().write("true");
        }

    }
}
