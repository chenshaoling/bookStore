<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="book.factory.DAOFactory,book.vo.*"%>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>
<%
Member mem =new Member();
String mid=(request.getSession().getAttribute ("id")).toString();
mem=DAOFactory.getIMemberDAOInstance().findById(mid);

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
		
		<div class="container" id="pay_content">
			<div id="pay_title"><strong>收银台</strong></div>
			<form action="PayResultServlet">
			<span><strong>订单提交成功，请您尽快付款！ 订单号： ${orderno}</strong></span>
			<input type="hidden" name="orderno" value= ${orderno}>
			<span class="pay_price">应付金额<strong> ${countFee}</strong>元</span>
			
			    <div class="pay_conten">
				
				
				
					<div class="pay_ways">
						<input type="radio" value="" checked="checked"/>可用余额  账户余额: <%=mem.getMoney() %>元    需支付 ${countFee}元
					    <input type="hidden" name="countFee" value= ${countFee}>
					    <input type="hidden" name="addno" value= ${addno}>
					    <input type="hidden" name="mid" value=<%=mem.getMid() %>>
					</div>
				    
				    <button type="submit" class="btn btn-danger pay_now">立即支付</button>
				
			   </div>
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