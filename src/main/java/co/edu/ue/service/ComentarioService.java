package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IComentarioDao;
import co.edu.ue.model.Comentario;

@Service
public class ComentarioService implements IComentarioService{
	
	@Autowired
	IComentarioDao comentDao;

	@Override
	public Comentario addComentario(Comentario comentario) {
		if(!comentario.equals(null)) 
			return comentDao.registerComentario(comentario);
		else 
			return null;	
		}

	@Override
	public Comentario upComentario(Comentario comentario) {
		return comentDao.updateComentario(comentario);
	}

	@Override
	public List<Comentario> allComentario() {
		return comentDao.allComentario();
	}

	@Override
	public Comentario searchById(int comId) {
		return comentDao.searchById(comId);
	}

	@Override
	public Comentario deleteById(int comid) {
		Comentario comentario = comentDao.searchById(comid);
		if(!comentario.equals(null)){
			comentDao.deleteById(comid);
		}
		return comentario;
	}

}
