<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="book.factory.DAOFactory,book.vo.*"%>
<%@ page import="java.util.*" %>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8" />
		<title></title>

		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/index.css" />
	</head>

	<body>

		<header>
			<%@include file="header.jsp"%>
		</header>
		<div class="container">
			
				
			
			<div>
				<img class="img-circle img-polaroid" src="../img/HBuilder.png" width="80" height="80">
					
				<span><strong>网上书店</strong></span>
			</div>
			<div class="span3 bs-docs-sidebar">
                <ul class="nav nav-list bs-docs-sidenav affix " id="tabs">
                    <li class="active">
                    	<a href="#overview" data-toggle="tab">
                    		<i class="icon-chevron-right">
                    			
                    		</i> 
                    		在售图书
                    	</a>
                    </li>
                    <li class="">
                    	<a href="#addNew" data-toggle="tab">
                    		<i class="icon-chevron-right">
                    			
                    		</i> 
                    		添加新图书
                    	</a>
                    </li>
                    <li class="" id="change">
                    	<a href="#modals" data-toggle="tab">
                    		<i class="icon-chevron-right">
                    			
                    		</i> 
                    		未发货订单
                    	</a>
                    </li>
                    <li class="">
                    	<a href="#dropdowns" data-toggle="tab">
                    		<i class="icon-chevron-right">
                    			
                    		</i> 
                    		订单管理
                    	</a>
                    </li>
                   
                    

                </ul>
            </div>

            <div class="container-right span9 tab-content"">
            	<%@include file="addNew.jsp"%>
            	<%@include file="modals.jsp"%>
            	<%@include file="dropdowns.jsp"%>
            	<div id="overview" class="tab-pane active">
            	<ul class="thumbnails lists">
            	<%
            	String keyWord = request.getParameter("kw") ;
            	if(keyWord == null){
            		keyWord = "" ;	// 如果没有查询关键字，则查询全部
            	} 
            	List<Product> all = DAOFactory.getIProductDAOInstance().findAll(keyWord) ;
            	Iterator<Product> iter = all.iterator() ;
            	while(iter.hasNext()){
            		Product book = iter.next() ;
            	
            	%>
             			<li class="span9 ">
						<table class="table table-bordered table-striped"> 
							<thead>
								<tr>
									<th>
										商品信息
									</th>
									<th>
										库存
									</th>
									<th>
										上架时间
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
       
							<tr>
								<td>
									<div>
										<span>商品编号：<%=book.getBookId()%></span>
								        <span>所属科目：<%=book.getBook_type()%></span>
									</div>
								    <div>
								    	<a href="book-info.jsp?bookId=<%=book.getBookId()%>">
										<img src=<%=book.getBookImg()%> width="120" >
									    </a>
								
								
								        <a href="book-info.jsp?bookId=<%=book.getBookId()%>">《<%=book.getBookName()%>》</a>
								
								     
								    </div>
									
								</td>
								<td>
									<%=book.getNum()%>
								</td>
								<td>
									<%=book.getOnsaleDate()%>
								</td>
								<td >
									<a href="update.jsp?bookId=<%=book.getBookId()%>" class="btn">修改</a>
									<br>
									<form action="DeletServlet" method="post">
									  <input type="hidden" name="book_id" value= <%=book.getBookId()%>>
									 
									  <button class="btn" type="submit" onclick="event.returnValue = confirm('删除是不可恢复的，你确认要删除吗？');">删除</a>
								    </form>
								</td>
							</tr>
							
						</table>	
									
								
					
					</li>
					<%} %>
					
				</ul>
            </div>
            </div>
		</div>
		
		<footer>
			<%@ include file="footer.jsp"%>
			
		</footer>
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	</body>
	
		<script>
		
 		$('#tabs a').click(function (e) {
             e.preventDefault();
             $(this).tab('show');
        })
 	</script>


</html>