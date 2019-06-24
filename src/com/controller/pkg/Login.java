package com.controller.pkg;

import java.io.IOException;
import java.io.PrintWriter;

import com.model.pkg.LoginM;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbproperties.pkg.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html");  
                  
        String name=request.getParameter("username");  
        String password=request.getParameter("pass");  
          
        User bean=new User();  
        User user=new User(); 
        bean.setName(name);  
        bean.setPassword(password);  
        request.setAttribute("bean",bean);  
        LoginM bag = new LoginM();
        
        HttpSession session=request.getSession();  
         
          
        user=bag.validate(bean);  
        if(user.getId()>0){  
            //RequestDispatcher rd=request.getRequestDispatcher("Dashboard.jsp");  
            //rd.forward(request, response);
        	response.sendRedirect("Dashboard.jsp");

            session.setAttribute("ID",user.getId()); 
            session.setAttribute("USERTYPE",user.getUSERTYPE()); 
            session.setAttribute("USERNAME",user.getName()); 
        }  
        else{  
            //RequestDispatcher rd=request.getRequestDispatcher("FailedLogin.jsp");  
            //rd.forward(request, response);  
        	response.sendRedirect("FailedLogin.jsp");
        }  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User bean=new User();  
        bean.setName(request.getParameter("rno"));
        bean.setPassword(request.getParameter("pass1"));
        int status=LoginM.save(bean);
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        out.print(status);
        out.flush();   
	}

}
