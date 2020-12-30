<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Información</title>
    <link rel="icon" type="image/png" href="ti.ico" />
    <link rel="stylesheet" href="hojacssdeestilos.css"/>
</head>


<body>

<P>Bienvenido: <% out.print(request.getAttribute("nousu")); %></p> <a href="cerrarsesionservlet">cerrar sesion</a>
    <div class="header">
        <h1>Plataforma de registro de Usuarios.</h1>
    </div>    
    <hr/>

<div class="row">

        <!---Menu---->    
        <div class="col-3 col-s-3 menu">
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

    




<!---Primera Seccion-->
    <div class="col-6 col-s-9 sec1">
        <h2>¿Cual es el objetivo del sistema de informacion?</h2>
        <p>
            El Sistema de Información tiene por objetivo administrar procesos involucrados en la operación 
            de la empresa, junto con las capacitaciones y los pagos de clientes, de tal manera de que se 
            pueda obtener datos de cada uno de los flujos de la empresa y transformarlos en información clara, 
            concisa y cuantitativa. Lo que nos permitirá conocer con certeza el Key Performance Indicator 
            (KPI) clave para la toma de decisiones en cualquier punto de la operación y así poder aumentar 
            la eficiencia de la organización.
        </p>
    </div>

<!---Segunda Seccion-->
    <div class="col-6 col-s-12 sec2">
        <div class="tableSec2">
        <table id="tableSec2">
            <tr>
                <td>
        
                    <h2>¿Para quiénes destinado su uso?</h2>
                        <p>
                            Este sistema está desarrollado para los clientes, pero además considera los usuarios internos de 
                            cada empresa, tanto administrativos como profesionales. Porque entendemos la importancia del manejo 
                            de la información a nivel interno como externo. De una forma simple pero con la capacidad de administrar 
                            todos los recursos relacionados con la empresa.
                        </p>
                 </td>
            </tr>
        

        </table>
		</div>
        
    </div>
<!---Tercera Seccion-->
    <div class="col-12 col-s-12 menu2">
        <h2>¿Qué procesos considera la plataforma actualmente?</h2>

                
                   <h4> Los procesos que considera la plataforma actualmente son:</h4>
                        <ul>
                         <li>Registro de usuarios en todas sus combinaciones:</li>
                             
                           <li>Registro de Clientes con sus respectivos campos.</li>
                                 
                                 <li>Registro de Profesionales con sus respectivos campos.</li>
                             
                                 <li>Registro de Adminsitrativos con sus respectivos campos.</li>
                             
                             
                         <li>Registro de las capacitaciones realizadas por los distintos Profesioanles</li>
                         <li>Eliminar perfiles de Usuario de los distintos tipo</li>
                         <li>Ver la información de usuarios de los distontos perfiles y las capacitaciones</li>

                        </ul>
      
    </div>
    

</div>

<!----pie de pagina--->
<footer>
    <p class="pie">Information System &copy; 2020</p>
</footer>

</body>
</html>