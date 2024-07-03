<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h1>Altas Pacientes</h1>
<form class="user" action="SvPaciente" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni"
                   placeholder="Ingrese su dni" name="dni">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre"
                   placeholder="Ingrese su nombre" name="nombre">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido"
                   placeholder="Ingrese su apellido" name="apellido">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono"
                   placeholder="Ingrese su telefono" name="telefono">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion"
                   placeholder="Ingrese su direccion" name="direccion">
        </div>
         <div class="col-sm-6 mb-3">
             <input type="date" class="form-control form-control-user" id="fechanac"
                   placeholder="Fecha Nac" name="fechanac">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="String" class="form-control form-control-user" id="tipoSangre"
                   placeholder="Tipo Sangre" name="tipoSangre">
        </div>
        
        <!<!-- Aca va ir lo restante de atributos de odontologo -->
       
    </div>
    
    
    <button type="submit"class="btn btn-primary btn-user btn-block">
        Crear Paciente
    </button>
    
    <hr>
    
</form>

<%@include file="components/bodyFinal.jsp" %>
