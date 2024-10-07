package co.edu.ue.service;

import java.util.List;

import co.edu.ue.model.Usuario;

public interface IUsuarioService {
	Usuario addUsuario(Usuario usuario);
	Usuario upUsuario(Usuario usuario);
	List<Usuario> allUsuario();
	Usuario searchById(int usuId);
	Usuario searchByEmail(String usuEmail);
	Usuario deleteById(int usuId);
}
