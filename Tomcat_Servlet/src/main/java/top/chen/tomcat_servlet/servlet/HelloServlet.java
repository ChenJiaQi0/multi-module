package top.chen.tomcat_servlet.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String str = "<h1>这是一个丰富的HTML界面</h1>\n" +
                "    <form id=\"loginForm\" action=\"/loginServlet\" method=\"post\" accept-charset=\"utf-8\">\n" +
                "        <input name=\"username\" type=\"text\" placeholder=\"请输入账号\" autocomplete=\"off\"></br>\n" +
                "        <input name=\"password\" type=\"text\" placeholder=\"请输入密码\" autocomplete=\"off\"></br>\n" +
                "        <div class=\"verify\">\n" +
                "            <input name=\"check\" type=\"text\" placeholder=\"请输入验证码\" autocomplete=\"off\">\n" +
                "            <span><img src=\"check-code\" alt=\"\" onclick=\"changeCheckCode(this)\"></span>\n" +
                "            <script type=\"text/javascript\">\n" +
                "                function changeCheckCode(img) {\n" +
                "                    img.src=\"check-code?\"+new Date().getTime();\n" +
                "                }\n" +
                "            </script>\n" +
                "        </div>\n" +
                "        <button type=\"button\" id=\"btn_sub\">登录</button>\n" +
                "    </form>";

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(str);
        out.println("");
        out.println("<img src='./images/1.jpg'/>");
        out.println("</body></html>");


    }
}