<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
	    
		<div id="login" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">登录</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="LoginServlet" method="post">
					<div class="control-group">
						<label class="control-label" for="inputName">用户名</label>
						<div class="controls">
							<input type="text" id="loginName" placeholder="Name" name="mid" value="${mid}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">密码</label>
						<div class="controls">
							<input type="password" id="inputPassword" placeholder="Password" value="${password}" name="password">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<label class="checkbox">
								<input type="checkbox"> 记住密码
							</label>
							<button type="submit" class="btn">登录</button>
							<a class="btn" href="#zhuce" data-toggle="modal"  data-dismiss="modal"  aria-hidden="true">没有账号，现在注册</a>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>

			</div>
		</div>
		
		
         <div id="zhuce" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">注册</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="RegistServlet" method="post" onSubmit="return validate(this)">
					<div class="control-group">
						<label class="control-label" for="inputName" >用户名</label>
						<div class="controls">
							<input type="text" id="registName" placeholder="Name" name="mid" value="${re_mid}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail" >邮箱</label>
						<div class="controls" style="">
							<input type="email" id="inputEmail" placeholder="Email" name="email" value="${reg_email}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword" >密码</label>
						<div class="controls">
							<input type="password" id="inputPassword" placeholder="Password" name="password" value="${reg_pass}">
						</div>
					</div>
					
					<div class="control-group">
						<div class="controls">

							<button type="submit" class="btn">注册</button>

						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>

			</div>
		</div>
		
	
	</body>
	
</html>
