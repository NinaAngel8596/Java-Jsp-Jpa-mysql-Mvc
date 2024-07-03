
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;

@WebServlet(name = "SvElimUsuarios", urlPatterns = {"/SvElimUsuarios"})
public class SvElimUsuarios extends HttpServlet {
     Controladora control =new Controladora();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    String tipo = request.getParameter("tipo");
    System.out.println("Estas en el postsvusu con tipo: " + tipo);
    if(tipo != null){
        if(tipo.equals("usuario")){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("Eliminando usuario con id: " + id);
            control.borrarUsuario(id);
            response.sendRedirect("SvUsuarios");
        } 
        
        else if(tipo.equals("odonto")){
            int id_Odonto = Integer.parseInt(request.getParameter("id"));
            System.out.println("Eliminando odontólogo con id: " + id_Odonto);
            control.borrarOdonto(id_Odonto);
            response.sendRedirect("SvOdontologos");
        }
        
        else if(tipo.equals("paciente")){
            int id_paciente=Integer.parseInt(request.getParameter("id"));
            System.out.println("Eliminando paciente con id: " + id_paciente);            control.borrarPaciente(id_paciente);
            response.sendRedirect("SvPaciente");
        }
    }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
