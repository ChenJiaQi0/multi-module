package top.chen.http_request;

import top.chen.http_request.Utils.Consts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//登录跳转
@WebServlet("/demo2")
public class demo2 extends HttpServlet implements Consts {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (USER_NAME.equals(username) && PASSWORD.equals(password)){
            resp.sendRedirect("success.jsp");
        }else {
            resp.sendRedirect("error.jsp");
        }
    }
}
