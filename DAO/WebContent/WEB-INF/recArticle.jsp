<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="Beans.Article"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${listeArticles}" var="article" >
	<table class="article">
						<tr>
							<td>
								<div id="<c:out value="${article.id_article}"/>" ></div>
								<div id="<c:out value="${article.nom_a}"/>" ></div>
								<div id="<c:out value="${article.prix}"/>" ></div>
								<div id="<c:out value="${article.description}"/>" ></div>
								<div id="<c:out value="${article.quantité}"/>" >		
								</div>
							</td>
						</tr>
						</table>
						</c:forEach>
</body>
</html>