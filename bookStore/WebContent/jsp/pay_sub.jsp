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

	<body id="pay_sub">
		<header>
			<%@ include file="header.jsp"%>
		</header>
		
		<div class="container">
			<div id="pay_title"><strong>收银台</strong></div>
			<span><strong>订单提交成功，请您尽快付款！ 订单号：<%=request.getParameter("orderno")%></strong></span>
			
			<div class="pay_sub_conten">
				
				
				<form action="PayPasswordServlet" method="post">
				    <input type="hidden" name="orderno" value=<%=request.getParameter("orderno")%>>
				     <input type="hidden" name="addno" value=<%=request.getParameter("addno")%> >
				    <input type="hidden" name="mid" value=<%=request.getSession().getAttribute("id") %>>
					<p class="pay_sub_price form_eles">应付金额<strong><%=request.getParameter("countFee")%></strong>元</p>
					<span class="form_eles">输入支付密码，确认支付</span><br />
					<input type="text" name="paypassword" class="form_eles" placeholder="输入支付密码"/>
				    <button type="submit" class="btn btn-danger pay_sub_now ">确认支付</button>
				</form>
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