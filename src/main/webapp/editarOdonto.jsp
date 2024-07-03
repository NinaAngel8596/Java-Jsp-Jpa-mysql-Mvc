<%@page import="logica.Odontologo"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h1>Editar Odontologo</h1>
<p>Este es el apartado para modificar a los Odontologos</p>
<% Odontologo odonto = (Odontologo)request.getSession().getAttribute("odontoEditar"); %>
<form class="user" action="SvEditUsuarios" method="POST">
    <div class="form-group col">
        <input type="hidden" name="tipo" value="odonto">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni"
                   placeholder="Ingrese su dni" name="dni" value="<%=odonto.getDni() %>">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre"
                   placeholder="Ingrese su nombre" name="nombre" value="<%=odonto.getNombre()%>" >
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido"
                   placeholder="Ingrese su apellido" name="apellido" value="<%=odonto.getApellido() %>">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono"
                   placeholder="Ingrese su telefono" name="telefono" value="<%=odonto.getTelefono() %>">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion"
                   placeholder="Ingrese su direccion" name="direccion" value="<%=odonto.getDireccion() %>">
        </div>
         <div class="col-sm-6 mb-3">
             <input type="date" class="form-control form-control-user" id="fechanac"
                   placeholder="Fecha Nac" name="fechanac" value="<%=odonto.getFecha_nac() %>">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad"
                   placeholder="Ingrese su especialidad" name="especialidad" value="<%=odonto.getEspecialidad() %>">
        </div>
        
        <!<!-- Aca va ir lo restante de atributos de odontologo -->
       
    </div>
    
    
    <button type="submit"class="btn btn-primary btn-user btn-block">
        Editar Odontologo
    </button>
    
    <hr>
    
</form>

<%@include file="components/bodyFinal.jsp" %>
