package Signup_Login;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class LoginRecord {
   @Id private Long id;
   @Index private String name;
   @Index private String loginTime;
   @Index private String mailID;
   @Index private String logoutTime;

   public LoginRecord(String name,String mailID, String loginTime,String logoutTime) {
      this.name = name;
      this.loginTime = loginTime;
      this.mailID=mailID;
      this.logoutTime=logoutTime;
      this.id=null;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getLoginTime() {
      return loginTime;
   }

   public void setLoginTime(String loginTime) {
      this.loginTime = loginTime;
   }

   public String getMailID() {
      return mailID;
   }

   public void setMailID(String mailID) {
      this.mailID = mailID;
   }

   public String getLogoutTime() {
      return logoutTime;
   }

   public void setLogoutTime(String logoutTime) {
      this.logoutTime = logoutTime;
   }
}
