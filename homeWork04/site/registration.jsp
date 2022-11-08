	<%@page contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
	<%@page import = "java.util.Objects"%>
	<%@include file = "header.jsp"%>
		<div id="page">
			<div id="bg1">
				<div id="bg2">
					<div id="bg3">
						<div id="content">

							<%!
								private String regEmail = "^[a-zA-Z0-9]{1,}((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*@[a-zA-Z0-9]{1,}((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*\\.[a-zA-Z]{2,}$";
								private String regPassword = "^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$";
								
								private boolean isNoValidText(String text, String reg) {
									boolean check = false;
									if (Objects.isNull(text) || !text.matches(reg)) {
										check = true;
									}
									return check;
								}
								
								private boolean isNoValidText(String text) {
									boolean check = false;
									if (Objects.isNull(text) || text.isEmpty()) {
										check = true;
									}
									return check;
								}
							%>
							<%
								boolean isError = false;
								StringBuilder errors = new StringBuilder();	
								errors.append("</ul>");
								if(isNoValidText(request.getParameter("email"), regEmail)){
									errors.append("<li> not valid email</li>");
									isError = true;
								}
								if(isNoValidText(request.getParameter("password"), regPassword)){
									errors.append("<li>Password must contain at least 8 characters, 2 digits, 2 headers only in Latin</li>");
									isError = true;
								}
								if(!Objects.equals(request.getParameter("password"), request.getParameter("rePassword"))){
									errors.append("<li>Password mismatch</li>");
									isError = true;
								}
								if(isNoValidText(request.getParameter("fullName"))){
									errors.append("<li>Empty name</li>");
									isError = true;
								}
								if(isNoValidText(request.getParameter("region"))){
									errors.append("<li>No region selected</li>");
									isError = true;
								}
								if(isNoValidText(request.getParameter("gender"))){
									errors.append("<li>No gender selected</li>");
									isError = true;
								}
								if(isNoValidText(request.getParameter("comment"))){
									errors.append("<li>Empty comments</li>");
									isError = true;
								}
								if(isNoValidText(request.getParameter("agreement"))){
									errors.append("<li>No agreement</li>");
									isError = true;
								}
								errors.append("</ul>");
								if(isError){
							%>
							   <div class="registrationBox">
								  <h2>Регистрация</h2>
								  <form action="" method="post">
									 <label class="icon">
										<i class="far fa-envelope"></i>
									 </label>
									 <input type="text" name="email" placeholder="Email" pattern="^[a-zA-Z0-9]{1,}((\.|\_|-{0,1})[a-zA-Z0-9]{1,})*@[a-zA-Z0-9]{1,}((\.|\_|-{0,1})[a-zA-Z0-9]{1,})*\.[a-zA-Z]{2,}$"/>
									 <label class="icon">
										<i class="fas fa-shield-alt"></i>
									 </label>
									 <input type="password" name="password" placeholder="Password" pattern="^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$"/>
									 <label class="icon">
										<i class="fas fa-shield-alt"></i>
									 </label>
									 <input type="password" name="rePassword" placeholder="Re-password" pattern="^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$"/>
									 <label class="icon">
										<i class="fas fa-user"></i>
									 </label>
									 <input type="text" name="fullName" placeholder="Full name" required/>
									 <label class="icon">
										<i class="fas fa-map-marker-alt"></i>
									 </label>
									 <select name = "region">
										<option value = "Lviv">Lviv region</option>
										<option value = "Kyiv">Kyiv region</option>
										<option value = "Kharkiv">Kharkiv region</option>
									 </select>
									 <label class="icon">
										<i class="fas fa-venus-mars"></i>
									 </label>
									 <select name = "gender">
										<option value = "male">Male</option>
										<option value = "female">Female</option>
									 </select>
									 <div class ="comment">
										<label class="icon"><i class="far fa-comment"></i></label>
										<textarea  name = "comment" ></textarea>
									 </div>
									 <div class="checkbox">
										<p>I agree to the processing of my personal data</p>
										<input type="checkbox" name="agreement"/>
									 </div>
									 <input type="submit" value="send" name="send" />
								  </form>
							   </div>
							<%
									if(request.getParameter("send") != null){
										out.write(errors.toString());
									}
								
								}else{
									out.write("Registration successful");
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