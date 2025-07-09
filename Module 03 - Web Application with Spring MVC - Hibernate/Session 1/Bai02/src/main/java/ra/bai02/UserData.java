package ra.bai02;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userData", value = "/user-data")
public class UserData extends HttpServlet {
    private int id;
    private String name;
    private String email;
    private int age;


    public void init() {
        id = 1;
        name = "Huấn";
        email = "huanrose@gmail.com";
        age = 18;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h5> ID : " + id + "</h5>");
        out.println("<h5> Name : " + name + "</h5>");
        out.println("<h5> Email : " + email + "</h5>");
        out.println("<h5> Age : " + age + "</h5>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}