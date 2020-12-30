<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuario</title>
    <link rel="icon" type="image/png" href="ti.ico" />
    <link rel="stylesheet" href="hojacssdeestilos.css"/>
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

   

   <form method="post" action="Derivaratiposervlet">
    <h2>Crear Usuario</h2>
  
       <p>
        <label for="tipo">Tipo de usuario</label> <br/>
        <select name="tipo">
            <option value="cliente">Cliente</option>
            <option value="profesional">Profesional</option>
            <option value="administrativo">Administrativo</option>
        </select>
        </p>
       <input type="submit" value="Ir a creacion de Usuario"/>
       <input type="reset" value="Limpiar Formulario"/>

   </form>
</div>

    
</body>
</html>