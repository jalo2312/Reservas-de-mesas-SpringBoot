package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.FormaPago;

@Repository
public class FormaPagoDao implements IFormaPagoDao{
	
	@Autowired
	IFormaPagoJpa jpa;

	@Override
	public List<FormaPago> allFormaPago() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

}
