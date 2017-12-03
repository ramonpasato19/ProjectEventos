package ups.edu.ec.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
	

	@Id
	@Column(name="per_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="per_cedula", length=10)
	@Size(max=10)
	private String cedula;
	
	@Column(name="per_nombre")
	@Size()
	private String nombre;
	
	@Column(name="per_telefono")
	private String telefono;
	
	@Column(name="per_direccion")
	private String direccion;
	
	@Column(name="per_usuario")
	private String usuario;
	
	@Column(name="per_password")
	private String password;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", usuario=" + usuario + ", password=" + password + "]";
	}

}
