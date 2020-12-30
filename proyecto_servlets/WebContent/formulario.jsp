<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ingreso</title>
    <link rel="stylesheet" href="hojacssdeestilos.css" />
    <link rel="icon" type="image/png" href="ti.ico" />
</head>
<body>

	<div class="header">
        <h1>Plataforma de Registro</h1>
    </div> 
	
	<div class="login">
        <div class="login-screen">
           <form method="post" action="validarsesionservlet">
            <div class="app-title">
                <h1>Iniciar Sesión</h1>
            </div>

            <div class="login-form">
                <div class="control-group">
                    <input type="text" id="txtRut" name="txtRut" class="login-field" placeholder="XXXXXXXX-Y" />
                    <label class="login-field-icon fui-user" for="txtRut"></label>
                </div>

                <div class="control-group">
                    <input type="password" class="login-field" value="" placeholder="Contraseña..." id="login-pass" name="login-pass">
                    <label class="login-field-icon fui-lock" for="login-pass"></label>
                </div>
            
					<input type="submit" value="Enviar" name="btnprocesa" id="btnprocesa" /><br/>

            </div>
        </form>
        </div>
    </div>

</body>
</html>