<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="book.factory.DAOFactory,book.vo.*"%>
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
		<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css"/>
		<link rel="stylesheet" href="../css/index.css" />
	</head>

	<body id="update_pass">
		<header>
			<%@ include file="header.jsp"%>
		</header>
		<%
		String mid=(request.getSession().getAttribute("id")).toString();
		Member mem = DAOFactory.getIMemberDAOInstance().findById(mid);
		%>
	
		<div class="container" >
			<div id="pay_title"><strong>账户余额</strong></div>
			<div class="result-pay-box">
            <div class="result-pay result-pay-failure">
           
				
					
					<div >
						<label  >账户余额:</label>
						<div class="pass-box">
							<%=mem.getMoney() %>元
						</div>
						
					</div>
					<button class="btn pass-btns" onclick="history.back();">返回</button>
					
				
		
            </div>
        </div>

		</div>
		<%@include file="login.jsp"%>
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	</body>

	</html>