package Signup_Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/login")
public class LoginCheckServlet extends HttpServlet {
    static String userName=null;
    public void checkValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login-name");
        String password = req.getParameter("login-password");
        ArrayList<String> loginUserName = new ArrayList<String>();
        loginUserName.addAll(SignupCheckServlet.storeUserName);
        PrintWriter out=resp.getWriter();

        for (int i = 0; i < loginUserName.size(); i++) {
            if (name.equals(loginUserName.get(i))) {
                userName=name;
            }
        }

        if (password.equals(name + "pass")) {
            if (name==userName) {
                out.println("Welcome "+name+" you have logged in successfully");
            }else {
                out.println("No such Username Found");
            }
        } else {
            userName=null;
            out.println("Incorrect Password Try Again");
        }
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkValues(req, resp);
    }

}