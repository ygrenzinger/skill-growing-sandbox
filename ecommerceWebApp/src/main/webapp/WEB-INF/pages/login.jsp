<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
	    <title>FootBall ECommerce</title>
	</head>
	<body>

		<h2>Authentification</h2>
		<form:form method="POST" action="validateLogin" modelAttribute="authentication" >
		   <table>
		    <tr>
		        <td><form:label path="login" >Login</form:label></td>
		        <td><form:input path="login" /></td>
				<td><form:errors path="login" cssClass="error"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="password">Mot de Passe</form:label></td>
		        <td><form:input type="password" path="password" /></td>
				<td><form:errors path="password" cssClass="error"/></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Valider"/>
		        </td>
		    </tr>
		</table>  
		</form:form>
		<a href="<c:url value="/subscription"/>">S'inscrire</a>

	</body>
</html>