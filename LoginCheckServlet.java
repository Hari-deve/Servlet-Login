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


@WebServlet("/login")
public class LoginCheckServlet extends HttpServlet {
    static ArrayList loginUserName=new ArrayList();
    public void checkValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login-name");
        String password = req.getParameter("login-password");
        loginUserName.addAll(SignupWelcomePage.storeUserName);

        HttpSession session = req.getSession();
        session.setAttribute("loginName", name);

        if (password.equals(name + "pass")) {
            for (int i = 0; i < loginUserName.size(); i++) {
                if (name.equals(loginUserName.get(i))) {
                    LoginWelcomePage.userName=name;
                    try{
                    resp.sendRedirect("loginWelcome");
                    }catch (IllegalStateException e){}
                }
            }
            try {
                resp.sendRedirect("loginNoUserName");
            }catch (IllegalStateException e){}


        } else {
            resp.sendRedirect("loginError");
        }
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkValues(req, resp);
    }

}