package ups.edu.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@Entity
public class Asistente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="asi_id", nullable=false, unique=true)
	private int codigo;
	
	@NotNull
	@Column(name="asi_nombre")
	@Size(min=4,max=25)
	private String nombre;
	
	@NotNull
	@Column(name="asi_cedula", length=10)
	@Size(max=10)
	private String cedula;
	
	
	@NotNull
	@Column(name="asi_telefono", length=10)
	//@Size(max=10)
	private int telefono;
	
	
	
	@NotNull
	@Email
	@Column(name="asi_email")
	private String email;
	
	@NotNull
	@Column(name="asi_direccion")
	@Size(min=4,max=25)
	private String direccion;
	
	
	@NotNull
	@Column(name="asi_usuario",nullable=false, unique=true)
	@Size(min=6,max=15)
	private String usuario;
	
	
	
	@NotNull
	@Column(name="asi_password",nullable=false, unique=false)
	@Size(min=6,max=15)
	private String password;

	@Column(name = "use_rol",length = 20)
	private int rol;

	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	public int getRol() {
		return rol;
	}



	public void setRol(int rol) {
		this.rol = rol;
	}



	@Override
	public String toString() {
		return "Asistente [codigo=" + codigo + ", nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono
				+ ", email=" + email + ", direccion=" + direccion + ", usuario=" + usuario + ", password=" + password
				+ ", rol=" + rol + "]";
	}




	
	
	

}
