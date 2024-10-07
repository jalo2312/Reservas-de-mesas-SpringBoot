package co.edu.ue.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.model.Usuario;
import co.edu.ue.service.IUsuarioService;

@RestController
@RequestMapping(value="api")
public class UsuarioController {
	
	@Autowired
	IUsuarioService userService;
	
	//OBTENER TODOS LOS USUARIOS
		@CrossOrigin(origins = "http://127.0.0.1:5501")
		@GetMapping(value="usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Usuario>> getAllUsuario(){
			List<Usuario> usuario = userService.allUsuario();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Cantidad_usuarios", String.valueOf(usuario.size()));
			return new ResponseEntity<List<Usuario>>(usuario,headers,HttpStatus.OK);
		}
		
		//OBTENERLO MEDIANTE EL ID
		@CrossOrigin(origins = "http://127.0.0.1:5500")
		@GetMapping(value="usuarios/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Usuario> getUserById(@PathVariable("cod") int usuId) {
			return new ResponseEntity<Usuario>(userService.searchById(usuId),HttpStatus.ACCEPTED);
		}
		
		@CrossOrigin(origins = "http://127.0.0.1:5500")
		@GetMapping(value = "/usuarios/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Usuario> getUserByEmail(@PathVariable("email") String usuEmail) {
		    Usuario usuario = userService.searchByEmail(usuEmail);
		    
		    if (usuario != null) {
		        return new ResponseEntity<>(usuario, HttpStatus.OK); // Devuelve 200 OK si encuentra el usuario
		    } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve 404 si no lo encuentra
		    }
		}
		
		
		@CrossOrigin(origins = "http://127.0.0.1:5500")
		@PostMapping(value="usuarios",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> saveUser(@RequestBody Usuario usuario){
			if(!userService.addUsuario(usuario).equals(null)) {
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		@CrossOrigin(origins = "http://127.0.0.1:5500")
		@PutMapping(value= "usuarios",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario){
			 Usuario updateUsuario= userService.upUsuario(usuario);
			 if(!updateUsuario.equals(null)){
				 return new ResponseEntity<>(updateUsuario,HttpStatus.CREATED);
			 }else {
				 return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			 }
		}
		
		@CrossOrigin(origins = "http://127.0.0.1:5500")
		@DeleteMapping(value="usuarios/eliminar/{cod}",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Usuario> deleteComent(@PathVariable("cod") int comId) {
			if(!userService.deleteById(comId).equals(null)) {
				return new ResponseEntity<Usuario>(HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<Usuario>(HttpStatus.NOT_ACCEPTABLE);
			}
	    }
		
		//AUTENTICACION LOGIN
		@CrossOrigin(origins = "http://127.0.0.1:5500")
		@PostMapping(value="login")
		public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginData) {
			String email = loginData.get("email");
			String password = loginData.get("password");

			Usuario usuario = userService.searchByEmail(email);

			if (usuario != null && usuario.getUsuContraseña().equals(password)) {
				// Login exitoso
				return new ResponseEntity<>(usuario, HttpStatus.OK);
			} else {
				// Email o contraseña incorrectos
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
}
