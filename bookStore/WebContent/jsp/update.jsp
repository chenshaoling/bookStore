<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="book.util.*"%>
<%@ page import="book.factory.DAOFactory,book.vo.*"%>

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
	</head>

<%
String bookId=null;
try {
bookId = request.getParameter("bookId") ;
} catch (Exception e){}
Product book=DAOFactory.getIProductDAOInstance().findById(bookId);
%>

	<body>

		<header>
			<%@include file="header.jsp"%>
		</header>
		<div class="container">
      <div id="update">
    <div >
            <div>
    	     <a href="houtai.jsp" class="btn"> 返回</a>
    	     </div>
    	<form action="UpdateServlet" method="post">
    	     
    		<div>
    			<span class="left_label">选择图书类别：</span>
    			<select name="book_type">
                    <option value="01">丛书</option>
                    <option value="02">辞典</option>
                    <option value="03">诗集、论文集</option>
                    <option value="04">期刊</option>
                    <option value="05">艺术、编程</option>
                </select>
    		
    		</div>
    		<div>
    		    <input name="book_id" value="<%=bookId%>" type="hidden">
    			<span class="left_label">图书名：</span>
    			<input type="text" required name="book_name" value="<%=book.getBookName()%>"/>
    		</div>
    		
    		<div>
    			<span class="left_label">添加封面图：</span>
    			<input type="hidden" name="book_img" value=<%=book.getBookImg()%>>
    			
               
                <img id="preview_size_fake" src=<%=book.getBookImg()%>>
    	    </div>
    	    <div>
    			<span class="left_label">作者：</span>
    			<input type="text" name="book_author" value="<%=book.getAuthor()%>" />
    		</div>
    		<div>
    			<span class="left_label">出版社：</span>
    			<input type="text" name="book_publishing" value="<%=book.getPublishing()%>"/>
    		</div>
    		<div>
    			<span class="left_label">简介：</span>
    			<textarea  name="book_introduct"><%=book.getIntroduct() %></textarea>
    			
    		</div>
    		<div>
    			<span class="left_label">价格：</span>
    			<input type="text" name="book_price" value="<%=book.getPrice()%>"/>
    		</div>
    		<div>
    			<span class="left_label">优惠价格：</span>
    			<input  type="text" name="book_newprice" value="<%=book.getNew_price()%>"/>
    		</div>
    		<div>
    			<span class="left_label">库存：</span>
    			<input type="text" name="book_num" value="<%=book.getNum()%>"/>
    		</div>
    	
    		<div>
    		    <button type="submit" class="btn btn-info">保存修改并上架</button>
    		</div>
    	</form>
    	<div>
    	     <a href="houtai.jsp" class="btn btn-info">取消并返回</a>
    	 </div>
    </div>        	
</div>
</div>
		<%@include file="login.jsp"%>
		<footer>
		<%@ include file="footer.jsp"%>
			
		</footer>
		
		
	</body>
	

</html>

