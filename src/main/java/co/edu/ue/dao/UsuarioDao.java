package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.Usuario;

@Repository
public class UsuarioDao implements IUsuarioDao{
	
	@Autowired
	IUsuarioJpa userjpa;

	@Override
	public Usuario registerUsuario(Usuario usuario) {
	
		return userjpa.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		
		return userjpa.save(usuario);
	}

	@Override
	public List<Usuario> allUsuario() {
	
		return userjpa.findAll();
	}

	@Override
	public Usuario searchById(int usuId) {
		
		return userjpa.findById(usuId).orElse(null);
	}

	@Override
	public void deleteById(int usuId) {
		
		userjpa.deleteById(usuId);
	}

	@Override
	public Usuario searchByEmail(String usuEmail) {
		
		return userjpa.findByUsuEmail(usuEmail);
	}

}
