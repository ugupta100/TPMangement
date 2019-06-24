package com.controller.pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dbproperties.pkg.Cand;
import com.model.pkg.CandidateM;

/**
 * Servlet implementation class CandidateC
 */
@WebServlet("/CandidateC")
public class CandidateC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		int id=(int)(session.getAttribute("ID")==null?0:session.getAttribute("ID"));
		if(id>0){  
        Cand bean=new Cand();  
        bean.setROLLNO(request.getParameter("rno"));
        bean.setNAME(request.getParameter("name"));
        bean.setPHONENO(request.getParameter("phno"));
        bean.setDEPARTMENTCODE(request.getParameter("dpt"));
        bean.setEMAIL(request.getParameter("email"));
        bean.setSEMESTER(Integer.parseInt(request.getParameter("sem")));        
        bean.setCREATEDBY(id);
        
        request.setAttribute("bean",bean);  
          
        CandidateM.update(bean);  
        response.sendRedirect("Candidate.jsp");  

        }  
        else{  
        	response.sendRedirect("index.jsp");
        }  
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		int id=(int)(session.getAttribute("ID")==null?0:session.getAttribute("ID"));
		if(id>0){  
        Cand bean=new Cand();  
        bean.setROLLNO(request.getParameter("rno"));
        bean.setNAME(request.getParameter("name"));
        bean.setPHONENO(request.getParameter("phno"));
        bean.setDEPARTMENTCODE(request.getParameter("dpt"));
        bean.setEMAIL(request.getParameter("email"));
        bean.setSEMESTER(Integer.parseInt(request.getParameter("sem")));        
        bean.setCREATEDBY(id);
        
        request.setAttribute("bean",bean);  
          
        CandidateM.save(bean);  
        response.sendRedirect("Candidate.jsp");  

        }  
        else{  
        	response.sendRedirect("index.jsp");
        }  
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cand bean=new Cand();  
        bean.setROLLNO(request.getParameter("rno"));
        bean.setNAME(request.getParameter("name"));
        bean.setPHONENO(request.getParameter("phno"));
        bean.setDEPARTMENTCODE(request.getParameter("dpt"));
        bean.setEMAIL(request.getParameter("email"));
        bean.setSEMESTER(Integer.parseInt(request.getParameter("sem"))); 
        int status=CandidateM.update(bean);
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        out.print(status);
        out.flush();   
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        Cand bean=new Cand();  
        bean.setId(Integer.parseInt(request.getParameter("id")));
        int status=CandidateM.delete(bean);
        //String result = this.toJson(bean);
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        out.print(status);
        out.flush();   
	}

}
