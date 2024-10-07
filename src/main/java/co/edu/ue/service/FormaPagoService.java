package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IFormaPagoDao;
import co.edu.ue.model.FormaPago;

@Service
public class FormaPagoService implements IFormaPagoService{
	
	@Autowired
	IFormaPagoDao fpDao;

	@Override
	public List<FormaPago> allFormaPago() {
		// TODO Auto-generated method stub
		return fpDao.allFormaPago();
	}

}
