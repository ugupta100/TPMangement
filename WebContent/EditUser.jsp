<%@page import="com.dbproperties.pkg.Cmp,com.model.pkg.CompanyM,java.util.*"%>  
<jsp:useBean id="u" class="com.dbproperties.pkg.Cmp"></jsp:useBean>   
<jsp:setProperty property="*" name="u"/>  
<%   
u.setCOMPANYID(request.getParameter("cid"));
u.setCOMPANYNAME(request.getParameter("cname"));
u.setEMAIL(request.getParameter("email"));
u.setADRESS(request.getParameter("address"));
u.setPHONE(request.getParameter("pno"));
int i=CompanyM.update(u);  
response.sendRedirect("Company.jsp");  
%>  
