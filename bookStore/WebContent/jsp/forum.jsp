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

	<body>
		<header>
			<%@ include file="header.jsp"%>
		</header>
		<div class="container">
			<div>
				<img class="img-circle img-polaroid" src="../img/HBuilder.png" width="80" height="80">
					
				<button class="btn">我发的帖</button>
				<button class="btn">发表新帖</button>
			</div>
			<div>
				<table class="table">
					<thead>
						<th>
							热门贴
						</th>
						
					</thead>
					<tbody>
						<tr class="error">
                            <td>
                            	muli 
                            </td>
                            <td >
                            	<time class="publish-time" >2015/21/09</time> 
                            </td>
						</tr>
					<tr class="warning">
						<td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr class="success">
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td><td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
                        
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
						<td colspan="2">
							<a>更多</a>
						</td>
						
					</tr>
					
					
					</tbody>
					
				</table>
				======================================================================================================================
				<table class="table">
					<thead>
						<th>
							坛论
						</th>
						
					</thead>
					<tbody>
						<tr>
                            <td>
                            	muli 
                            </td>
                            <td >
                            	<time class="publish-time" >2015/21/09</time> 
                            </td>
						</tr>
					<tr>
						<td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td><td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
                        
					</tr>
					<tr>
                        <td>
                            	muli 
                        </td>
                        <td >
                            	<time class="publish-time" >2015/21/09</time> 
                        </td>
					</tr>
					<tr>
						<td colspan="2">
							<a>更多</a>
						</td>
						
					</tr>
					
					
					</tbody>
					
				</table>
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