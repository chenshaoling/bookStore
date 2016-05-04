<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>
	
		<div class="navbar  navbar-inverse">
				<div class="navbar-inner">
					<div class="container">

						<!-- .btn-navbar is used as the toggle for collapsed navbar content -->
						<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</a>

						<!-- Be sure to leave the brand out there if you want it shown -->
						<a class="brand" href="#">网上书店</a>
						<ul class="nav">
							<li class="active"><a href="index.jsp">首页</a></li>
							<li ><a href="newbook.jsp">新书</a></li>
							<li ><a href="onsale.jsp">优惠</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">图书类别<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="selecttype.jsp?type=01">丛书</a></li>
									<li><a href="selecttype.jsp?type=02">辞典</a></li>
									<li><a href="selecttype.jsp?type=03">诗集、论文集</a></li>
									
									<li><a href="selecttype.jsp?type=04">期刊</a></li>
									<li><a href="selecttype.jsp?type=05">艺术、编程</a></li>
									<li><a href="selecttype.jsp?type=06">小说</a></li>
								</ul>
							</li>
						</ul>

						<!-- Everything you want hidden at 940px or less, place within here -->

						<form class="navbar-search pull-right" action="select.jsp" method="post">
							<input type="text" class="search-query" placeholder="Search" name="key">
							
						</form>
						<ul class="nav pull-right">
						
						<%
						String target;
						String	tar_id;
						if(request.getSession().getAttribute("id") != null){
							 target="dropdown";
							 tar_id="";
							 
							 
						%>
							 
							 <li ><a>欢迎<font color="RED"><%=request.getSession().getAttribute("id")%></font>光临！</a></li>
							 
							 
						<% 			
		               } else{
			              // request.setAttribute("info","请先登陆！") ;
			               target="modal";
			               tar_id="login_war";
			            %> 
			            
			           <li><a href="#login" data-toggle="modal" name="identy">登陆/注册</a></li>
	                   <%
		               }
	                   %>
	                   
							<li class="divider-vertical"></li>
							<li class="dropdown" id="person_cen">
								<a href="#<%=tar_id%>" id="tar" class="dropdown-toggle" data-toggle="<%=target%>">个人中心<b class="caret"></b></a>
								<ul class="dropdown-menu" >
							
									<li><a href="myOrder.jsp?mid=<%=request.getSession().getAttribute("id") %>">我的订单</a></li>
									<li><a href="updata_pass.jsp">账户余额</a></li>
									<li><a href="buy_car.jsp">购物车</a></li>
									<li class="divider"></li>
									<li><a href="LogoutServlet">注销</a></li>
								</ul>
							</li>
							<li class="divider-vertical"></li>
							
							
							<%					
							
						    if( "admin".equals(session.getAttribute("id"))){
						   %>
							<li><a href="houtai.jsp" >店铺后台</a></li>
							<%
							}
							%>
						</ul>

					</div>
				</div>
			</div>
	        <%@include file="login_war.jsp" %>


	<!--<script type="text/javascript" src="js/index.js" ></script>-->

