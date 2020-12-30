<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Información</title>
    <link rel="icon" type="image/png"
        href="C:\Users\juani\Documents\JAVA desarrollo web\modulo 3 desarrollo web\Clase 1\Ejercicio grupal 1\ti.ico" />
    <link rel="stylesheet" href="hojacssdeestilos.css" />
</head>

<body>
    <div class="header">
        <h1>Plataforma de registro de Usuarios.</h1>
    </div>    
    <hr/>
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

    <!--formulario crear capacitacion-->
    
    <div class="col-9 col-s-9" id="tableRegistro">
        
        <form method="post" action="Editarcapacitacionservlet">
            <h2>Editar Capacitación</h2>
            <table>
            	 <tr>
                    <td><label for="idcapacitacion">IDCAPACITACION: </label></td>
                    <td><input type="text" name="idcapacitacion" readonly="readonly" value="<c:out value="${capa.getIdcapa()}"/>"/></td>
                </tr>

                <tr>

                    <td><label for="fechacapa">Fecha de capacitación: </label></td>
                    <td><input type="text" name="fechacapa" value="<c:out value="${capa.getDia()}"/>" /></td>
                </tr>

                <tr>
                    <td><label for="horacapa">Hora de Capacitación: </label></td>
                    <td> <input type="text" name="horacapa" value="<c:out value="${capa.getHora()}"/>" /></td>
                </tr>
                <tr>
                    <td><label for="lugar">Lugar: </label></td>
                    <td><input type="text" name="lugar" value="<c:out value="${capa.getLugar()}"/>" /></td>
                </tr>
                <tr>
                    <td><label for="duracion">Duración: </label></td>
                    <td><input type="text" name="duracion" value="<c:out value="${capa.getDuracion()}"/>" /></td>
                </tr>
                <tr>
                    <td><label for="cantasist">CANTIDAD DE ASISTENTES: </label></td>
                    <td><input type="text" name="cantasist" value="<c:out value="${capa.getCantasist()}"/>" /></td>
                </tr>
                
                <tr>
                    <td><label for="rut">RUT CLIENTE: </label></td>
                    <td><input type="text" name="rut" value="<c:out value="${capa.getRutclte()}"/>" /></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Editar Capacitacion" /></td>
                    <td><input type="reset" value="Limpiar Formulario" /></td>
                </tr>
                
              </table>
        </form>
        
        
        <a href="${pageContext.request.contextPath}/Capacitacionesservlet">Volver al listado de clientes</a>
        
        
    </div>




</body>

</html>