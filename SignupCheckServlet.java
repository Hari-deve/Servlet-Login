package Login_Signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/signup")
public class SignupCheckServlet extends HttpServlet {
    public void checkValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String mail=req.getParameter("mail");
        String setPassword=req.getParameter("password");
        String confirmPassword=req.getParameter("confirm-password");
        PrintWriter out=resp.getWriter();


        HttpSession session=req.getSession();
        session.setAttribute("signupName", name);
        session.setAttribute("mail",mail);
        session.setAttribute("password",setPassword);

        if (setPassword.equals(name+"pass")&&setPassword.equals(confirmPassword)) {
            for (int i = 0; i< SignupWelcomePage.storeMail.size(); i++){
                if (mail.equals(SignupWelcomePage.storeMail.get(i))){
                    resp.sendRedirect("usedMail");
                }
            }
            try {
                for (int i = 0; i < SignupWelcomePage.storeUserName.size(); i++) {
                    if (name.equals(SignupWelcomePage.storeUserName.get(i))) {
                        resp.sendRedirect("usedUserName");
                    }
                }
            }catch (IllegalStateException e){}


            try {
                resp.sendRedirect("signupWelcome");
            }catch (IllegalStateException e){
                out.println("Mail has been used already");
            }
        }else {
            resp.sendRedirect("signupError");
        }

    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkValues(req, resp);
    }

}