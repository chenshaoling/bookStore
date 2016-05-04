<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="book.factory.DAOFactory,book.vo.*"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>

		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/index.css" />
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/page.js"></script>
		<script type="text/javascript" language="javascript">
           window.onload = function(){
             page = new Page(10,'table1','group_one');
          
           };
        </script>
	</head>

	<body>

		<header>
			<%@include file="header.jsp"%>
		</header>
		<div id="myCarousel" class="carousel slide">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- Carousel items -->
				<div class="carousel-inner">
					<div class="active item">
                        <img src="../img/large_1.jpg">
					</div>
					<div class="item">
						<img src="../img/large_2.jpg">

					</div>
					<div class="item">
						<img src="../img/large_3.jpg">

					</div>
				</div>
				<!-- Carousel nav -->
				<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
				<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
		<div class="container">
			

			<div id="table1">
				<ul class="thumbnails lists" id="group_one">
	<%

	String keyWord = request.getParameter("kw") ;
	if(keyWord == null){
		keyWord = "" ;	// 如果没有查询关键字，则查询全部
	}
	
	List<Product> all = DAOFactory.getIProductDAOInstance().findAll(keyWord) ;
	int total=Integer.parseInt(String.valueOf(DAOFactory.getIProductDAOInstance().getAllCount(keyWord)));
	Iterator<Product> iter = all.iterator() ;
	
    
	while(iter.hasNext()){
		
		Product book = iter.next() ;
   %>
					<a href="book-info.jsp?bookId=<%=book.getBookId()%>">
						<li class="span6">
						<div class="thumbnail">
						
							<img src=<%=book.getBookImg()%> alt="">
							<div class="miaoshu">
								<h4><%=book.getBookName()%></h4>
								<p><%=book.getIntroduct()%></p>
								<span class="disabled-price price">￥<%=book.getPrice()%></span>
								<span class="price"><strong>￥<%=book.getNew_price()%></strong></span>
							</div>

						</div>
					</li>
					</a>
					
					<%
	}
	//long total1=DAOFactory.getIProductDAOInstance().getAllCount(12);
%>
					
				</ul>
			</div>
		
      
        <ul class="pager">
           <li class="previous">
              <a href="#" onclick="page.prePage();">&larr;上一页</a>
           </li>
           <li class="next">
              <a href="#" onclick="page.nextPage();">下一页 &rarr;</a>
           </li>
           </ul>
		</div>
		<%@include file="login.jsp"%>
		<footer>
		<%@ include file="footer.jsp"%>
			
		</footer>
		
		
	</body>

</html>