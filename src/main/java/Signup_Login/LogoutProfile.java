package Signup_Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loggingOut")
public class LogoutProfile extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loggingOutUser=LoginCheckServlet.userName;
        LoginCheckServlet.userName=null;
        PrintWriter out =resp.getWriter();
        out.println("The profile "+loggingOutUser+" was logged out successfully");
    }
}
