package Signup_Login;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@WebServlet("/login")
public class LoginCheckServlet extends HttpServlet {
    static String userName=null;
    static String userMail=null;
    static String dateTime=null;

    public void checkValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login-name");
        String password = req.getParameter("login-password");
        HashMap<String,String>loginUserDetails=new HashMap<>();
        loginUserDetails.putAll(SignupCheckServlet.storeMailUserName);
        PrintWriter out=resp.getWriter();

        for (String verifyName:loginUserDetails.keySet()) {
            if (name.equals(verifyName)){
                userName=name;
            }
        }

        if (password.equals(name + "pass")) {
            if (name==userName) {
                userMail=loginUserDetails.get(name);

                DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime localDateTime=LocalDateTime.now();
                dateTime=dateTimeFormatter.format(localDateTime);
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