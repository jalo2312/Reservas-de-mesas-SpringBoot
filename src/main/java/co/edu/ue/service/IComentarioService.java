package co.edu.ue.service;

import java.util.List;

import co.edu.ue.model.Comentario;

public interface IComentarioService {
	Comentario addComentario(Comentario comentario);
	Comentario upComentario(Comentario comentario);
	List<Comentario> allComentario();
	Comentario searchById(int comId);
	 Comentario deleteById(int comid);
}
