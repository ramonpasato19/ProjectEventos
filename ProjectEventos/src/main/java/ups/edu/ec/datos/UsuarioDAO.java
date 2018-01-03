package ups.edu.ec.datos;

import javax.ejb.Stateless;

import ups.edu.ec.modelo.Usuario;

@Stateless
public class UsuarioDAO extends BaseDAO<Usuario> {
	public UsuarioDAO() {
		super(Usuario.class);
	}
	

}
