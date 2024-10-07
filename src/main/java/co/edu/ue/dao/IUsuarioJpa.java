package co.edu.ue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.model.Usuario;

public interface IUsuarioJpa extends JpaRepository<Usuario, Integer>{

	Usuario findByUsuEmail(String usuEmail);
}
