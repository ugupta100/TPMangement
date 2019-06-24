package com.controller.pkg;

import java.io.IOException;
import java.io.PrintWriter;
// import java.util.Date;
import java.sql.Date;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dbproperties.pkg.Job;
import com.model.pkg.JobM;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class JobC
 */
@WebServlet("/JobC")
public class JobC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobC() {
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
        Job bean=new Job();  
        bean.setJOBID(request.getParameter("jid"));
        bean.setCOMPANYID(request.getParameter("cid"));
        bean.setJOBTYPE(request.getParameter("jtype"));
        bean.setSKILL(request.getParameter("skill"));
        bean.setMINEXP(Integer.parseInt(request.getParameter("minexp")));
        bean.setMAXEXP(Integer.parseInt(request.getParameter("maxexp")));        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format( Date.valueOf(request.getParameter("vdate")));
        bean.setVALIDDATE( Date.valueOf(date));
        bean.setVACANCY(Integer.parseInt(request.getParameter("vacancy")));
        bean.setCREATEDBY(id);
        
        request.setAttribute("bean",bean);  
        JobM.save(bean);  
        response.sendRedirect("Job.jsp");  

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
		doGet(request, response);
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Job bean=new Job();  
        bean.setId(Integer.parseInt(req.getParameter("id")));
        int status=JobM.delete(bean);
        //String result = this.toJson(bean);
        
        PrintWriter out = res.getWriter();
        res.setContentType("text/plain");
        res.setCharacterEncoding("UTF-8");
        out.print(status);
        out.flush();   

	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Job bean=new Job();  
        bean.setJOBID(request.getParameter("jid"));
        bean.setJOBTYPE(request.getParameter("jtype"));
        bean.setSKILL(request.getParameter("skill"));
        bean.setMINEXP(Integer.parseInt(request.getParameter("minexp")));
        bean.setMAXEXP(Integer.parseInt(request.getParameter("maxexp")));        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format( Date.valueOf(request.getParameter("vdate")));
        bean.setVALIDDATE( Date.valueOf(date));
        bean.setVACANCY(Integer.parseInt(request.getParameter("vacancy")));
        int status=JobM.update(bean);
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        out.print(status);
        out.flush();   
	}
}
