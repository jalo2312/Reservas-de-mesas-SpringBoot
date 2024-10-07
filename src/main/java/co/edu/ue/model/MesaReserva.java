package co.edu.ue.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the mesa_reservas database table.
 * 
 */
@Entity
@Table(name="mesa_reservas")
@NamedQuery(name="MesaReserva.findAll", query="SELECT m FROM MesaReserva m")
public class MesaReserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mr_id")
	private int mrId;

	//bi-directional many-to-one association to Mesa
	@ManyToOne
	@JoinColumn(name="mesa_id")
	private Mesa mesa1;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="rs_id")
	private Reserva reserva;

	//bi-directional one-to-one association to Mesa
	@OneToOne(mappedBy="mesaReserva")
	private Mesa mesa2;

	public MesaReserva() {
	}

	public int getMrId() {
		return this.mrId;
	}

	public void setMrId(int mrId) {
		this.mrId = mrId;
	}

	public Mesa getMesa1() {
		return this.mesa1;
	}

	public void setMesa1(Mesa mesa1) {
		this.mesa1 = mesa1;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Mesa getMesa2() {
		return this.mesa2;
	}

	public void setMesa2(Mesa mesa2) {
		this.mesa2 = mesa2;
	}

}