<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="book.factory.DAOFactory,book.vo.*"%>
<%@ page import="java.util.*" %>
	<!DOCTYPE html>
	<html>
<%request.setCharacterEncoding("utf-8") ;  %>
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
			<div id="buy_title"><strong>结算页</strong></div>
			<h4>填写并核对订单信息</h4>
			<div id="buy_conten">
			
		     	
			    <div class="buy_info buy_boder"><strong>收货人信息 </strong>  <a href="newAddress.jsp?bookId=${bookId }&chooseNum=${chooseNum}" class="buy_add_adress">新增收货地址</a>
				    <div class="clearfix ">
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu" >
                        <%
                        String mid=String.valueOf(request.getSession().getAttribute("id"));
                        List<AddressInfo> all = DAOFactory.getIAddressInfoDAOInstance().findAll(mid) ;
                        Iterator<AddressInfo> iter = all.iterator() ;
                        while(iter.hasNext()){
            				
            				AddressInfo addr = iter.next() ;
                        %>
                            <li class="addList"><a tabindex="-1" href="#"> <%=addr.getAddname() %>  <%=addr.getAddr() %>  <%=addr.getPhone() %></a>
                             <input type="hidden" value="<%=addr.getAddno() %> ">
                             <input type="hidden" value="<%=addr.getAddname() %> ">
                             <input type="hidden" value="<%=addr.getAddr() %> ">
                             <input type="hidden" value=" <%=addr.getPhone() %> ">
                            </li>
                           <%
                           }
                           %>
                          
                        </ul>
                    </div>
		        </div>
		        <div class="pay_online buy_boder">
		        	<strong>支付方式</strong><br>
                    <span>&ensp;&emsp;在线支付</span><br>
                    <strong>配送方式</strong><br>
                    <span>&ensp;&emsp;快递运输</span>
		        </div >
		        <div class="buy_order buy_boder">
		        	<ul class="thumbnails lists">
					
						<li class="span11 ">
						<table class="table table-bordered table-striped"> 
							<tr>
								<td colspan="6">
									
								    <span>商家：网上书店</span>
								</td>
								
							</tr>
							<tr>
								<td>
									<img src=${bookImg } width="120" >
								</td>
								
							    <td>
								
								    <p>《 ${bookName}》</p>
								
								    
								    <p>
									   金额：￥ ${fee}
								    </p>
							    </td>
							
							    <td>
							    	<p>
									订单金额：￥${fee}
								    </p>
							    </td>
								    
							    <td>
									<p>数量： ${chooseNum}</p>
								</td>
							  
							    <td>
								    <p>
									配送费：无
								    </p>
							    </td>
								
							</tr>
							
						</table>	
						添加订单备注			
					<input type="text" placeholder="填写特殊要求" class="span11"/>			
					
					</li>
					
				</ul>
		        </div>
		    </div>
		    <div class="buy_total">
		    	${chooseNum} 件商品，总商品金额：￥${countFee}<br />
                                        返现： -￥0.00<br />
                                        运费： ￥0.00<br />
                                        应付总额：￥${countFee}<br />
		    </div>
		    
		    <pre class="buy_final_info" id="buy_final_info"> 
		    	
		    </pre>
		        <form action="PayServlet" class="buy_submit" >
		        <input type="hidden" id="addno" name="addno" value="">
		        <input type="hidden"  name="orderno" value=${orderno} >
		        <input type="hidden" name="fee" value= ${fee}>
		        <input type="hidden" name="countFee" value= ${countFee}>
		    	应付总额：<strong><span class="buy_final_price">￥ ${countFee}</span></strong><button type="submit " class="btn-inverse btn">提交订单</button>
		    </form>
		</div>
		<%@include file="login.jsp"%>
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript">
		window.onload=function(){
			var li=document.getElementsByClassName('addList');
			var info=document.getElementById('buy_final_info');
			var addno=document.getElementById('addno');
			var oldnode1=document.createElement('text');
			var oldnode2=document.createElement('p');
			var oldnode3=document.createElement('p');
			
			oldnode1.innerHTML="寄送至：";
			oldnode2.innerHTML=li[0].getElementsByTagName('input')[2].value; 
			oldnode3.innerHTML="姓名"+li[0].getElementsByTagName('input')[1].value+"  "+li[0].getElementsByTagName('input')[3].value;			 
			 		 
			info.appendChild(oldnode1);
			info.appendChild(oldnode2);
			info.appendChild(oldnode3);
			addno.value=li[0].getElementsByTagName('input')[0].value;
			
			for(var i=0;i<li.length;i++){
				li[i].onclick=function(){
				  info.innerHTML="";
				  var node1=document.createElement('text');
				  var node2=document.createElement('p');
				  var node3=document.createElement('p');
				 
				  node1.innerHTML="寄送至：";
				  node2.innerHTML=this.getElementsByTagName('input')[2].value; 
				  node3.innerHTML="姓名"+this.getElementsByTagName('input')[1].value+"  "+this.getElementsByTagName('input')[3].value;		  
				 			 
				 info.appendChild(node1);						 
				 info.appendChild(node2);
				 info.appendChild(node3);
				
				 
				 addno.value=this.getElementsByTagName('input')[0].value;
				
				}
			}
			
		}
		</script>
	</body>

	</html>