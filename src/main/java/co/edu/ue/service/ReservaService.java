package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IReservaDao;
import co.edu.ue.model.Reserva;


@Service
public class ReservaService implements IReservaService{
	
	@Autowired
	IReservaDao reservDao;

	@Override
	public Reserva registerReserva(Reserva reserva) {
		if(!reserva.equals(null)) 
			return reservDao.registerReserva(reserva);
		else 
			return null;
	}

	@Override
	public Reserva updateReserva(Reserva reserva) {
		return reservDao.updateReserva(reserva);
	}

	@Override
	public List<Reserva> allReserva() {
		return reservDao.allReserva();
	}

	@Override
	public Reserva searchById(int rsId) {
		return reservDao.searchById(rsId);
	}

	@Override
	public Reserva deleteById(int rsId) {
		Reserva reserva = reservDao.searchById(rsId);
		if(!reserva.equals(null)){
			reservDao.deleteById(rsId);
		}
		return reserva;
	}

}
