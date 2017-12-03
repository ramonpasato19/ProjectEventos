package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.ec.modelo.Categoria;

@Stateless
public class CategoriaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar (Categoria c) {
		
		em.persist(c);
		
	}
	
	public void actualizar (Categoria c) {
		em.merge(c);
	}
	
	public Categoria leer (int id) {
		
		Categoria c = em.find(Categoria.class, id);
		
		return c;
	}
	
	public void borrar (int id) {
		Categoria c = leer(id);
		
		em.remove(c);
	}
	
	public List<Categoria> listadoCategorias(){
		Query query = em.createQuery("SELECT cat FROM Categoria cat", Categoria.class);
		List<Categoria> listado=query.getResultList();
		return listado;
	}

}
