<%-- 
    Document   : main
    Created on : 14.09.2016, 17:29:44
    Author     : Никита
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Bearings </title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>
<div style="position:absolute;left:-3072px;top:0">
    div class="width=100% height=100% align-left">
</div><div class="align-left" width="1"></div>
<div id="main_container">
    
  <div class="top_bar">
    <div class="top_search">
      <div class="search_text"><a href="#">Поиск</a></div>
      <input type="text" class="search_input" name="search" />
      <input type="image" src="images/search.gif" class="search_bt"/>
      
    </div>
    
   
  <div id="header">
    <div id="logo"> <a href="#"><img src="images/logotip.png" alt="" border="0" width="106.75" height="146.25" /></a> </div>
    <div class="oferte_content">
      <div class="top_divider"><img src="images/header_divider.png" alt="" width="1" height="164" /></div>
      <div class="top_divider"><img src="images/header_divider.png" alt="" width="1" height="164" /></div>
      <div style="
           text-align: center;
           
    color:#ff00ff; 
    font:italic small-caps 0.5in tahoma">
      <h2>Bearings</h2>
      </div>
    </div>
    
    <!-- end of oferte_content-->
  </div>
  <div id="main_content">
    <div id="menu_tab">
      <div class="left_menu_corner"></div>
      <ul class="menu">
        <li><a href="#" class="nav1"> Home</a></li>
        <li class="divider"></li>
        <li><a href="#" class="nav2">Products</a></li>
        <li class="divider"></li>
        <li><a href="#" class="nav3">Specials</a></li>
        <li class="divider"></li>
        <li><a href="users" class="nav4">My account</a></li>
        <li class="divider"></li>
        <li><a href="login" class="nav4">Sign Up</a></li>
        <li class="divider"></li>
        <li><a href="#" class="nav5">Shipping</a></li>
        <li class="divider"></li>
        <li><a href="contact.html" class="nav6">Contact Us</a></li>
        <li class="divider"></li>
        
      </ul>
      <div class="right_menu_corner"></div>
    </div>
    <!-- end of menu tab -->
    <div class="crumb_navigation"> Navigation: <span class="current">Home</span> </div>
    <div class="left_content">
      <div class="title_box">Categories</div>
      <ul class="left_menu">
        <li class="odd"><a href="#">?</a></li>
        <li class="even"><a href="#">?</a></li>
        <li class="odd"><a href="#">?</a></li>
        <li class="even"><a href="#">?</a></li>
        <li class="odd"><a href="#">?</a></li>
        <li class="even"><a href="#">?</a></li>
        <li class="odd"><a href="#">?</a></li>
        <li class="even"><a href="#">?</a></li>
        <li class="odd"><a href="#">?</a></li>
        <li class="even"><a href="#">?</a></li>
        <li class="odd"><a href="#">?</a></li>
        <li class="even"><a href="#">?</a></li>
      </ul>
     
      
    </div>
   <div class="center_content">
      <div class="center_title_bar">Latest Products</div>
      <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
            <c:forEach var="bearing" items ="${bearings}">
                <div class="product_title"><a href="details.html">${bearing.number}</a> </div>
                <div class="product_img"><a href="details.html"><img src="${bearing.image}" width="100"
                    height="111" alt="" border="0" /></a></div>
                    <p>${bearing.description}</p>
            </c:forEach>
          <!--<div class="product_title"><a href="details.html">Motorola 156 MX-VL</a></div>
          <div class="product_img"><a href="details.html"><img src="images/laptop.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>-->
        </div>
        </div> 
      </div>
    
    <!-- end of center content -->
    <div class="right_content">
      <div class="shopping_cart">
        <div class="cart_title">Shopping cart</div>
        <div class="cart_details"> 3 items <br />
          <span class="border_cart"></span> Total: <span class="price">350$</span> </div>
        <div class="cart_icon"><a href="#" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img src="images/shoppingcart.png" alt="" width="48" height="48" border="0" /></a></div>
      </div>
      <div class="title_box">What’s new</div>
      <div class="border_box">
        <div class="product_title"><a href="details.html">Motorola 156 MX-VL</a></div>
        <div class="product_img"><a href="details.html"><img src="images/p2.gif" alt="" border="0" /></a></div>
        <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>
      <div class="title_box">Manufacturers</div>
      <ul class="left_menu">
        <li class="odd"><a href="#">Sony</a></li>
        <li class="even"><a href="#">Samsung</a></li>
        <li class="odd"><a href="#">Daewoo</a></li>
        <li class="even"><a href="#">LG</a></li>
        <li class="odd"><a href="#">Fujitsu Siemens</a></li>
        <li class="even"><a href="#">Motorola</a></li>
        <li class="odd"><a href="#">Phillips</a></li>
        <li class="even"><a href="#">Beko</a></li>
      </ul>
      
    </div>
    
  </div>

    </body>
</html>
