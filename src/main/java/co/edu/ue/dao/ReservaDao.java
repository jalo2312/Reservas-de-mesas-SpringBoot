package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.Reserva;

@Repository
public class ReservaDao implements IReservaDao {

		@Autowired
		IReservaJpa jpa;

		@Override
		public Reserva registerReserva(Reserva reserva) {
		
			return jpa.save(reserva);
		}

		@Override
		public Reserva updateReserva(Reserva reserva) {
		
			return jpa.save(reserva);
		}

		@Override
		public List<Reserva> allReserva() {
			
			return jpa.findAll();
		}

		@Override
		public Reserva searchById(int rsId) {
			
			return jpa.findById(rsId).orElse(null);
		}

		@Override
		public void deleteById(int rsId) {
			jpa.deleteById(rsId);
			
		}
	
	}


