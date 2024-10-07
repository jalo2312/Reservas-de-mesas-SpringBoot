package co.edu.ue.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the pagos database table.
 * 
 */
@Entity
@Table(name="pagos")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pg_id")
	private int pgId;

	@Column(name="pg_precio")
	private int pgPrecio;

	//bi-directional many-to-one association to FormaPago
	@ManyToOne
	@JoinColumn(name="fp_id")
	private FormaPago formaPago;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="rs_id")
	private Reserva reserva;

	public Pago() {
	}

	public int getPgId() {
		return this.pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	public int getPgPrecio() {
		return this.pgPrecio;
	}

	public void setPgPrecio(int pgPrecio) {
		this.pgPrecio = pgPrecio;
	}

	public FormaPago getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}