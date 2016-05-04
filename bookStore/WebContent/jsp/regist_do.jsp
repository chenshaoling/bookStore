<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ page import="book.vo.*"%>
<%@ page import="book.factory.*"%>

<
<%	// 乱码解决
	request.setCharacterEncoding("utf-8") ;
%>
<center>
<%
	Member mem = new Member() ;
    String re_mid=request.getParameter("mid");
    String re_pass=request.getParameter("password");
    String re_email=request.getParameter("email");
	mem.setMid(re_mid) ;
	mem.setPassword(re_pass) ;
	mem.setEmail(re_email) ;
	
	mem.setLastdate(new java.util.Date()) ;
%>

<%
	if(DAOFactory.getIMemberDAOInstance().doCreate(mem)){	// 注册成功
		response.setHeader("refresh","2;URL=index.jsp") ;
%>
		<h3>恭喜<%=mem.getMid()%>用户注册成功，两秒后将跳转到登陆页！</h3>
		<h3>如果没有跳转，请按<a href="index.jsp">这里</a>！</h3>
<%
	} else {
%>
		<h3>用户注册失败，此注册ID已经被人使用了！</h3>
<%
	}
%>
</center>
