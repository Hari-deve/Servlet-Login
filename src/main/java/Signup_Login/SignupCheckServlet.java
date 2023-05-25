package Signup_Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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



        for (int i = 0; i< storeMail.size()||i< storeUserName.size(); i++){
            if (mail.equals(storeMail.get(i))&&i<storeMail.size()){
                alreadyUsedMail=storeMail.get(i);
            } else if (name.equals(storeUserName.get(i))&&i< storeUserName.size()) {
                alreadyUsedName=storeUserName.get(i);
            }
        }

        if (setPassword.equals(name+"pass") && setPassword.equals(confirmPassword)) {
            if (name.equals(alreadyUsedName)){
                out.println(name+" is already in use");
            } else if (mail.equals(alreadyUsedMail)) {
                out.println(mail+" is already in use");
            }else {
                storeMail.add(mail);
                storeUserName.add(name);
                out.println("Welcome "+name+" You have Created Account Successfully");
            }
        }else {
            out.println(" Sorry Invalid Inputs Check and Try again");
        }

    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkValues(req, resp);
    }

}