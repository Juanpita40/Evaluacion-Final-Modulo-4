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
        
        <form method="post" action="Editaradministrativoservlet">
            <h2>Editar Administrativo</h2>
            <table>
            	 <tr>
                    <td><label for="rut">RUT DEL ADMINISTRATIVO: </label></td>
                    <td><input type="text" name="rut" readonly="readonly" value="<c:out value="${admi.getRun()}"/>"/></td>
                </tr>

                <tr>

                    <td><label for="nombre">NOMBRE: </label></td>
                    <td><input type="text" name="nombre" value="<c:out value="${admi.getNombre()}"/>" /></td>
                </tr>

                <tr>
                    <td><label for="apellidos">APELLIDOS: </label></td>
                    <td> <input type="text" name="apellidos" value="<c:out value="${admi.getApellidos()}"/>" /></td>
                </tr>
                <tr>
                    <td><label for="correo">CORREO: </label></td>
                    <td><input type="text" name="correo" value="<c:out value="${admi.getCorreo()}"/>" /></td>
                </tr>
                <tr>
                    <td><label for="area">AREA: </label></td>
                    <td><input type="text" name="area" value="<c:out value="${admi.getArea()}"/>" /></td>
                </tr>

  
                <tr>
                    <td><input type="submit" value="Editar Administrativo" /></td>
                    <td><input type="reset" value="Limpiar Formulario" /></td>
                </tr>
                
              </table>
        </form>
        
        
        <a href="${pageContext.request.contextPath}/Administrativoservlet">Volver al listado de Administrativo</a>
        
        
    </div>




</body>

</html>