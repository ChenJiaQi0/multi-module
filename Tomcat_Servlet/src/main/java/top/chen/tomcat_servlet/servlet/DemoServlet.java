package top.chen.tomcat_servlet.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/json")
public class DemoServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] s = {"a","b","c"};
        String str = "{";
        for (int i = 0; i < s.length; i++) {
            if (i==s.length-1){
                str += '"' + s[i] + '"' + " :" + i + "}";
            }else {
                str += '"' + s[i] + '"' + " :" + i + ",";
            }

        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(str);

    }

    public void destroy() {
        System.out.println("Servlet销毁");
    }
}