package servlet;

import exception.myexception;
import model.JSONResponse;
import util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        //业务解析请求数据，执行业务操作，获取业务操作返回数据
        JSONResponse json = new JSONResponse();


        try{
            Object data = process(req,resp);   //不成功这里会报错
            //业务操作成功，设置sucess = true及业务数据
            json.setSuccess(true);
            json.setData(data);
        }catch (Exception e) {
            //业务操作失败，设置sucess = false，code错误码，message信息
            //1、处理自定义异常（code，message） 2、其它异常
            //有我们自定义异常时处理自定义异常，没有时设置其他异常的状态码，并设置信息
            e.printStackTrace();
            String code = "unknown";
            String message = "未知错误";

            if (e instanceof myexception) {
                code = ((myexception) e).getCode();
                message = e.getMessage();
            }

            json.setMessage(message);
            json.setCode(code);
        }

        //将统一的数据对象，序列化为json字符串，返回给前端
        //序列化

        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(json));
        pw.flush();
        pw.close();

    }

    protected abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
