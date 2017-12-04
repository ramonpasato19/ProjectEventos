package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Categoria;

@Stateless
public class CategoriaDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Categoria cat) {
		Categoria aux = leer(cat.getCodigo());
		if(aux!=null){
			actualizar(cat);
		}else {
			insertar(cat);
		}
		
	}
	public void insertar (Categoria cat) {
		
		em.persist(cat);
		
	}
	
	public void actualizar (Categoria cat) {
		em.merge(cat);
	}
	
	public Categoria leer (int id) {
		
		Categoria cat = em.find(Categoria.class, id);
		
		return cat;
	}
	
	public void borrar (int id) {
		Categoria cat = leer(id);
		
		em.remove(cat);
	}
	
	public List<Categoria> listadoCategorias(){
		Query query = em.createQuery("SELECT cat FROM Categoria cat", Categoria.class);
		List<Categoria> listado=query.getResultList();
		return listado;
	}

}
