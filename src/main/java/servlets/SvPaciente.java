
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Paciente;

/**
 *
 * @author ADMI
 */
@WebServlet(name = "SvPaciente", urlPatterns = {"/SvPaciente"})
public class SvPaciente extends HttpServlet {

    Controladora control =new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //creo mi objeto paciente de tipo lista
        
        List<Paciente> listaPaciente = new ArrayList<>() ;
        //almaceno mi lista que jalara de la persistencia
        listaPaciente=control.getListaPacientes();
        
        HttpSession misession=request.getSession();
        misession.setAttribute("listaPaciente",listaPaciente );
        
        response.sendRedirect("verPaciente.jsp");
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //es donde se hara la alta del objeto
        System.out.println("Estoy en svOdontoPOST");

        String dni=request.getParameter("dni");
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String telefono =request.getParameter("telefono");
        String direccion=request.getParameter("direccion");
        String fechanacStr=request.getParameter("fechanac");
        String tipoSangre=request.getParameter("tipoSangre");
        //casteo del fecha Ya que es date pero el jsp lo entrega como string
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        Date fechanac=null;
        
        try {
            fechanac=formatoFecha.parse(fechanacStr);
        } catch ( ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Estoy en svOdontoPOST");
        control.crearPaciente(nombre,apellido,dni,direccion,telefono,fechanac,tipoSangre);
        response.sendRedirect("index.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
