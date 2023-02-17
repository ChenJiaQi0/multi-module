package top.chen.http_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//判断访问源
@WebServlet("/demo1")
public class demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String agent = req.getHeader("User-Agent");
        if (agent.contains("Windows")){
            req.getRequestDispatcher("client.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("phone.jsp").forward(req,resp);
        }
    }
}
