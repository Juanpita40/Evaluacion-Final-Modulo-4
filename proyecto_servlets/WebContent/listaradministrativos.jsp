<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Administrativos</title>
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
            <h1>Listado de Administrativos</h1>

            <table border="1">
                <tr>
                    <th colspan="6">Administrativos</th>
                </tr>
                <tr>
                    <th>RUT DEL ADMINISTRATIVO</th>
					<th>NOMBRE</th>
					<th>APELLIDOS</th>
					<th>CORREO</th>
					<th>AREA</th>
					<th>ACCIONES</th>
					
                </tr>
                <c:forEach items="${listaadmi}" var="admi">
					<tr>
						<td><c:out value="${admi.getRun()}" /></td>
						<td><c:out value="${admi.getNombre()}" /></td>
						<td><c:out value="${admi.getApellidos()}" /></td>
						<td><c:out value="${admi.getCorreo()}" /></td>
						<td><c:out value="${admi.getArea()}" /></td>
						<td>
							<a href="Eliminaradministrativoservlet?ad=<c:out value="${admi.getRun()}" />">Eliminar</a>
							&nbsp;|&nbsp;
							<a href="Editaradministrativoservlet?ad=<c:out value="${admi.getRun()}" />">Editar</a>
						</td>	
					</tr>
				</c:forEach>


            </table>

        </form>
    </div>
</body>

</html>