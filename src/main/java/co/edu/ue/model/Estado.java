package co.edu.ue.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the estados database table.
 * 
 */
@Entity
@Table(name="estados")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="est_id")
	private int estId;

	@Column(name="est_descripcion")
	private String estDescripcion;

	//bi-directional many-to-one association to EstadoReserva
	@OneToMany(mappedBy="estado")
	private List<EstadoReserva> estadoReservas;

	public Estado() {
	}

	public int getEstId() {
		return this.estId;
	}

	public void setEstId(int estId) {
		this.estId = estId;
	}

	public String getEstDescripcion() {
		return this.estDescripcion;
	}

	public void setEstDescripcion(String estDescripcion) {
		this.estDescripcion = estDescripcion;
	}

	public List<EstadoReserva> getEstadoReservas() {
		return this.estadoReservas;
	}

	public void setEstadoReservas(List<EstadoReserva> estadoReservas) {
		this.estadoReservas = estadoReservas;
	}

	public EstadoReserva addEstadoReserva(EstadoReserva estadoReserva) {
		getEstadoReservas().add(estadoReserva);
		estadoReserva.setEstado(this);

		return estadoReserva;
	}

	public EstadoReserva removeEstadoReserva(EstadoReserva estadoReserva) {
		getEstadoReservas().remove(estadoReserva);
		estadoReserva.setEstado(null);

		return estadoReserva;
	}

}