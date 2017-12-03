package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.ietf.jgss.GSSContext;

import ups.edu.ec.modelo.Gastronomia;

@Stateless
public class GastronomiaDAO {
	
	@Inject
	private EntityManager em;
	
	
	public void guardar(Gastronomia gas) {
		Gastronomia aux = leer(gas.getCodigo());
		if(aux!=null){
			actualizar(gas);
		}else {
			insertar(gas);
		}
		
	}

	
	public void insertar(Gastronomia gas) {
		
		em.persist(gas);
	}
	
	public void actualizar (Gastronomia gas) {
		
		em.merge(gas);
	}
	
	public Gastronomia leer(int id) {
		
		Gastronomia gas = em.find(Gastronomia.class, id);
		
		return gas;
	}
	
	public void borrar (int id) {
		
		Gastronomia gas = leer(id);
		
		em.remove(gas);
	}
	
	
	public List<Gastronomia> listadoGastronomias(){
		Query query = em.createQuery("SELECT gas FROM Gastronomia gas", Gastronomia.class);
		List<Gastronomia> listado=query.getResultList();
		return listado;
	}
	
	

}
