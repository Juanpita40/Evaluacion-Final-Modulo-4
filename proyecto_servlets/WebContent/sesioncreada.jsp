<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generar Sesion</title>
</head>
<body>
	<h4>La sesión ha sido creada exitosamente</h4>
	<br/>
	<p>El valor es: "${nombresesion}" </p>
	<a href="<%= request.getContextPath() %>/revisarsesion">Revisar sesión</a>
</body>
</html>