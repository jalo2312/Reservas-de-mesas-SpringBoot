package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.Mesa;

@Repository
public class MesaDao  implements IMesaDao{
	
	@Autowired
	IMesaJpa jpa;

	@Override
	public List<Mesa> allMesa() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

}
