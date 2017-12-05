package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Canton;

@Stateless
public class CantonDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Canton can) {
		Canton aux = leer(can.getCodigo());
		if(aux!=null){
			actualizar(can);
		}else {
			insertar(can);
		}
		
	}
	
	public void insertar(Canton can) {
		
		em.persist(can);
	}
	
	public void actualizar(Canton can) {
		
		em.merge(can);
		
	}
	
	public Canton leer(int id) {
		
		Canton can = em.find(Canton.class, id);
		
		return can;
		
	}
	
	public void borrar(int id) {
		
		Canton can = leer(id);
		
		em.remove(can);
		
	}
	
	public List<Canton> listadoCantones(){
		Query query = em.createQuery("SELECT can FROM Canton can", Canton.class);
		List<Canton> listado=query.getResultList();
		return listado;
		
		
	}

}
