<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contacto</title>
    <link rel="stylesheet" href="hojacssdeestilos.css" />
    <link rel="icon" type="image/png"
        href="C:\Users\juani\Documents\JAVA desarrollo web\modulo 3 desarrollo web\Clase 1\Ejercicio grupal 1\ti.ico" />
    <link rel="stylesheet" href="hojacssdeestilos.css" />
</head>

<body>

<p>Sesion de Usuario: "${nombresesion}" </p>  <a href="cerrarsesionservlet">cerrar sesion</a>
    <div class="header">
        <h1>Plataforma de Registro</h1>
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

    <!----Registro de usuarios formulario--->

    <div class="row col-9 col-s-9" id="tableRegistro">
        
        
        <form method="post" action="contactoservlet">
            <h2>Contacto</h2>
            <table>

                <tr>

                    <td><label for="nombre">Nombre:</label></td>
                    <td><input type="text" name="nombre" placeholder="Escriba su nombre..." /></td>
                </tr>

                <tr>
                    <td><label for="apellidop">Apellido Paterno:</label></td>
                    <td><input type="text" name="apellidop" placeholder="Escriba su apellido Paterno..." /></td>

                <tr>
                    <td><label for="apellidom">Apellido Materno:</label></td>
                    <td><input type="text" name="apellidom" placeholder="Escriba su apellido Materno..." /></td>
                </tr>

                <tr>
                    <td><label for="email">Correo Electronico:</label></td>
                    <td><input type="email" name="email" id="email" placeholder="Escriba su correo electronico..."
                            required /></td>
                </tr>

                <tr>
                    <td><label for="mensaje">Mensaje</label></td>
                    <td><textarea name="mensaje" name="mensaje" placeholder="Escribe tu Sugerencia aca..."
                            maxlength="100"></textarea></td>
                </tr>

                <tr>
                    <td><label for="tipo">Tipo de Usuario</label><br></td>
                    <td> <select name="tipo">
                            <option value="cliente">Cliente</option>
                            <option value="profesional">Profesional</option>
                            <option value="administrativo">Administrativo</option>
                        </select></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Registrar usuario" /></td>
                </tr>
            </table>
        </form>

    </div>



</body>

</html>