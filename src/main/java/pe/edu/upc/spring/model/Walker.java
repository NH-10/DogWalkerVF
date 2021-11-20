package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Walker")
public class Walker implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idWalker;

	@NotEmpty(message = "Ingrese su nombre")
	@Column(name = "firstNames", length = 150, nullable = false)
	private String firstNames;

	@NotEmpty(message = "Ingrese su apellido")
	@Column(name = "lastNames", length = 150, nullable = false)
	private String lastNames;

	@NotEmpty(message = "Ingrese su correo")
	@Email (message = "Ingrese el correo electrónico correcto")
	@Column(name = "email", length = 60, nullable = false)
	private String email;

	@Column(name = "password", length = 200, nullable = false)
	private String password;

	@NotNull(message = "Ingrese su fecha de nacimiento")
	@Past(message = "Fecha de nacimiento incorrecta")
	@Temporal(TemporalType.DATE)
	@Column(name = "dateOfBirth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@NotEmpty(message = "Ingrese su descripción")
	@Column(name = "description", length = 255, nullable = false)
	private String description;


	@DecimalMin(value = "0.1", inclusive = false , message = "Ingrese el costo de servicio por hora")
	@Column(name = "costService", nullable = false)
	private double costService;

	@NotEmpty(message = "Ingrese su dirección")
	@Column(name = "address", length = 255, nullable = false)
	private String address;

	@ManyToOne
	@JoinColumn(name = "idPersonality", nullable = false)
	private Personality personality;

	@ManyToOne
	@JoinColumn(name = "idDistrict", nullable = false)
	private District district;

	public Walker() {
		super();
	}

	public Walker(int idWalker, String firstNames, String lastNames, String email, String password, Date dateOfBirth,
			String biography, String description, double costService, String address, Personality personality,
			District district) {
		super();
		this.idWalker = idWalker;
		this.firstNames = firstNames;
		this.lastNames = lastNames;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		this.costService = costService;
		this.address = address;
		this.personality = personality;
		this.district = district;
	}

	public int getIdWalker() {
		return idWalker;
	}

	public void setIdWalker(int idWalker) {
		this.idWalker = idWalker;
	}

	public String getFirstNames() {
		return firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCostService() {
		return costService;
	}

	public void setCostService(double costService) {
		this.costService = costService;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Personality getPersonality() {
		return personality;
	}

	public void setPersonality(Personality personality) {
		this.personality = personality;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

}
