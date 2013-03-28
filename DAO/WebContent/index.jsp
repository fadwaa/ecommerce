
<%@page import="Beans.Article" %>
<%@page import="java.util.Vector"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>e-commerce</title>
<!--CSS-->
<link rel="stylesheet" href="css/styles.css">
<!--Google Webfont -->
<link href='http://fonts.googleapis.com/css?family=Istok+Web' rel='stylesheet' type='text/css'>
<!--Javascript-->
<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="js/jquery.flexslider.js" ></script>
<script type="text/javascript" src="js/jquery.easing.js"></script>
<script type="text/javascript" src="js/jquery.jcarousel.js"></script>
<script type="text/javascript" src="js/form_elements.js" ></script>
<script type="text/javascript" src="js/custom.js"></script>
<!--[if lt IE 9]>
    <script src="js/html5.js"></script>
<![endif]-->
<!-- mobile setting -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body>
<div class="wrapper">
    <div class="header_container">
        <!--Header Starts-->
        <header>
            <div class="css/base.css/top_bar clear">
                <!--Language Switcher Starts-->
                <div class="css/base.css/language_switch"> <a class="active" href="#" title="ENGLISH">EN</a> <a href="#" title="FRENCH">FR</a> </div>
                <!--Language Switcher Ends-->
                <!--Top Links Starts-->
                <ul class="top_links">
                    <li class="highlight"><a href="#">mon compte</a></li>
                    
                   <li class="highlight"><a href="#">se connecter</a></li>
                   
                </ul>
                <!--Top Links Ends-->
            </div>
            <!--Logo Starts-->
            <h1 class="logo"> <a href="leisure_index.html"><img src="images/logo.png" /></a> </h1>
            <!--Logo Ends-->
            <!--Responsive NAV-->            <div class="responsive-nav" style="display:none;">
                <select  onchange="if(this.options[this.selectedIndex].value != ''){window.top.location.href=this.options[this.selectedIndex].value}">
                    <option selected="" value="">Navigate...</option>
                    <option value="index.html"> Home</option>
                    <option value="catégorie_femme.html"> -  Listing Page</option>
                    <option value="detail_produit.html">Product Page</option>
                    <option value="panier.html"> -  Shopping Cart</option>
                    <option value="connexion.html"> -  Checkout</option>
                  
                </select>
            </div>
            <!--Responsive NAV-->
            <!--Search Starts-->
            <form class="header_search">
                <div class="form-search">
                    <input id="search" type="text" name="q" value="" class="input-text" autocomplete="off" placeholder="Search">
                    <button type="submit" title="Search"></button>
                </div>
            </form>
            <!--Search Ends-->
        </header>
        <!--Header Ends-->
    </div>
    <div class="navigation_container">
        <!--Navigation Starts-->
        <nav>
            <ul class="primary_nav">
                <li class="active"><a href="categorie?cat=femme">Femme</a>
                    <!--SUbmenu Starts-->
                    <ul class="sub_menu">
                        <li> <a href="#">Robes</a>
                            <ul>
                                <li><a href="#">Skirts</a></li>
                                <li><a href="#">Shorts</a></li>
                                <li><a href="#">Premium Pants</a></li>
                                <li><a href="#">Khakis</a></li>
                                <li><a href="#">Casual Pants</a></li>
                                <li><a href="#">Jeans</a></li>
                                <li><a href="#">Outerwear & Blazers</a></li>
                            </ul>
                        </li>
                        <li> <a href="#">Accessories</a>
                            <ul>
                                <li><a href="#">Sunglasses</a></li>
                                <li><a href="#">Scarves</a></li>
                                <li><a href="#">Hair Accessories</a></li>
                                <li><a href="#">Hats and Gloves</a></li>
                                <li><a href="#">Lifestyle</a></li>
                                <li><a href="#">Jeans</a></li>
                                <li><a href="#">Outerwear & Blazers</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!--SUbmenu Ends-->
                </li>
                <li><a href="categorie?cat=femme">Homme</a>
                    <!--SUbmenu Starts-->
                    <ul class="sub_menu">
                        <li> <a href="#">Men Summer Collection</a>
                            <ul>
                                <li><a href="#">Premium Pants</a></li>
                                <li><a href="#">Khakis</a></li>
                                <li><a href="#">Casual Pants</a></li>
                                <li><a href="#">Jeans</a></li>
                                <li><a href="#">Outerwear & Blazers</a></li>
                            </ul>
                        </li>
                        <li> <a href="#">Accessories</a>
                            <ul>
                                <li><a href="#">Sunglasses</a></li>
                                <li><a href="#">Scarves</a></li>
                                <li><a href="#">Hair Accessories</a></li>
                                <li><a href="#">Hats and Gloves</a></li>
                                <li><a href="#">Jeans</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!--SUbmenu Ends-->
                </li>
                <li><a href="leisure_listing.html">Enfants</a></li>
                <li><a href="leisure_listing.html">Mode</a></li>
                <li><a href="#">Accessories</a></li>
            </ul>
            <div class="minicart"> <a href="#" class="minicart_link" > <span class="item"><b>2</b> ITEM /</span> <span class="price"><b>$69.20</b></span> </a>
                <div class="cart_drop"> <span class="darw"></span>
                    <ul>
                        <li><img src="images/mini_c_item1.png"><a href="#">Clogs Beach/Garden Clog</a> <span class="price">$49.90</span></li>
                        <li><img src="images/mini_c_item2.png"><a href="#">Faded chambray shorts</a> <span class="price">$12.90</span></li>
                        <div class="cart_bottom">
                            <div class="subtotal_menu"><small>Subtotal:</small><big>$69.20</big></div>
                            <a href="leisure_cart.html">Checkout</a></div>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Navigation Ends-->
    </div>
    <div class="section_container">
        <!--Mid Section Starts-->
        <section>
            <!--Banner Starts-->
            <div id="banner_section">
                <div class="flexslider">
                    <ul class="slides">
                        <li> <img src="images/lm_banner_1.jpg" />
                            <!--<div class="flex-caption">
                     <h3>Explore the summer collection!</h3>
              </div>-->
                        </li>
                        <li> <img src="images/lm_banner_2.jpg" />
                            <!--<div class="flex-caption">
                      <h3>Shop now!</h3>
               </div> -->
                        </li>
                        <li> <img src="images/lm_banner_3.jpg" /> </li>
                    </ul>
                </div>
                <div class="promo_banner">
                    <div class="home_banner"><a href="#"><img src="images/promo_hb_1.jpg"></a></div>
                    <div class="home_banner"><a href="#"><img src="images/promo_hb_2.jpg"></a></div>
                    <div class="home_banner"><a href="#"><img src="images/promo_hb_3.jpg"></a></div>
                </div>
            </div>
            <!--Banner Ends-->
            <!--Product List Starts-->
            <div class="products_list products_slider">
                <h2 class="sub_title">Nouveau produit</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                 <c:set var="listeArticle" scope="page" value="${listeArticles}"></c:set>
            <c:forEach items="${listeArticle}" var="Article" > 
                    <li> <a class="product_image">
                    <img src="photos/<c:out value="${Article.image}"></c:out>"/></a>
                        <div class="product_info">
                            <h3><a href="leisure_detail.html">
                            <a href="leisure_detail.html">Détails </a></a></h3><small></small>
                            
                            </div>
                        <div class="price_info"> <a href="#">+ Ajouter au panier</a>
                            <button class="price_add" title="" type="button"><span class="pr_price">$<c:out value="${Article.prix}"></c:out></span><span class="pr_add">Add to Cart</span></button>
                        </div>
                    </li>
                    </c:forEach> 
              
                </ul>
               
            </div>
            <!--Product List Ends-->
            <!--Product List Starts-->
            <div class="products_list products_slider">
                <h2 class="sub_title">Produits offerts</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                    <c:set var="listeArticle" scope="page" value="${listeArticles}"></c:set>
 					<c:forEach items="${listeArticle}" var="Article" > 
                    <li> <a class="product_image"><img src="photos/<c:out value="${Article.image}"></c:out>"/></a>
                        <div class="product_info">
                            <h3><a href="leisure_detail.html"><a href="leisure_detail.html">Détails </a></a></h3><small></small>
                            </div>
                        <div class="price_info"> <a href="#">+ Ajouter au panier</a>
                            <button class="price_add" title="" type="button"><span class="pr_price">$<c:out value="${Article.prix}"></c:out></span><span class="pr_add">Add to Cart</span></button>
                        </div>
                    </li>
                    </c:forEach>
                  
                </ul>
            </div>
            <!--Product List Ends-->
            <!--Newsletter_subscribe Starts-->
            <div class="subscribe_block">
                <div class="find_us">
                    <h3>Trouvez-nous  sur</h3>
                    <a class="twitter" href="#"></a> <a class="facebook" href="#"></a> <a class="rss" href="#"></a> </div>
                <div class="subscribe_nl">
                    <h3>Abonnez-vous</h3>
                    <small>Inscrivez-vous à notre site</small>
                    <form id="newsletter" method="post" action="#">
                        <input type="text" class="input-text" value="Entrer votre e-mail" title="Enter your email" id="newsletter" name="email">
                        <button class="button" title="" type="submit"></button>
                    </form>
                </div>
            </div>
            <!--Newsletter_subscribe Ends-->
        </section>
        <!--Mid Section Ends-->
    </div>
    <div class="footer_container">
      
    </div>
