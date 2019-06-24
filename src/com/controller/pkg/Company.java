package com.controller.pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbproperties.pkg.Cmp;
import com.dbproperties.pkg.Job;
import com.model.pkg.CompanyM;

/**
 * Servlet implementation class Company
 */
@WebServlet("/Company")
public class Company extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Company() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
                    
        Cmp bean=new Cmp();  
        bean.setCOMPANYID(request.getParameter("cid"));
        bean.setCOMPANYNAME(request.getParameter("cname"));
        bean.setEMAIL(request.getParameter("email"));
        bean.setADRESS(request.getParameter("address"));
        bean.setPHONE(request.getParameter("pno"));
        bean.setCREATEDBY(1);
        
        request.setAttribute("bean",bean);  
        CompanyM bag = new CompanyM();
          
        int status=bag.save(bean);  
        response.sendRedirect("Company.jsp");          
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Cmp bean=new Cmp();  
        bean.setId(Integer.parseInt(req.getParameter("id")));
        int status=CompanyM.delete(bean);
        //String result = this.toJson(bean);
        
        PrintWriter out = res.getWriter();
        res.setContentType("text/plain");
        res.setCharacterEncoding("UTF-8");
        out.print(status);
        out.flush();   

	}

}
