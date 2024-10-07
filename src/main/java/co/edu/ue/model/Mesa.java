package co.edu.ue.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the mesas database table.
 * 
 */
@Entity
@Table(name="mesas")
@NamedQuery(name="Mesa.findAll", query="SELECT m FROM Mesa m")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mesa_id")
	private int mesaId;

	@Column(name="mesa_sillas")
	private int mesaSillas;

	//bi-directional many-to-one association to MesaReserva
	@OneToMany(mappedBy="mesa1")
	private List<MesaReserva> mesaReservas;

	//bi-directional one-to-one association to MesaReserva
	@OneToOne
	@JoinColumn(name="mesa_id")
	private MesaReserva mesaReserva;

	public Mesa() {
	}

	public int getMesaId() {
		return this.mesaId;
	}

	public void setMesaId(int mesaId) {
		this.mesaId = mesaId;
	}

	public int getMesaSillas() {
		return this.mesaSillas;
	}

	public void setMesaSillas(int mesaSillas) {
		this.mesaSillas = mesaSillas;
	}

	public List<MesaReserva> getMesaReservas() {
		return this.mesaReservas;
	}

	public void setMesaReservas(List<MesaReserva> mesaReservas) {
		this.mesaReservas = mesaReservas;
	}

	public MesaReserva addMesaReserva(MesaReserva mesaReserva) {
		getMesaReservas().add(mesaReserva);
		mesaReserva.setMesa1(this);

		return mesaReserva;
	}

	public MesaReserva removeMesaReserva(MesaReserva mesaReserva) {
		getMesaReservas().remove(mesaReserva);
		mesaReserva.setMesa1(null);

		return mesaReserva;
	}

	public MesaReserva getMesaReserva() {
		return this.mesaReserva;
	}

	public void setMesaReserva(MesaReserva mesaReserva) {
		this.mesaReserva = mesaReserva;
	}

}