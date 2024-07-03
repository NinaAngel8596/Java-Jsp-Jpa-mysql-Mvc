
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    
    Controladora control=new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    //el metodo DO es para procesar los datos a enviar ala bd
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       List <Usuario> listaUsuario= new ArrayList<>();
        System.out.println("Hola estoy desde el svUsuarios");
       listaUsuario=control.getUsuarios();
       System.out.println("Lista de usuarios: " + listaUsuario);
       
        HttpSession misession =request.getSession();
        misession.setAttribute("listaUsuario", listaUsuario);
        
        
        response.sendRedirect("verUsuarios.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
         //capturo lo ingresado por mi html 
        String nombre=request.getParameter("nombreusuario");
        String contrasenia=request.getParameter("contrasenia");
        String rol=request.getParameter("rol");
        //Cual va a ser el objeto del cual estoy obteniendode mi html?
        control.crearUsario(nombre,contrasenia,rol);
        System.out.println("Estoy en svUsuariosPOST");
        response.sendRedirect("index.jsp");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
