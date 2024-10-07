package co.edu.ue.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the forma_pagos database table.
 * 
 */
@Entity
@Table(name="forma_pagos")
@NamedQuery(name="FormaPago.findAll", query="SELECT f FROM FormaPago f")
public class FormaPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fp_id")
	private int fpId;

	@Column(name="fp_descripcion")
	private String fpDescripcion;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="formaPago")
	private List<Pago> pagos;

	public FormaPago() {
	}

	public int getFpId() {
		return this.fpId;
	}

	public void setFpId(int fpId) {
		this.fpId = fpId;
	}

	public String getFpDescripcion() {
		return this.fpDescripcion;
	}

	public void setFpDescripcion(String fpDescripcion) {
		this.fpDescripcion = fpDescripcion;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setFormaPago(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setFormaPago(null);

		return pago;
	}

}