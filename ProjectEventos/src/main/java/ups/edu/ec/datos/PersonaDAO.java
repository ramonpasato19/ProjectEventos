package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.ec.modelo.Persona;

@Stateless
public class PersonaDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Persona per) {
		Persona aux = leer(per.getCodigo());
		if(aux!=null){
			actualizar(per);
		}else {
			insertar(per);
		}
		
	}
	
	public void insertar(Persona per) {
		em.persist(per);
	}
	
	public void actualizar(Persona per) {
		
		em.merge(per);
	}
	
	public Persona leer(int id) {
		
		Persona per = em.find(Persona.class, id);
		
		return per;
	}
	
	public void borrar (int id) {
		
		Persona per = leer(id);
		
		em.remove(per);
		
	}
	
	
	public List<Persona> listadoPersonas(){
		Query query = em.createQuery("SELECT per FROM Persona per", Persona.class);
		List<Persona> listado=query.getResultList();
		return listado;
	}

}
