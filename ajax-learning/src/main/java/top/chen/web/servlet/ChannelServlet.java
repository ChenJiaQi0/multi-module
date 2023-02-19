package top.chen.web.servlet;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.chen.web.entity.Channel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/channel")
public class ChannelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String level = req.getParameter("level");
        String parent = req.getParameter("parent");
        List<Channel> list = new ArrayList<>();

        if ("1".equals(level)){
            list.add(new Channel("人工智能","ai"));
            list.add(new Channel("web开发","web"));
        }else if ("2".equals(level)){
            if ("ai".equals(parent)){
                list.add(new Channel("计算机深入学习","dl"));
                list.add(new Channel("计算机视觉","cv"));
            }else if("web".equals(parent)){
                list.add(new Channel("超文本标记语言","dl"));
                list.add(new Channel("联级样式表","css"));
                list.add(new Channel("JavaScript脚本语言","js"));
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(list);
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print(str);
        writer.close();
    }
}
