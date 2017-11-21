package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.ec.modelo.Persona;

@Stateless
public class PersonaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(Persona p) {
		em.persist(p);
	}
	
	public void actualizar(Persona p) {
		
		em.merge(p);
	}
	
	public Persona leer(int id) {
		
		Persona p = em.find(Persona.class, id);
		
		return p;
	}
	
	public void borrar (int id) {
		
		Persona p = leer(id);
		
		em.remove(p);
		
	}
	
	
	

}
