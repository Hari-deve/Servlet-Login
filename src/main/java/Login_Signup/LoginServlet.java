package Login_Signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginEntry")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (LoginWelcomePage.userName == null) {
            resp.setContentType("text/html");
            resp.sendRedirect("LoginWebPage.html");
        }else {
            resp.sendRedirect("loggedProfile");
        }
    }
}
