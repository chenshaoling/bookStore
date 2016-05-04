<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="utf-8">
		<title>
		</title>

		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/index.css" />
	</head>

	<body id="pay">
		<header>
			<%@ include file="header.jsp"%>
		</header>
		
		<div class="container">
			<form action="AddAddressServlet" method="post">
			<input type="hidden" name="mid" value=<%=request.getSession().getAttribute("id")%>>
			 <input type="hidden" name="bookId" value=<%=request.getParameter("bookId")%>>
			  <input type="hidden" name="chooseNum" value=<%=request.getParameter("chooseNum")%>>
		  <div>
			  
			   收货人：
			   <input type="text" name="addname">
			   
			   </div>
			   <div>
			   收货地址：
			   <input type="text" name="addr">
			   
			   </div>
			   <div>
			   收货人电话号码：
			   <input type="text" name="phone">
			   
			   </div>
			   <button class="btn">
			   保存
			   </button>
			</form>
		</div>
		<%@include file="login.jsp"%>
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	</body>

	</html>