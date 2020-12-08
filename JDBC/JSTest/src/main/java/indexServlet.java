import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("")
public class indexServlet extends HttpServlet {
    static int count = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
    String templete = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>首页</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<p id=\"contents\">:count:</p>\n" +
            "<script src=\"js/jquery-3.5.0.min.js\"></script>\n" +
            "<script src=\"js/index.js\"></script>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

        String res = templete.replace(":count:",String.valueOf(count));



        writer.write(res);
    }
}
