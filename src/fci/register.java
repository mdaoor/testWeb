package fci;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register
 */
@WebServlet(name = "register-servlet", urlPatterns = { "/register" })
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user ; 
	private String LoginStatus ; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		//xuser = "systemuser" ; 
		
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: " + user).append(request.getContextPath());
		
		String userName = request.getParameter("name") ;
		String userpass = request.getParameter("pass") ;
		
		data mydata = new data() ; 
		mydata.AddnewUser(userName, userpass); 
		 HttpSession Csession = request.getSession();
		
		String loginResult = mydata.login(userName, userpass) ; 
		
		if (loginResult =="loggedIN") {
			
			Csession.setAttribute("LoginStatus", "OK");

		}
		else {
			Csession.setAttribute("LoginStatus", "null");

		}
		 
		
		response.getWriter().append("user name is: " + userName +"and pass is: " + userpass ) ; 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
