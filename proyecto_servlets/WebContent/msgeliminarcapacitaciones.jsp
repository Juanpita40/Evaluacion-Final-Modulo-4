<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de informacion</title>
    <link rel="stylesheet" href="hojacssdeestilos.css" />
    <link rel="icon" type="image/png"
        href="C:\Users\juani\Documents\JAVA desarrollo web\modulo 3 desarrollo web\Clase 1\Ejercicio grupal 1\ti.ico" />
    <link rel="stylesheet" href="hojacssdeestilos.css" />
</head>

<body>
	<div class="header">
        <h1>Plataforma de Registro</h1>
    </div>    
    <hr/>
	
	<h1>Eliminar cliente</h1>
	
	<c:if test="${resulteliminacion == true}">
		<h3>La capacitacion ha sido eliminada exitosamente</h3>
	</c:if>

	<c:if test="${resulteliminacion == false}">
		<h3>Ocurrió un error al eliminar la capacitacion</h3>
	</c:if>
	
	<br/><br/>
	<a href="${pageContext.request.contextPath}/Capacitacionesservlet">Volver al listado de clientes</a>
	
</body>
</html>