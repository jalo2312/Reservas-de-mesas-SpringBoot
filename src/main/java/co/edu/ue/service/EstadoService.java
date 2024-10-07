package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IEstadoDao;
import co.edu.ue.model.Estado;

@Service
public class EstadoService implements IEstadoService{
	
	@Autowired
	IEstadoDao estDao;

	@Override
	public List<Estado> allEstado() {
		return estDao.allEstado();
	}

}
