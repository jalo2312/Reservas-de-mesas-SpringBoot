package co.edu.ue.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rs_id")
	private int rsId;

	@Temporal(TemporalType.DATE)
	@Column(name="rs_fecha")
	private Date rsFecha;

	@Column(name="rs_hora")
	private Time rsHora;

	//bi-directional many-to-one association to EstadoReserva
	@OneToMany(mappedBy="reserva")
	private List<EstadoReserva> estadoReservas;

	//bi-directional many-to-one association to MesaReserva
	@OneToMany(mappedBy="reserva")
	private List<MesaReserva> mesaReservas;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="reserva")
	private List<Pago> pagos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usu_id")
	private Usuario usuario;

	public Reserva() {
	}

	public int getRsId() {
		return this.rsId;
	}

	public void setRsId(int rsId) {
		this.rsId = rsId;
	}

	public Date getRsFecha() {
		return this.rsFecha;
	}

	public void setRsFecha(Date rsFecha) {
		this.rsFecha = rsFecha;
	}

	public Time getRsHora() {
		return this.rsHora;
	}

	public void setRsHora(Time rsHora) {
		this.rsHora = rsHora;
	}

	public List<EstadoReserva> getEstadoReservas() {
		return this.estadoReservas;
	}

	public void setEstadoReservas(List<EstadoReserva> estadoReservas) {
		this.estadoReservas = estadoReservas;
	}

	public EstadoReserva addEstadoReserva(EstadoReserva estadoReserva) {
		getEstadoReservas().add(estadoReserva);
		estadoReserva.setReserva(this);

		return estadoReserva;
	}

	public EstadoReserva removeEstadoReserva(EstadoReserva estadoReserva) {
		getEstadoReservas().remove(estadoReserva);
		estadoReserva.setReserva(null);

		return estadoReserva;
	}

	public List<MesaReserva> getMesaReservas() {
		return this.mesaReservas;
	}

	public void setMesaReservas(List<MesaReserva> mesaReservas) {
		this.mesaReservas = mesaReservas;
	}

	public MesaReserva addMesaReserva(MesaReserva mesaReserva) {
		getMesaReservas().add(mesaReserva);
		mesaReserva.setReserva(this);

		return mesaReserva;
	}

	public MesaReserva removeMesaReserva(MesaReserva mesaReserva) {
		getMesaReservas().remove(mesaReserva);
		mesaReserva.setReserva(null);

		return mesaReserva;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setReserva(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setReserva(null);

		return pago;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}