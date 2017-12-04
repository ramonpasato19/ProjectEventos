package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import ups.edu.ec.datos.SectorDAO;
import ups.edu.ec.modelo.Sector;

@ManagedBean
public class SectorControlador {

	private SectorDAO secdao;
	private Sector sector;
	private List<Sector> sectores;
	
	@PostConstruct
	public void init() {
		sector = new Sector();
		loadSectores();
		
	}
		
	public SectorDAO getSecdao() {
		return secdao;
	}
	public void setSecdao(SectorDAO secdao) {
		this.secdao = secdao;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public List<Sector> getSectores() {
		return sectores;
	}
	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
	
	public void loadSectores() {
		sectores = secdao.listadoSectores();
		
	}
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de personas a editar" + id);
		sector = secdao.leer(id);
		return "crear-sector";
	}
	
	public String guardar() {
		System.out.println(sector);
		secdao.guardar(sector);
		loadSectores();
		return "listado-sectores";
	}
	
	public String borrar(int id) {
		secdao.borrar(id);
		loadSectores();
		return "listado-sectores";
	}
}

