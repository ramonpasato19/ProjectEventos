package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Parroquia;

@Stateless
public class ParroquiaDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Parroquia par) {
		Parroquia aux = leer(par.getCodigo());
		if(aux!=null){
			actualizar(par);
		}else {
			insertar(par);
		}
		
	}
	
	public void insertar (Parroquia par) {
		
		em.persist(par);
	}
	
	public void actualizar (Parroquia par) {
		
		em.merge(par);
	}
	
	public Parroquia leer(int id) {
		
		Parroquia par = em.find(Parroquia.class, id);
		
		return par;
	}

	
	public void eliminar(int id) {
		Parroquia par = leer(id);
	
		em.remove(par);
	}
	
	
	
	public List<Parroquia> listadoParroquias(){
		Query query = em.createQuery("SELECT par FROM Parroquia par", Parroquia.class);
		List<Parroquia> listado=query.getResultList();
		return listado;
	}


}
