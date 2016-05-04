<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="book.factory.DAOFactory,book.vo.*"%>
<%@ page import="java.util.*" %>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>

    	<div id="modals" class="tab-pane">
            	<ul class="thumbnails lists">
				
<%
String keyWord2=null;
if(keyWord2==null){
	keyWord2="";
}
List<Order> all2 = DAOFactory.getIOrderDAOInstance().findAll(keyWord2) ;
Iterator<Order> iter2 = all2.iterator() ;
while(iter2.hasNext()){
	Order order = iter2.next() ;
	if(order.getOrderState().equals("待发货")){
	Product book=DAOFactory.getIProductDAOInstance().findById(order.getBookId());
	
%>	
						<li class="span9 ">
						<table class="table table-bordered table-striped"> 
							<tr>
								<td colspan="5">
									<input type="checkbox" />订单编号：<%=order.getAddno() %>
								    <span>下单时间：<%=order.getTime() %></span>
								</td>
								
							</tr>
							<tr>
								<td>
									<img src=<%=book.getBookImg() %> width="120" >
								</td>
								
							    <td>
								
								    <p>《<%=book.getBookName() %>》</p>
								
								    <p>数量：<%=order.getNum() %></p>
								    <p>
									   金额：￥<%=order.getFee() %>
								    </p>
							    </td>
							
							    <td>
							    	<p>
									订单金额：￥<%=order.getFee()*order.getNum() %>
								    </p>
							    </td>
								    
							    
							    <td>
								    <p>
									无备注
								    </p>
							    </td>
							
								<td>
									<a href="StateChange?orderno=<%=order.getOrderno() %>"class="btn">发货</a>
								    <button class="btn">备注</button>
								</td>
							</tr>
							
						</table>	
									
								
					
					</li>
					<%
					}
}
					%>
					
				</ul>
            </div>
