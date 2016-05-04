<%@ page contentType="text/html" pageEncoding="utf-8"%>
<html>
<head><title>www.mldnjava.cn，MLDN高端Java培训</title></head>
<body>
<%	// 乱码解决
	request.setCharacterEncoding("utf-8") ;
%>
<center>
	<h1>登陆程序</h1>
	
	<br>
	<%
		if(session.getAttribute("id") != null){
	%>
			<h2>欢迎<font color="RED"><%=session.getAttribute("id")%></font>光临！</h2>
			<h3><a href="logout.jsp">登陆注销</a></h3>
	<%			
		} else {
			request.setAttribute("info","请先登陆！") ;
	%>
			<jsp:forward page="login.jsp"/>
	<%
		}
	%>
</center>
</body>
</html>