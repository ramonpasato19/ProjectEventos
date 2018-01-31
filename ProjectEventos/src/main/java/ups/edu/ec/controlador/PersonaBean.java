package ups.edu.ec.controlador;

//package mx.com.gm.sga.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.RowEditEvent;
//import mx.com.gm.sga.domain.Persona;
//import mx.com.gm.sga.servicio.PersonaService;

import ups.edu.ec.datos.PersonaService;
import ups.edu.ec.modelo.Persona;

@ManagedBean
@RequestScoped
public class PersonaBean {

  @EJB
  private PersonaService personaService;

  private Persona personaSeleccionada;

  List<Persona> personas;

  public PersonaBean() {
  }

  @PostConstruct
  public void inicializar() {
      //Iniciamos las variables
      personas = personaService.findAllPersonas();
      personaSeleccionada = new Persona();
  }

  public void editListener(RowEditEvent event) {
      Persona persona = (Persona) event.getObject();
      personaService.updatePersona(persona);
  }

  public List<Persona> getPersonas() {
      return personas;
  }

  public void setPersonas(List<Persona> personas) {
      this.personas = personas;
  }

  public Persona getPersonaSeleccionada() {
      return personaSeleccionada;
  }

  public void setPersonaSeleccionada(Persona personaSeleccionada) {
      this.personaSeleccionada = personaSeleccionada;
  }
  
  public void reiniciarPersonaSeleccionada(){
      this.personaSeleccionada = new Persona();
      personaService.findAllPersonas();
  }

  public void agregarPersona() {
      personaService.insertPersona(this.personaSeleccionada);
      this.personaSeleccionada = null;
      personaService.findAllPersonas();
  }

  public void eliminarPersona() {
      personaService.deletePersona(this.personaSeleccionada);
      this.personaSeleccionada = null;
  }

}
