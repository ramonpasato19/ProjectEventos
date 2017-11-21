package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class ParroquiaDAO {
	
	@Inject
	private EntityManager em;



}
