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
import java.util.List;

@WebServlet("/loggingOut")
public class LogoutProfile extends HttpServlet {
    static String logoutDateTime;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loggingOutUserName=LoginCheckServlet.userName;
        String loggingOutUserMail=LoginCheckServlet.userMail;
        String loggingInTime=LoginCheckServlet.dateTime;

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime=LocalDateTime.now();
        logoutDateTime=dateTimeFormatter.format(localDateTime);
        storingLoginData(loggingOutUserName,loggingOutUserMail,loggingInTime,logoutDateTime);

        LoginCheckServlet.userName=null;
        LoginCheckServlet.userMail=null;
        LoginCheckServlet.dateTime=null;
        logoutDateTime=null;
        PrintWriter out =resp.getWriter();
        out.println("The profile "+loggingOutUserName+" was logged out successfully");
    }

    public static void storingLoginData(String name,String userMail,String loginDateTime,String logoutDateTime){
        ObjectifyService.run(() -> {
            Objectify ofy = ObjectifyService.ofy();
            LoginRecord loginRecord = new LoginRecord(name,userMail,loginDateTime,logoutDateTime);
            ofy.save().entity(loginRecord).now();
            List<SignupRecord> loginRecords = ofy.load().type(SignupRecord.class).list();
            return null;
        });
    }
}
