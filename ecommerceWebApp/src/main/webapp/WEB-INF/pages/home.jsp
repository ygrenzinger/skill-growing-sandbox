<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
	    <title>FootBall ECommerce</title>
	</head>
	<body>

		<h3 style="text-align:center"> Bienvenue  ${name} ${firstname} à la boutique des Girondins de Bordeaux !</h3>
		
		<c:if test="${not empty items}">
		    <c:forEach var="item" items="${items}">
		    	<form:form method="POST" action="addBasket" modelAttribute="items">
		    		<table style="border:1px solid black;vertical-align:middle;float:left;margin-left:10px">
					    <tr>
					        <td><b><c:out value="${item.description}" /></b></td>
					    </tr>
					    <tr>
					        <td><b><c:out value="${item.price}" />&euro;</b></td>
					    </tr>
					    <tr>
					        <td style="font-size:10px;">Ref: <c:out value="${item.reference}" /></td>
					    </tr>
					    <tr>
					        <td style="font-size:10px;"><c:out value="${item.composition}" /></td>
					    </tr>
					    <tr>
					    	<td>Taille</td>
					        <td>
					        	<form:select path="${size.referenceSize.size}"/>
							</td>
					    </tr>
					     <tr>
					       <td colspan="2">
		            			<input type="submit" value="Ajouter au panier"/>
		       				 </td>
					    </tr>
					</table>
				</form:form>  
			</c:forEach>
		</c:if>
	</body>
</html>