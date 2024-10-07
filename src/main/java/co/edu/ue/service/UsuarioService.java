package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IUsuarioDao;
import co.edu.ue.model.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	IUsuarioDao userDao;

	@Override
	public Usuario addUsuario(Usuario usuario) {
		if(!usuario.equals(null)) 
			return userDao.registerUsuario(usuario);
		else 
			return null;	
		
	}

	@Override
	public Usuario upUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return userDao.updateUsuario(usuario);
	}

	@Override
	public List<Usuario> allUsuario() {
		// TODO Auto-generated method stub
		return userDao.allUsuario();
	}

	@Override
	public Usuario searchById(int usuId) {
		
		return userDao.searchById(usuId);
	}

	@Override
	public Usuario searchByEmail(String usuEmail) {
		// TODO Auto-generated method stub
		return userDao.searchByEmail(usuEmail);
	}

	@Override
	public Usuario deleteById(int usuId) {
		Usuario usuario = userDao.searchById(usuId);
		if(!usuario.equals(null)){
			userDao.deleteById(usuId);
		}
		return usuario;
	}

}
