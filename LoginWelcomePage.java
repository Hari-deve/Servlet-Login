package Login_Signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/loginWelcome")
public class LoginWelcomePage extends HttpServlet {
    static String userName;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String name= (String) session.getAttribute("loginName");
        PrintWriter out=resp.getWriter();
        out.println("Welcome "+name+" You have logged in Successfully");
    }
}
