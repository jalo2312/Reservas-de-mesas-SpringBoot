package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IPagoDao;
import co.edu.ue.model.Pago;

@Service 
public class PagoService implements IPagoService {

	@Autowired
	IPagoDao pagoDao;
	
	@Override
	public Pago registerPago(Pago pago) {
		if(!pago.equals(null)) 
			return pagoDao.registerPago(pago);
		else 
			return null;
	}

	@Override
	public Pago updatePago(Pago pago) {
		// TODO Auto-generated method stub
		return pagoDao.updatePago(pago);
	}

	@Override
	public List<Pago> allPago() {
		// TODO Auto-generated method stub
		return pagoDao.allPago();
	}

	@Override
	public Pago searchById(int pgId) {
		// TODO Auto-generated method stub
		return pagoDao.searchById(pgId);
	}

	@Override
	public Pago deleteById(int pgId) {
		Pago pago = pagoDao.searchById(pgId);
        if(!pago.equals(null)){
            pagoDao.deleteById(pgId);
        }
        return pago;
		
	}

}
