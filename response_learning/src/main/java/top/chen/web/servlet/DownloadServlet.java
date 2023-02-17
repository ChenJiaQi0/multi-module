package top.chen.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始下载");
        //1.获取请求参数
        String filename = String.valueOf(req.getParameter("filename"));

        //2.使用字节流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = realPath = servletContext.getRealPath("/res/" + filename);;

        FileInputStream fis = new FileInputStream(realPath);
        //3.响应头
        String mimeType = servletContext.getMimeType(filename);
        System.out.println(mimeType);
        resp.setHeader("content-type", mimeType);
        resp.setHeader("content-disposition", "attachment;filename="+filename);
        req.getRequestDispatcher("show.html").forward(req, resp);
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len;
        while ((len = fis.read(buff)) != -1){
            sos.write(buff, 0, len);
        }
        fis.close();
        sos.close();

    }
}
