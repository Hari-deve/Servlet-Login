package Login_Signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/usedMail")
public class SignupUsedMailError extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession(false);
        String mail= (String) session.getAttribute("mail");
        PrintWriter writer=resp.getWriter();
        writer.println(mail+" Mail has been used already");
    }
}
