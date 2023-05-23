package Login_Signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/signupError")
public class SignupErrorPage extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session=req.getSession();
        String name=(String) session.getAttribute("signupName");
        PrintWriter out=resp.getWriter();
        out.println("Sorry "+name+ " Couldn't Create Account Check the inputs and Try Again");

    }
}


