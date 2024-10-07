package co.edu.ue.service;

import java.util.List;

import co.edu.ue.model.Reserva;

public interface IReservaService {
	
	Reserva registerReserva(Reserva reserva);
	Reserva updateReserva(Reserva reserva);
	List<Reserva> allReserva();
	Reserva searchById(int rsId);
	Reserva deleteById(int rsId);
}
