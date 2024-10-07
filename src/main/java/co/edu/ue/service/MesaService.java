package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IMesaDao;
import co.edu.ue.model.Mesa;

@Service
public class MesaService implements IMesaService{
	
	@Autowired
	IMesaDao mesaDao;

	@Override
	public List<Mesa> allMesa() {
		// TODO Auto-generated method stub
		return mesaDao.allMesa();
	}

}
