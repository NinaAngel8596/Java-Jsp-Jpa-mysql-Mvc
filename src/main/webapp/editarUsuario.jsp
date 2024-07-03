<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h1>Edit Usuarios</h1>
<p>Este es el apartado para modificar a los usuarios</p>
<% Usuario usu=(Usuario) request.getSession().getAttribute("usuEditar"); %>
<form class="user" action="SvEditUsuarios" method="POST">
    <div class="form-group col">
        <input type="hidden" name="tipo" value="usuario">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreusuario"
                   placeholder="Ingrese su Nombre" name="nombreusuario" value="<%=usu.getNombreUsuario() %>">
        </div>
        
       
         <div class="col-sm-6 mb-3">
             <input type="password" class="form-control form-control-user" id="contrasenia"
                    placeholder="Ingrese su clave" name="contrasenia" value="<%=usu.getContrasenia() %>">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol"
                   placeholder="Rol" name="rol" value="<%=usu.getRol() %>">
        </div>
         
        <!-- Aca va ir lo restante de atributos de odontologo -->
       
    </div>
    
    
    <button type="submit"class="btn btn-primary btn-user btn-block">
        Guardar Modificacion
    </button>
    <hr>
    
</form>

<%@include file="components/bodyFinal.jsp" %>
