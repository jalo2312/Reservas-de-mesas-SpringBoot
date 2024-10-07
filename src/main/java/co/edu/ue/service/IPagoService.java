package co.edu.ue.service;

import java.util.List;

import co.edu.ue.model.Pago;

public interface IPagoService {
	Pago registerPago(Pago pago);
	Pago updatePago(Pago pago);
	List<Pago> allPago();
	Pago searchById(int pgId);
	Pago deleteById(int pgId);
}
