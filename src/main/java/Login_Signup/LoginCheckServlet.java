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
import java.util.List;


@WebServlet("/login")
public class LoginCheckServlet extends HttpServlet {
    static String userName=null;
    public void checkValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

           String name = req.getParameter("login-name");
        String password = req.getParameter("login-password");
           ArrayList <String> loginUserName = new ArrayList<String>();
           loginUserName.addAll(SignupCheckServlet.storeUserName);
        HttpSession session = req.getSession(true);
        session.setAttribute("loginName", name);

           for (int i = 0; i < loginUserName.size(); i++) {
               if (name.equals(loginUserName.get(i))) {
                   userName=name;
               }
           }

        if (password.equals(name + "pass")) {
            if (name==userName) {
                resp.sendRedirect("loginWelcome");
            }else {
                resp.sendRedirect("loginNoUserName");

            }
        } else {
            userName=null;
            resp.sendRedirect("loginError");
        }
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkValues(req, resp);
    }

}