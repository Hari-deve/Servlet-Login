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


@WebServlet("/signupWelcome")
public class SignupWelcomePage extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        String name= (String) session.getAttribute("signupName");
        String mail= (String) session.getAttribute("mail");
        SignupCheckServlet.storeMail.add(mail);
        SignupCheckServlet.storeUserName.add(name);


        PrintWriter out=resp.getWriter();
        out.println("Welcome "+name+" Account has been Created Successfully");
    }
}
