<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="book.factory.DAOFactory,book.vo.*"%>
<%@ page import="java.util.*" %>
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

	<body id="buy">
		<header>
			<%@ include file="header.jsp"%>
		</header>
		
		<div class="container" >
			
		        <div class="buy_order buy_boder">
		        	<ul class="thumbnails lists">
						<%

	String keyWord = request.getParameter("kw") ;
	if(keyWord == null){
		keyWord = "" ;	// 如果没有查询关键字，则查询全部
	}
	keyWord=(request.getSession().getAttribute("id")).toString();
	List<Cart> all = DAOFactory.getICartDAOInstance().findAll(keyWord) ;

	Iterator<Cart> iter = all.iterator() ;
	 
		while(iter.hasNext()){
			Cart cart=iter.next();
			String bookId=cart.getBookId();
			Product book=DAOFactory.getIProductDAOInstance().findById(bookId);
	   %>
						<li class="span11 ">
						<table class="table table-bordered table-striped"> 
							<tr>
								<td colspan="6">
									
								    <span>商家：网上书店</span>
								</td>
								
							</tr>
							<tr>
								<td>
									<img src=<%=book.getBookImg() %> width="120" >
								</td>
								
							    <td>
								
								    <p>《<%=book.getBookName() %>》</p>
								
								    
								    <p>
									   金额：￥<%=book.getNew_price()>0?book.getNew_price():book.getPrice() %>
									   
								    </p>
							    </td>
							
							    <td>
							    	<p>
									订单金额：￥<%=(book.getNew_price()>0?book.getNew_price():book.getPrice())*cart.getCounts() %>
								    </p>
							    </td>
								    
							    <td>
									<p>数量：<button id="left-btn" class="btn">-</button><input id="choose-num" type="text" value=<%=cart.getCounts() %> name="chooseNum"><button id="right-btn" class="btn">+</button></p>
								</td>
							  
							    <td>
								    <p>
									配送费：无
								    </p>
							    </td>
							    <td>
							        <form action="BookInfoServlet">
							        <input type="hidden" name="id" value=<%=request.getSession().getAttribute("id")%>>
							        <input type="hidden" name="bookId" value=<%=book.getBookId()%>>
							        <input type="hidden" name="chooseNum" id="count" value="">
								     <button class="btn" type="submit" id="buy">
								             结算
								      </button>
								    </form>
								    <a class="btn" onclick="event.returnValue = confirm('删除是不可恢复的，你确认要删除吗？');" href="RemoveCartServlet?cartid=<%=cart.getCartid() %>">
								    删除
								    </a>
							    </td>
								
							</tr>
							
						</table>	
						</li>
   <%
          }
          
           %>					
		    </div>
		    
		</div>
		<%@include file="login.jsp"%>
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript">
    window.onload=function(){
    	var left=document.getElementById('left-btn');
    	var right=document.getElementById('right-btn');
    	var num=document.getElementById('choose-num');
    	var btns=document.getElementsByClassName('info-btn');
    	var count=document.getElementById('count');
    	var buy=document.getElementById('buy');
    	left.onclick=function(){
    		if(num.value<2){
    			num.value=1;
    		}else{
    			num.value--;
    		} 	    		
    	}
    	right.onclick=function(){
    		num.value++;
    	}	
    	
    	buy.onclick=function(){
    		
    		count.value=num.value;
    	}
    	
    }
   </script>
	</body>

	</html>