package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.Pago;

@Repository
public class PagoDao implements IPagoDao{

	@Autowired
	IPagoJpa jpa;
	
	@Override
	public Pago registerPago(Pago pago) {
		// TODO Auto-generated method stub
		return jpa.save(pago);
	}

	@Override
	public Pago updatePago(Pago pago) {
		// TODO Auto-generated method stub
		return jpa.save(pago);
	}

	@Override
	public List<Pago> allPago() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Pago searchById(int pgId) {
		// TODO Auto-generated method stub
		return jpa.findById(pgId).orElse(null);
	}

	@Override
	public void deleteById(int pgId) {
		// TODO Auto-generated method stub
		
	}

}
