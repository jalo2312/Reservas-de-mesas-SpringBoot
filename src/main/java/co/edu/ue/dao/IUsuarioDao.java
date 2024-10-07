package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.model.Usuario;


public interface IUsuarioDao {
	Usuario registerUsuario(Usuario usuario);
	Usuario updateUsuario(Usuario usuario);
	List<Usuario> allUsuario();
	Usuario searchById(int usuId);
	Usuario searchByEmail(String usuEmail);
	void deleteById(int usuId);
}
