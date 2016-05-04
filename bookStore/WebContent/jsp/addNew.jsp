<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException"%>
<%@ page import="book.util.*"%>


<% 
	request.setCharacterEncoding("utf-8") ; 
%>
<div id="addNew" class="tab-pane">
    <div class="addNew_conten">
    	<form action="AddBook" method="post" enctype="multipart/form-data" accept-charset="utf-8" onsubmit="document.charset='utf-8'">
    		<div>
    			<span class="left_label">选择图书类别：</span>
    			<select name="book_type">
                    <option value="01">丛书</option>
                    <option value="02">辞典</option>
                    <option value="03">诗集、论文集</option>
                    <option value="04">期刊</option>
                    <option value="05">艺术、编程</option>
                    <option value="06">小说</option>
                </select>
    		
    		</div>
    		<div>
    			<span class="left_label">图书名：</span>
    			<input type="text" required name="book_name" value=""/>
    		</div>
    		
    		<div>
    			<span class="left_label">添加封面图：</span>
    			
                <input id="upload_img" type="file" name="book_img" />
                <br/>
                
    	    </div>
    	    <div>
    			<span class="left_label">作者：</span>
    			<input type="text" name="book_author" value="" />
    		</div>
    		<div>
    			<span class="left_label">出版社：</span>
    			<input type="text" name="book_publishing"/>
    		</div>
    		<div>
    			<span class="left_label">简介：</span>
    			<textarea type="text" name="book_introduct"></textarea>
    		</div>
    		<div>
    			<span class="left_label">价格：</span>
    			<input type="text" name="book_price" value=""/>
    		</div>
    		<div>
    			<span class="left_label">优惠价格：</span>
    			<input type="text" name="book_newprice"/>
    		</div>
    		<div>
    			<span class="left_label">库存：</span>
    			<input type="text" name="book_num"/>
    		</div>
    		
    		<div>
    		    <button type="submit" class="btn btn-info">保存并上架</button>
    		</div>
    	</form>
    </div>        	
</div>


