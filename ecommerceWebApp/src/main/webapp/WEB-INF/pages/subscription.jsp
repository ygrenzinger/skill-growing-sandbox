<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
	    <title>FootBall ECommerce</title>
	</head>
	<body>

		<h2>Souscription</h2>
		<form:form method="POST" action="validateSubscription" modelAttribute="userSubscription">
			</br>
		   <table>
		    <tr>
		        <td><form:label path="name" >Nom</form:label></td>
		        <td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="firstname">Prenom</form:label></td>
		        <td><form:input path="firstname" /></td>
				<td><form:errors path="firstname" cssClass="error"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="mail">Adresse email</form:label></td>
		        <td><form:input path="mail" /></td>
				<td><form:errors path="mail" cssClass="error"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="confirmationMail">Confirmation de l'adresse email</form:label></td>
		        <td><form:input path="confirmationMail" /></td>
				<td><form:errors path="confirmationMail" cssClass="error"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="password">Mot de Passe</form:label></td>
		        <td><form:input path="password" type="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="confirmationPassword">Confirmation du mot de passe</form:label></td>
		        <td><form:input path="confirmationPassword" type="password"/></td>
				<td><form:errors path="confirmationPassword" cssClass="error"/></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Valider"/>
		        </td>
		    </tr>
		</table>  
		</form:form>
	</body>
</html>