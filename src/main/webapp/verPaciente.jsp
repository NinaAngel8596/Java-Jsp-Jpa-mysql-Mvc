<%@page import="logica.Paciente"%>
<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tabla Paciente</h1>
    
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Ver Pacientes</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>Teléfono</th>
                            <th>Dirección</th>
                            <th>Tipo de sangre</th>
                            <th>Fecha de Nacimiento</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>Teléfono</th>
                            <th>Dirección</th>
                            <th>Especialidad</th>
                            <th>Fecha de Nacimiento</th>
                            <th>Acción</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%
                            List<Paciente> listaPacientes = (List) request.getSession().getAttribute("listaPaciente");
                            if (listaPacientes != null) {
                                for (Paciente paciente:listaPacientes) {
                        %>
                        <tr>
                            <td><%= paciente.getId() %></td>
                            <td><%= paciente.getNombre() %></td>
                            <td><%= paciente.getApellido() %></td>
                            <td><%= paciente.getDni() %></td>
                            <td><%= paciente.getTelefono() %></td>
                            <td><%= paciente.getDireccion() %></td>
                            <td><%= paciente.getTipoSangre() %></td>
                            <td><%= paciente.getFecha_nac() %></td>
                            <td Style="display: flex;width: 230px">
                               <form name="eliminar" action="SvElimUsuarios" method="POST">
                                            <input type="hidden" name="tipo" value="paciente">
                                            <input type="hidden" name="id" value="<%=paciente.getId() %>">
                                            <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px;">
                                                <i class="fas fa-trash-alt"></i>Eliminar
                                            </button>
                                </form>
                               
                               <form name="editar" action="SvEditOdonto" method="GET">
                                           <input type="hidden" name="tipo" value="paciente">
                                            <input type="hidden" name="id" value="<%=paciente.getId() %>">     
                                            <button type="submit" class="btn  btn-primary btn-user btn-block" style="margin-left: 5px ">
                                                <i class="fas fa-pencil-alt"></i>Editar 
                                            </button>
                                </form>
                                
                            </td>
                            
                        </tr>
                        <%
                                }
                            } else {
                        %>
                        <tr>
                            <td colspan="9">No se encontraron odontólogos. ni m..</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="components/bodyFinal.jsp" %>
