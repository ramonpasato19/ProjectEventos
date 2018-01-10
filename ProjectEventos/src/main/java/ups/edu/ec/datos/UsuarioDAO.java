package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Asistente;
import ups.edu.ec.modelo.Usuario;

@Stateless
public class UsuarioDAO extends BaseDAO<Usuario> {
	
	@Inject
	private EntityManager em1;
	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	
	
	
	public List<Asistente> getUsuariosLogin(String correo,String clave){
		
		
		String sql = "SELECT u FROM Usuario u "
				+ "WHERE correo = ? "
				+" AND clave = ?";
	
	Query q = em1.createQuery("SELECT u FROM Asistente u WHERE asi_email = ?  AND asi_password = ?",Asistente.class);
	q.setParameter(1, correo);
	q.setParameter(2, clave);
	
	List<Asistente> personas = q.getResultList();
	return personas;
	
	}
	

}
