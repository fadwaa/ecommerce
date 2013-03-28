<%@page import="Beans.Article" %>
<%@page import="java.util.Vector"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:set var="listeArticle" scope="page" value="${listeArticles}"></c:set>
 <c:forEach items="${listeArticle}" var="Article" > 

 
						<tr> 
 							<td> 
							
								<c:out value="${Article.nom_a}"></c:out></br> 
								<c:out value="${Article.prix}"></c:out></br>
 								<c:out value="${Article.description}"></c:out></br>  
 								<c:out value="${Article.quantité}"></c:out></br>	 
								
							</td> 
						</tr> 
						
						</c:forEach> 



</body>
</html>