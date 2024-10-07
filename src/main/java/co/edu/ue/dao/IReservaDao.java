package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.model.Reserva;

public interface IReservaDao {

	Reserva registerReserva(Reserva reserva);
	Reserva updateReserva(Reserva reserva);
	List<Reserva> allReserva();
	Reserva searchById(int rsId);
	void deleteById(int rsId);
	
}
