
package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Odontologo;
import logica.Paciente;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class CtrlPersistencia {

     
    //Creo los Objeto que llamaran alos JPA que tienen comunicacion con la persistecnia
    //en metodos crear delelte find etc
    HorarioJpaController horaJPA=new HorarioJpaController();
    OdontologoJpaController odontoJPA=new OdontologoJpaController();
    PacienteJpaController pacJPA= new PacienteJpaController();
    PersonaJpaController persJPA=new PersonaJpaController();
    ResponsableJpaController resJPA = new ResponsableJpaController();
    SecretarioJpaController secreJPA = new SecretarioJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();

    public void crearUsuario(Usuario usu) {
        usuJPA.create(usu);
    }

    public List<Usuario> getUsuarios() {
        return usuJPA.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CtrlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        return usuJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(CtrlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearOdonto(Odontologo odonto) {
        odontoJPA.create(odonto);
    }

    public List<Odontologo> getOdontologos() {
        return odontoJPA.findOdontologoEntities();
    }

    public void borrarOdonto(int id_Odonto) {
        try {
            odontoJPA.destroy(id_Odonto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CtrlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearPaciente(Paciente paciente) {
        pacJPA.create(paciente);
    }

    public List<Paciente> getPacientes() {
       return pacJPA.findPacienteEntities();
    }

    public void borrarPaciente(int id_paciente) {
        try {
            pacJPA.destroy(id_paciente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CtrlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Odontologo traerOdonto(int id_Odonto) {
        return odontoJPA.findOdontologo(id_Odonto);
    }

    public void editarOdontologo(Odontologo odonto) {
        try {
            odontoJPA.edit(odonto);
        } catch (Exception ex) {
            Logger.getLogger(CtrlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
