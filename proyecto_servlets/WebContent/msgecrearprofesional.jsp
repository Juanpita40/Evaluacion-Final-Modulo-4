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
	<h1>Crear Profesional</h1>
	
	<c:if test="${result == true}">
		<h3>El Profesional ha sido agregado exitosamente</h3>
	</c:if>

	<c:if test="${result == false}">
		<h3>Ocurrió un error al guardar al Profesional</h3>
	</c:if>
	
</body>
</html>