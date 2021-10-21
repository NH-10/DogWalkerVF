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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Dog")
public class Dog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDog;
	
	@Column(name="name", length=50, nullable=false)
	private String name;

	@Column(name="description", length=200, nullable=true)
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateOfBirth")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	@ManyToOne
	@JoinColumn(name="idCharacter", nullable = false)
	private Character character;
	
	@ManyToOne
	@JoinColumn(name="idRace", nullable = false)
	private Race race;
	
	@ManyToOne
	@JoinColumn(name="idOwner", nullable = false)
	private Owner owner;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(int idDog, String name, String description, Date dateOfBirth, Character character, Race race,
			Owner owner) {
		super();
		this.idDog = idDog;
		this.name = name;
		this.description = description;
		this.dateOfBirth = dateOfBirth;
		this.character = character;
		this.race = race;
		this.owner = owner;
	}

	public int getIdDog() {
		return idDog;
	}

	public void setIdDog(int idDog) {
		this.idDog = idDog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	

}
