	<%@page contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
	<%@page import = "java.time.Duration, java.time.LocalDateTime, java.util.concurrent.TimeUnit"%>
	<%@include file = "header.jsp"%>
		<div id="page">
			<div id="bg1">
				<div id="bg2">
					<div id="bg3">
						<div id="content">
							<h2>Авторизация</h2>
							<%! private int count = 0;
								private int time = 5;
								private LocalDateTime startTime;
							%>

							<%
								String login = request.getParameter("login");
								String password = request.getParameter("password");
							%>

							<% 
								if(startTime != null && time - Duration.between(startTime, LocalDateTime.now()).getSeconds() < 0) {
									count = 0;
									startTime = null;
								}
								
								if(count < 3){
									if (login != null) {
									   if ("admin".equals(login) && "123".equals(password)) {
										  out.write("Access granted");
									   } else {
										  count++;
										  if(count == 3){
											 startTime = LocalDateTime.now();
										  }
										  out.write("Access denied");
									   }
									}
								%>   
								   <center>
									   <form action="">
										   <table border="0">
											  <tr>
												 <td width="100">Login</td>
												 <td ><input type="text" name="login" /></td>
											  </tr>
											  <tr>
												 <td>Password</td>
												 <td><input type="text" name="password" /></td>
											  </tr>
											  <tr>
												 <td align="center" colspan="2"><input type="submit" value="Send" /></td>
											  </tr>
										   </table>
									   </form>
								   </center>
							<%
							out.write("Number of attempts: " + count);
							}else{
								out.write("Unlocked " + (time - Duration.between(startTime, LocalDateTime.now()).getSeconds()));
							}
							%>
						</div>
						<div id="sidebar">
							<h2>Товары</h2>
							<ul>
								<li><a href="">Категория 1</a></li>
								<li><a href="">Категория 2</a></li>
								<li><a href="">Категория 3</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	<%@include file = "footer.jsp"%>