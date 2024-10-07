package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.model.Pago;


public interface IPagoDao {

	Pago registerPago(Pago pago);
	Pago updatePago(Pago pago);
	List<Pago> allPago();
	Pago searchById(int pgId);
	void deleteById(int pgId);
}
