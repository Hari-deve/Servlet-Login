package Signup_Login;

import com.google.appengine.api.datastore.*;

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
                storingData(name,mail,confirmPassword);
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
    public static void storingData(String name,String mail,String Password){

        DatastoreService datastoreService=DatastoreServiceFactory.getDatastoreService();
        Key key=KeyFactory.createKey("SignupDetails",mail);
        Entity store=new Entity(key);
        store.setProperty("UserName",name);
        store.setProperty("UserMail",mail);
        store.setProperty("Password",Password);
        datastoreService.put(store);

        try {
            Entity e5=datastoreService.get(key);
            System.out.println(e5);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        Query sorting=new Query("SignupDetails").addSort("UserName",Query.SortDirection.ASCENDING);
        PreparedQuery query=datastoreService.prepare(sorting);
        for (Entity result:query.asIterable()) {
            String userName=result.getProperty("UserName").toString();
            String userMail=result.getProperty("UserMail").toString();
            String userPassword=result.getProperty("Password").toString();
            System.out.println("UserName: "+userName+" UserMail "+userMail+" UserPassword :"+userPassword);
        }
    }
}