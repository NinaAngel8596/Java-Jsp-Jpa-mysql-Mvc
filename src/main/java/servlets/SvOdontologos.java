
package servlets;

import com.google.protobuf.TextFormat;
import java.io.IOException;
import java.io.PrintWriter; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
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
import logica.Odontologo;

@WebServlet(name = "SvOdontologos", urlPatterns = {"/SvOdontologos"})
public class SvOdontologos extends HttpServlet {
    Controladora control=new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Creaer el una list con el objeto en mencion
        List <Odontologo> listaOdonto=new ArrayList< >();
        //creo el medoto par enlistar mis odontologos
        System.out.println("Hola estoy desde el svOdonto");
        listaOdonto=control.getOdontologos();
        if (listaOdonto == null || listaOdonto.isEmpty()) {
            System.out.println("No se encontraron odontólogos");
        } else {
            System.out.println("Lista de odontólogos: " + listaOdonto);
        }
        
        HttpSession misession =request.getSession();
        
        misession.setAttribute("listaOdonto", listaOdonto);
        
        response.sendRedirect("verOdonto.jsp");

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //capturado  mis variables ingresadas por el hmtl
        String dni=request.getParameter("dni");
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String telefono=request.getParameter("telefono");
        String direccion=request.getParameter("direccion");
        String fechanacStr=request.getParameter("fechanac");
        String especialidad=request.getParameter("especialidad");
        //Atributi fechaNac Casteo
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        
        Date fechanac=null;
        
        try {
            fechanac=formatoFecha.parse(fechanacStr);
        } catch ( ParseException e) {
            e.printStackTrace();
        }
        
        System.out.println("Esto el svOdontoPOST");
        //Medianto el controlador creo un metodo para crear el objeto
        //del cual el obtenido sus atributos
        control.crearOdonto(dni,nombre,apellido,telefono,direccion,fechanac,especialidad);
        
        response.sendRedirect("index.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
