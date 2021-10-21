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
@Table(name="ServiceRequest")
public class ServiceRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServiceRequest;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Column(name="totalServiceCost", nullable=false)
	private double totalServiceCost;
	
	@Column(name="startTime", length=20, nullable=false)
	private String startTime;

	@Column(name="timeLimit", length=20, nullable=false)
	private String timeLimit;

	@ManyToOne
	@JoinColumn(name="idState", nullable = false)
	private State state;
	
	@ManyToOne
	@JoinColumn(name="idTime", nullable = false)
	private Time time;

	@ManyToOne
	@JoinColumn(name="idOwner", nullable = false)
	private Owner owner;
	
	@ManyToOne
	@JoinColumn(name="idWalker", nullable = false)
	private Walker walker;

	public ServiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceRequest(int idServiceRequest, Date date, double totalServiceCost, String startTime, String timeLimit,
			State state, Time time, Owner owner, Walker walker) {
		super();
		this.idServiceRequest = idServiceRequest;
		this.date = date;
		this.totalServiceCost = totalServiceCost;
		this.startTime = startTime;
		this.timeLimit = timeLimit;
		this.state = state;
		this.time = time;
		this.owner = owner;
		this.walker = walker;
	}

	public int getIdServiceRequest() {
		return idServiceRequest;
	}

	public void setIdServiceRequest(int idServiceRequest) {
		this.idServiceRequest = idServiceRequest;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalServiceCost() {
		return totalServiceCost;
	}

	public void setTotalServiceCost(double totalServiceCost) {
		this.totalServiceCost = totalServiceCost;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Walker getWalker() {
		return walker;
	}

	public void setWalker(Walker walker) {
		this.walker = walker;
	}
	
}
