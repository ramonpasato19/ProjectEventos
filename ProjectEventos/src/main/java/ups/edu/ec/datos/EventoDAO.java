package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Evento;



@Stateless
public class EventoDAO {
	
	@Inject
	private EntityManager em;

	public void guardar(Evento eve) {
		Evento aux = leer(eve.getCodigo());
		if(aux!=null){
			actualizar(eve);
		}else {
			insertar(eve);
		}
		
	}

	
public void insertar(Evento eve) {
		
		em.persist(eve);
	}
	
	public void actualizar (Evento eve) {
		
		em.merge(eve);
	}
	
	public Evento leer(int id) {
		
		
		Evento eve = em.find(Evento.class, id);
		
		return eve;
	}
	
	public void borrar (int id) {
		
		Evento eve = leer(id);
		
		em.remove(eve);
	}
	
	
	public List<Evento> listadoEventos(){
		Query query = em.createQuery("SELECT eve FROM Evento eve", Evento.class);
		List<Evento> listado=query.getResultList();
		return listado;
	}
	
}

