<%@page contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><html xmlns="http://www.w3.org/1999/xhtml">	<head>		<meta name="keywords" content="" />		<meta name="description" content="" />		<meta http-equiv="content-type" content="text/html; charset=utf-8" />		<title>Photoshoot by FCT</title>		<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />		<script src="https://kit.fontawesome.com/752f20c697.js" crossorigin="anonymous"></script>		<script type="text/javascript" src="jquery-1.6.2.min.js"></script>		<script type="text/javascript" src="jquery.poptrox-0.1.js"></script>	</head>	<body>		<div id="header" class="container">			<div id="logo">				<h1><a href="#">Мой магазин </a></h1>			</div>			<div id="menu">				<ul>					<li class="current_page_item"><a href="index.jsp">Главная</a></li>					<li><a href="products.jsp">Товары</a></li>					<li><a href="registration.jsp">Регистрация</a></li>					<li><a href="authorization.jsp">Вход</a></li>					<li><a href="cart.jsp">Корзина</a></li>				</ul>			</div>		</div>		<div id="poptrox">			<ul id="gallery">				<li><a href="images/img01_big.jpg"><img src="images/img01.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>				<li><a href="images/img02_big.jpg"><img src="images/img02.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>				<li><a href="images/img03_big.jpg"><img src="images/img03.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>				<li><a href="images/img04_big.jpg"><img src="images/img04.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>				<li><a href="images/img02_big.jpg"><img src="images/img02.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>				<li><a href="images/img01_big.jpg"><img src="images/img01.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>				<li><a href="images/img04_big.jpg"><img src="images/img04.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>				<li><a href="images/img03_big.jpg"><img src="images/img03.jpg" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>			</ul>			<br class="clear" />			<script type="text/javascript">				$('#gallery').poptrox();			</script>		</div>