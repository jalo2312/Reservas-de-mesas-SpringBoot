package co.edu.ue.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the estado_reservas database table.
 * 
 */
@Entity
@Table(name="estado_reservas")
@NamedQuery(name="EstadoReserva.findAll", query="SELECT e FROM EstadoReserva e")
public class EstadoReserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="er_id")
	private int erId;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="est_id")
	private Estado estado;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="rs_id")
	private Reserva reserva;

	public EstadoReserva() {
	}

	public int getErId() {
		return this.erId;
	}

	public void setErId(int erId) {
		this.erId = erId;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}