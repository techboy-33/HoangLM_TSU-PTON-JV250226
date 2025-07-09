package ra.bai01;

import java.io.*;
import java.time.LocalDateTime;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "timeServlet", value = "/time-servlet")
public class TimeServlet extends HttpServlet {
    private LocalDateTime time;

    public void init() {
        time = LocalDateTime.now();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Thời gian hiện tại:" + time + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}