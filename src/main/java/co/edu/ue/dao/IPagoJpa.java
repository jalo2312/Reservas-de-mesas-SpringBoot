package co.edu.ue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.model.Pago;

public interface IPagoJpa extends JpaRepository<Pago,Integer> {

}
