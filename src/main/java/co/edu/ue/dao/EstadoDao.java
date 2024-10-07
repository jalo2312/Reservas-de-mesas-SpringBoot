package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.Estado;

@Repository
public class EstadoDao implements IEstadoDao{
	
	@Autowired
	IEstadoJpa jpa;

	@Override
	public List<Estado> allEstado() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

}
