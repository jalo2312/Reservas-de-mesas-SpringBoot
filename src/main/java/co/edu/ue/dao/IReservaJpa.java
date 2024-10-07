package co.edu.ue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.model.Reserva;

public interface IReservaJpa extends JpaRepository<Reserva,Integer> {

}
