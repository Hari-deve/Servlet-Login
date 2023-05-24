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


@WebServlet("/signup")
public class SignupCheckServlet extends HttpServlet {


    static ArrayList<String> storeMail=new ArrayList<String>();
    static ArrayList<String> storeUserName=new ArrayList<String>();
    public void checkValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String alreadyUsedMail=null;
        String alreadyUsedName=null;

        String name=req.getParameter("username");
        String mail=req.getParameter("mail");
        String setPassword=req.getParameter("password");
        String confirmPassword=req.getParameter("confirm-password");
        PrintWriter out=resp.getWriter();


        HttpSession session=req.getSession(true);
        session.setAttribute("signupName", name);
        session.setAttribute("mail",mail);
        session.setAttribute("password",setPassword);


        for (int i = 0; i< storeMail.size()||i< storeUserName.size(); i++){
            if (mail.equals(storeMail.get(i))&&i<storeMail.size()){
                alreadyUsedMail=storeMail.get(i);
            } else if (name.equals(storeUserName.get(i))&&i< storeUserName.size()) {
                alreadyUsedName=storeUserName.get(i);
            }
        }

        if (setPassword.equals(name+"pass") && setPassword.equals(confirmPassword)) {
            if (name.equals(alreadyUsedName)){
                resp.sendRedirect("usedUserName");
            } else if (mail.equals(alreadyUsedMail)) {
                resp.sendRedirect("usedMail");
            }else {
                resp.sendRedirect("signupWelcome");
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