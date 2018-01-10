package ups.edu.ec.modelo;

import java.awt.Window.Type;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email","cedula"}))
public class Usuario implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4167955093190466454L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@NotEmpty
    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nombre;
	
	
//	@NotEmpty
//  @NotNull
	@Column(unique = true)
	private String cedula;
	

	
    @Size(min = 7, max = 12)
    @Digits(fraction = 0, integer = 12)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String telefono;
    
	
    @NotNull
    @NotEmpty
    @Email
	@Column(unique = true)
	private String email;
    
    @Size(min = 1, max = 25)
	private String direccion;
	
//    @NotNull
//    @NotEmpty
	@Column(name="usuario",unique=true)
	@Size(min=6,max=15)
	private String usuario;
	
	
	@NotEmpty
	@NotNull
	@Column(name="password",unique=false)
	@Size(min=6,max=15)
	private String password;


	private int rol;
	

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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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


	
	
	

}
