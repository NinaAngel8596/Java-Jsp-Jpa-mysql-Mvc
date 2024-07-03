
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Odontologo;
import logica.Usuario;

@WebServlet(name = "SvEditUsuarios", urlPatterns = {"/SvEditUsuarios"})
public class SvEditUsuarios extends HttpServlet {
    Controladora control=new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       String tipo=request.getParameter("tipo");
       
       if(tipo!=null){
           if(tipo.equals("usuario")){
                int id=Integer.parseInt(request.getParameter("id"));
                 Usuario usu=control.TraerUsuario(id);
                 HttpSession misession=request.getSession();
                 misession.setAttribute("usuEditar", usu);
                 System.out.println("El usuario es:"+usu.getNombreUsuario());
                 response.sendRedirect("editarUsuario.jsp");

           }
           else if(tipo.equals("odonto")){
                 int id_Odonto = Integer.parseInt(request.getParameter("id"));
                 Odontologo odonto=control.TraerOdonto(id_Odonto);
                 HttpSession misession=request.getSession();
                 misession.setAttribute("odontoEditar", odonto);
                 System.out.println("El usuario es:"+odonto.getNombre());
                 response.sendRedirect("editarOdonto.jsp");
           }
       }
        
      
       
      
        
       
       
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipo=request.getParameter("tipo");
        
        if(tipo!=null){
            if(tipo.equals("usuario")){
                String nombreUsu=request.getParameter("nombreusuario");
                String contrasenia=request.getParameter("contrasenia");
                String rol=request.getParameter("rol");

                Usuario usu= (Usuario) request.getSession().getAttribute("usuEditar");

                usu.setNombreUsuario(nombreUsu);
                usu.setContrasenia(contrasenia);
                usu.setRol(rol);

                control.editarUsuario(usu);

                response.sendRedirect("SvUsuarios");
            }
            else if(tipo.equals("odonto")){
                System.out.println("Estoy en edit odonto");
                String dni=request.getParameter("dni");
                String nombre=request.getParameter("nombre");
                String apellido=request.getParameter("apellido");
                String telefono=request.getParameter("telefono");
                String direccion=request.getParameter("direccion");
                String fechanacStr=request.getParameter("fechanac");
                
                SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        
                Date fechanac=null;

                try {
                    fechanac=formatoFecha.parse(fechanacStr);
                } catch ( ParseException e) {
                    e.printStackTrace();
                }
                //setear el objeto
                
                Odontologo odonto= (Odontologo)request.getSession().getAttribute("odontoEditar");
                
                odonto.setDni(dni);
                odonto.setNombre(nombre);
                odonto.setApellido(apellido);
                odonto.setTelefono(telefono);
                odonto.setDireccion(direccion);
                odonto.setFecha_nac(fechanac);
                
                control.editarOdontologo(odonto);
                
                response.sendRedirect("SvOdontologos");
                
            }
        }
        
        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
