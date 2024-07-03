
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.CtrlPersistencia;

public class Controladora {
    CtrlPersistencia controlPersis=new CtrlPersistencia();

    public void crearUsario(String nombre, String contrasenia, String rol) {
         Usuario usu=new Usuario();
         usu.setNombreUsuario(nombre);
         usu.setContrasenia(contrasenia);
         usu.setRol(rol);
         
         controlPersis.crearUsuario(usu);
    }

    public List<Usuario> getUsuarios() {
        
        return controlPersis.getUsuarios();
    }

    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }

    public Usuario TraerUsuario(int id) {
        return  controlPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }

    
    public void crearOdonto(String dni, String nombre, String apellido, 
        String telefono, String direccion, Date fechanac, 
        String especialidad) {
        Odontologo odonto = new Odontologo();
        
        odonto.setDni(dni);
        odonto.setNombre(nombre);
        odonto.setApellido(apellido);
        odonto.setTelefono(telefono);
        odonto.setDireccion(direccion);
        odonto.setFecha_nac(fechanac);
        odonto.setEspecialidad(especialidad);
        
        controlPersis.crearOdonto(odonto);
        
    }

    public List<Odontologo> getOdontologos() {
        return controlPersis.getOdontologos();
    }

    public void borrarOdonto(int id_Odonto) {
        controlPersis.borrarOdonto(id_Odonto);
    }

    public void crearPaciente(String nombre, String apellido, String dni, String direccion, String telefono, Date fechanac, String tipoSangre) {
        Paciente paciente=new Paciente();
        
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setDni(dni);
        paciente.setDireccion(direccion);
        paciente.setTelefono(telefono);
        paciente.setFecha_nac(fechanac);
        paciente.setTipoSangre(tipoSangre);
                
        controlPersis.crearPaciente(paciente);
    }

    public List<Paciente> getListaPacientes() {
        return  controlPersis.getPacientes();
    }

    public void borrarPaciente(int id_paciente) {
        controlPersis.borrarPaciente(id_paciente);
    }

    public Odontologo TraerOdonto(int id_Odonto) {
        return controlPersis.traerOdonto(id_Odonto);
    }

    public void editarOdontologo(Odontologo odonto) {
        controlPersis.editarOdontologo(odonto);
    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {
        
        boolean ingreso=false;
        
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios=controlPersis.getUsuarios();
        
        for(Usuario usu:listaUsuarios){
            if(usu.getNombreUsuario().equals(usuario)){
                if(usu.getContrasenia().equals(contrasenia)){
                    ingreso=true;
                }else{
                    ingreso=false;
                }
            }
        }
        return ingreso;
    }


   
    
    
    
}
