<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h1>Altas Usuarios</h1>
<p>Este es el apartado para dar de alta a los usuarios</p>
<form class="user" action="SvUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreusuario"
                   placeholder="Ingrese su Nombre" name="nombreusuario">
        </div>
        
       
         <div class="col-sm-6 mb-3">
             <input type="password" class="form-control form-control-user" id="contrasenia"
                   placeholder="Ingrese su clave" name="contrasenia">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol"
                   placeholder="Rol" name="rol">
        </div>
         
        <!-- Aca va ir lo restante de atributos de odontologo -->
       
    </div>
    
    
    <button type="submit"class="btn btn-primary btn-user btn-block">
        Crear Usuario
    </button>
    <hr>
    
</form>

<%@include file="components/bodyFinal.jsp" %>
