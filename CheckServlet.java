package loginPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")

public class CheckServlet extends HttpServlet {
	public void checkValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("nam");
		String mail=req.getParameter("mai");
		String setPassword=req.getParameter("pass");
		String confirmPassword=req.getParameter("con");
		
		HttpSession session=req.getSession();
		session.setAttribute("name", name);
		
		if (setPassword.equals(confirmPassword)) {
			resp.sendRedirect("welcome");
		}else {
			resp.sendRedirect("error");
		}
		PrintWriter out=resp.getWriter();
		out.println(name);
		out.println(mail);
		out.println(setPassword);
		out.println(confirmPassword);
		
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		checkValues(req, resp);
	}
	
	
}
