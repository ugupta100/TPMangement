package com.controller.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbproperties.pkg.Train;
import com.model.pkg.TrainingM;

/**
 * Servlet implementation class TrainingC
 */
@WebServlet("/TrainingC")
public class TrainingC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingC() {
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
			//System.out.println(Time.valueOf(request.getParameter("edtime")));
		Train bean=new Train(); 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        bean.setTRID(request.getParameter("trid"));
        bean.setTRAININGNAME(request.getParameter("trainingname"));
        bean.setSTARTDATE(Date.valueOf(simpleDateFormat.format( Date.valueOf(request.getParameter("stdate")))));
        bean.setENDDATE(Date.valueOf(simpleDateFormat.format( Date.valueOf(request.getParameter("eddate")))));
        bean.setSTARTTIME(Time.valueOf(request.getParameter("sttime")+":00"));
        bean.setENDTIME(Time.valueOf(request.getParameter("edtime")+":00"));        
        bean.setVENUE(request.getParameter("venue"));  
        bean.setCREATEDBY(id);
        
        request.setAttribute("bean",bean);  
          
        TrainingM.save(bean);  
        response.sendRedirect("Training.jsp");  

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

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Train bean=new Train();  
		//System.out.println(request.getParameter("edtime"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		bean.setTRID(request.getParameter("trid"));
        bean.setSTARTDATE(Date.valueOf(simpleDateFormat.format( Date.valueOf(request.getParameter("stdate")))));
        bean.setENDDATE(Date.valueOf(simpleDateFormat.format( Date.valueOf(request.getParameter("eddate")))));
        bean.setSTARTTIME(Time.valueOf(request.getParameter("sttime")));
        bean.setENDTIME(Time.valueOf(request.getParameter("edtime")));        
        bean.setVENUE(request.getParameter("venue"));
        int status=TrainingM.update(bean);
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
		Train bean=new Train();  
        bean.setId(Integer.parseInt(request.getParameter("id")));
        int status=TrainingM.delete(bean);
        //String result = this.toJson(bean);
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        out.print(status);
        out.flush();   
	}

}
