<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tabla Odontologos</h1>
    
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Ver Usuarios</h6>
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
                            <th>Especialidad</th>
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
                            List<Odontologo> listaOdonto = (List<Odontologo>) request.getSession().getAttribute("listaOdonto");
                            if (listaOdonto != null) {
                                for (Odontologo odonto : listaOdonto) {
                        %>
                        <tr>
                            <td><%= odonto.getId() %></td>
                            <td><%= odonto.getNombre() %></td>
                            <td><%= odonto.getApellido() %></td>
                            <td><%= odonto.getDni() %></td>
                            <td><%= odonto.getTelefono() %></td>
                            <td><%= odonto.getDireccion() %></td>
                            <td><%= odonto.getEspecialidad() %></td>
                            <td><%= odonto.getFecha_nac() %></td>
                            <td Style="display: flex;width: 230px">
                               <form name="eliminar" action="SvElimUsuarios" method="POST">
                                            <input type="hidden" name="tipo" value="odonto">
                                            <input type="hidden" name="id" value="<%=odonto.getId() %>">
                                            <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px;">
                                                <i class="fas fa-trash-alt"></i>Eliminar
                                            </button>
                                </form>
                               
                               <form name="editar" action="SvEditUsuarios" method="GET">
                                           <input type="hidden" name="tipo" value="odonto">
                                            <input type="hidden" name="id" value="<%=odonto.getId() %>">     
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
