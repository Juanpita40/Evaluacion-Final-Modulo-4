<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Capacitaciones</title>
    <link rel="icon" type="image/png"
        href="C:\Users\juani\Documents\JAVA desarrollo web\modulo 3 desarrollo web\Clase 1\Ejercicio grupal 1\ti.ico" />
    <link rel="stylesheet" href="hojacssdeestilos.css" />
</head>

<body>
    <div class="header">
        <h1>Plataforma de registro de Usuarios.</h1>
    </div>
    <hr />
    <!---Menu---->
    <div class="row col-3 col-s-3 menu">
        <h4>Menu de inicio:</h4>
        <ul>
            <li><a href="inicioservlet" style="color:white;" title="Inicio">Inicio</a></li>
            <li><a href="contactoservlet" style="color:white;">Contacto</a></li>
            <li><a href="crearcapacitacionesservlet" style="color:white;">Crear Capacitación</a></li>
            <li>Crear Pago</li>
            <li><a href="crearusuarioservlet" style="color:white;">Crear Usuario</a></li>
            <li><a href="listarcapacitacionesservlet" style="color:white;">Listado de Capacitaciones</a></li>
            <li><a href="listadousuariosservlet" style="color:white;">Listado usuario</a></li>
            <li>Listado Asesoria</li>
            <li>Listado Pagos</li>
            <li>Listado Visitas</li>
            <li>Editar Lista de Capacitaciones</li>
            <li>Reportes</li>
            <li><a href="loginservlet" style="color:white;">Login de acceso</a></li>
            <li>Listado Accidentes</li>
            <li>Administrar Asistentes</li>
        </ul>
    </div>

    <div class="row col-9 col-s-9">

        <form>
            <h1>Listado de Capacitaciones</h1>

            <table border="1">
                <tr>
                    <th colspan="8">Capacitaciones</th>
                </tr>
                <tr>
                    <th>IDCAPACITACION</th>
					<th>FECHA CAPACITACION</th>
					<th>HORA</th>
					<th>LUGAR</th>
					<th>DURACION</th>
					<th>CANTIDADA DE ASISTENTES</th>
					<th>RUTCLIENTE</th>
					<th>ACCIONES</th>
					
                </tr>
                <c:forEach items="${listacapa}" var="capa">
					<tr>
						<td><c:out value="${capa.getIdcapa()}" /></td>
						<td><c:out value="${capa.getDia()}" /></td>
						<td><c:out value="${capa.getHora()}" /></td>
						<td><c:out value="${capa.getLugar()}" /></td>
						<td><c:out value="${capa.getDuracion()}" /></td>
						<td><c:out value="${capa.getCantasist()}" /></td>
						<td><c:out value="${capa.getRutclte()}" /></td>
						<td>
							<a href="Eliminarcapacitacionservlet?id=<c:out value="${capa.getIdcapa()}" />">Eliminar</a>
							&nbsp;|&nbsp;
							<a href="Editarcapacitacionservlet?id=<c:out value="${capa.getIdcapa()}" />">Editar</a>
						</td>	
					</tr>
				</c:forEach>


            </table>

        </form>
    </div>
</body>

</html>