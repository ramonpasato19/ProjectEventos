package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.datos.SectorDAO;
import ups.edu.ec.modelo.Parroquia;
import ups.edu.ec.modelo.Sector;

@ManagedBean
@ViewScoped
public class SectorControlador {
	@Inject
	private SectorDAO secdao;
	private Sector sector;
	private List<Sector> sectores;
	
	private int id;
	
	@PostConstruct
	public void init() {
		sector = new Sector();
		sector.addParroquia(new Parroquia());
		//loadSectores();
		
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
		if(sectores==null)
			loadSectores();
		return sectores;
	}
	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
	
	
	public void leerSector(int codigo) {
		sector=secdao.leer(codigo);
		System.out.println("cargando datos de sector"+ sector);
	}
	public void loadSectores() {
		sectores = secdao.listadoSectores();
		
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de sectores a editar" + id);
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
	
	
	public String addParroquia() {
		sector.addParroquia(new Parroquia());
		return null;
		}
}

