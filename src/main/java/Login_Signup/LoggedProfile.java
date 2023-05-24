package Login_Signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loggedProfile")
public class LoggedProfile extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out =resp.getWriter();
        out.println("The profile "+LoginCheckServlet.userName+" was already logged in");

        out.println("<br><form action='loggingOut'>");
        out.println("<input type='submit' value='Logout'>");
        out.println("</form><br>");
    }
}
