package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.Comentario;

@Repository
public class ComentarioDao implements IComentarioDao{
	
	@Autowired
	IComentarioJpa jpa;

	@Override
	public Comentario registerComentario(Comentario comentario) {
		return jpa.save(comentario);
	}

	@Override
	public Comentario updateComentario(Comentario comentario) {
		return jpa.save(comentario);
	}

	@Override
	public List<Comentario> allComentario() {
		return jpa.findAll();
	}

	@Override
	public Comentario searchById(int comId) {
		return jpa.findById(comId).orElse(null);
	}

	@Override
	public void deleteById(int comId) {
		jpa.deleteById(comId);
	}

}
