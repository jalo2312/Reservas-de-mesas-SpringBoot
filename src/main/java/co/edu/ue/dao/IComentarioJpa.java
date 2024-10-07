package co.edu.ue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.model.Comentario;

public interface IComentarioJpa extends JpaRepository<Comentario,Integer>{

}
