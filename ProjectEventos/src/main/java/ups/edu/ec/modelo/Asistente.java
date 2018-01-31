package ups.edu.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Asistente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="asi_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	
	@Column(name="asi_nombre")
	@NotEmpty
    @NotNull
    @Size(min = 4, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "No deberia contener numeros")
	private String nombre;
	

	@Column(name="asi_cedula",unique=true)
	@Size(max=10)
	private String cedula;
	
	
    @Size(min = 7, max = 12)
    @Digits(fraction = 0, integer = 12)
    @Pattern(regexp="(^$|[0-9]{10})")
	@Column(name="asi_telefono")
	private String telefono;
	
	
	
	@NotNull
	@NotEmpty
	@Email
	@Column(name="asi_email",unique=true)
	private String email;
	
	
	@Column(name="asi_direccion")
	@Size(min=4,max=25)
	private String direccion;
	
	
	@Column(name="asi_usuario",unique=true)
	@Size(min=6,max=15)
	private String usuario;
	
	
	
	@NotNull
	@NotEmpty
	@Column(name="asi_password", unique=false)
	@Size(min=6,max=15)
	private String password;

	@Column(name = "use_rol")
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




	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
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
