package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.model.Comentario;

public interface IComentarioDao {
	Comentario registerComentario(Comentario comentario);
	Comentario updateComentario(Comentario comentario);
	List<Comentario> allComentario();
	Comentario searchById(int comId);
	void deleteById(int comId);
}
