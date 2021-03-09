package filter;

import model.JSONResponse;
import model.User;
import util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class loginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       //ServletRequest是HttpServletRequest的父类，强制转型为HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //访问/jsp/...如果没有登录跳转到登录界面
        //访问/login，其他的前端资源，不校验session
        //其他的后端资源，校验session，没有登陆返回401，json字符串。通过doFilter
//        String scheme = req.getScheme();   //获取协议http
//        String host = req.getServerName();  //获取主机ip
//        int port = req.getServerPort();   //获取主机端口号
//        String contextPath = req.getContextPath();   //应用上下文路径

        String path = req.getServletPath();  //servlet路径


        if (path.startsWith("/js/") || path.startsWith("/static/") || path.startsWith("/view/") || path.equals("/login")) {
            chain.doFilter(request,response);
        }else {
            HttpSession session = req.getSession(false);

            if (session == null) {
                // 跳转或返回json
                unauthorized(req,resp);
            }else {
                User user = (User)session.getAttribute("user");
                if (user == null) {
                    //跳转或返回
                }else {
                    chain.doFilter(request,response);
                }
            }

        }

    }

    public static void unauthorized(HttpServletRequest req,HttpServletResponse resp){
        String scheme = req.getScheme();   //获取协议http
        String host = req.getServerName();  //获取主机ip
        int port = req.getServerPort();   //获取主机端口号
        String contextPath = req.getContextPath();   //应用上下文路径

        String path = req.getServletPath();  //servlet路径

        resp.setCharacterEncoding("UTF-8");

        if (path.startsWith("/jsp/")) {
            String basePath = scheme + "://" + host + ":" + port + contextPath;
            try {
                resp.sendRedirect(basePath + "/view/login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {  //后端敏感资源，状态码401，返回json
            resp.setContentType("application/json");
            resp.setStatus(401);
            JSONResponse json  = new JSONResponse();
            json.setCode("LOG000");
            json.setMessage("用户没有登录，不允许访问");
            PrintWriter pw = null;
            try {
                pw = resp.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert pw != null;
            pw.write(JSONUtil.serialize(json));
            pw.flush();
            pw.close();
        }


    }

    @Override
    public void destroy() {

    }
}