</div>
<style type="text/css">
.page_selector{ position:absolute; right:0px; top:28%;}
.page_selector a.page_open{ display:inline-block; width:60px; height:12px; background:#252525; color:#fff; text-align:center; font-size:14px; padding:20px 0px; font-weight:bold; text-decoration:none; float:left;}
.page_selector ul{ float:left; background:#f0f0f0; padding:10px 0px; border-top:solid 2px #000; border-bottom:solid 2px #000; display:none;}
.page_selector ul li{ padding:8px 10px; }
.page_selector ul li a{ font-weight:bold; text-decoration:none; color:#000; display:block; padding:2px 5px; text-transform:uppercase; font-size:11px;}

.store_selector{ position:absolute; left:0px; top:28%;}
.store_selector .store_open{display:inline-block; width:128px; height:55px;}
.store_selector div{ float:left; width:157px; height:226px; display:none;}
</style>

<script type="text/javascript">
$(document).ready(function(){
	//SLIDE TOGGLE
	jQuery(".page_open").toggle(function() {
		 $('.page_selector ul').slideDown(300);	
		 }, function(){
		 $('.page_selector ul').slideUp(300);		 
	});	
	//SLIDE TOGGLE
	jQuery(".store_open").toggle(function() {
		 $('.store_selector div').slideDown(300);	
		 }, function(){
		 $('.store_selector div').slideUp(300);		 
	});		
});

</script>

<div class="store_selector">
<a href="#" class="store_open"><img src="../assets/choose.jpg"/></a>
<div>
<img src="../assets/shops.jpg" border="0" usemap="#Map"/>
<map name="Map"><area shape="rect" coords="3,171,159,222" href="../Lingerie_shop/leisure_index.html"><area shape="rect" coords="1,115,157,166" href="leisure_index.html"><area shape="rect" coords="0,59,156,110" href="../Gadget_shop/leisure_index.html">
  <area shape="rect" coords="2,3,158,54" href="../Fashion_shop/leisure_index.html">
</map>
</div>
</div>

<div class="page_selector">
<a href="#" class="page_open">PAGES</a>
<ul>
	<li> <a href="leisure_index.html">Accueil</a></li>
    <li> <a href="leisure_listing.html">Liste des produits</a></li>
    <li> <a href="leisure_detail.html">Détails du produit</a></li>
    <li> <a href="leisure_cart.html">Panier</a></li>
    <li> <a href="leisure_checkout.html">caisse</a></li>
</ul>
</div>
<!--CUSTOMIZE-->
</body>
</html>
