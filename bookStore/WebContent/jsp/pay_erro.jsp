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
		<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css"/>
		<link rel="stylesheet" href="../css/index.css" />
	</head>

	<body id="pay_erro">
		<header>
			<%@ include file="header.jsp"%>
		</header>
		
		<div class="container" >
			<div id="pay_title"><strong>收银台</strong></div>
			<div class="result-pay-box">
            <div class="result-pay result-pay-failure">
                <div class="rp-box">
                    <h2 class="rp-title">
	                    <em class="fa fa-exclamation"></em>
	                    账户余额不足，请充值后再支付。
                    </h2>
                    <div class="rp-tip">
                                              订单号:<span><%=request.getParameter("orderno") %></span>
                    
                    </div>
                </div>


                <div class="rp-info"><span class="rp-price"><em></em></span></div>
                
                <form action="index.jsp">
                	<button type="submit"class="btn btn-danger pay_now">
                                                            <!--  重新支付-->
                                          确定                                       
                    </button>
                </form>
                
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