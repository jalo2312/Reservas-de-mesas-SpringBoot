package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.model.Comentario;
import co.edu.ue.service.IComentarioService;

@RestController
@RequestMapping(value="api")
public class ComentarioController {
	
	@Autowired
	IComentarioService comentService;
	
	//OBTENER TODOS LOS COMENTARIOS
	@GetMapping(value="comentarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comentario>> getAllRegister(){
		List<Comentario> comentarios = comentService.allComentario();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cantidad_comentarios", String.valueOf(comentarios.size()));
		return new ResponseEntity<List<Comentario>>(comentarios,headers,HttpStatus.OK);
	}
	//OBTENERLO MEDIANTE EL ID
	@GetMapping(value="comentarios/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Comentario> getComentById(@PathVariable("cod") int comId) {
		return new ResponseEntity<Comentario>(comentService.searchById(comId),HttpStatus.ACCEPTED);
	}
	
	//CREACION DEL COMENTARIO
	@PostMapping(value="comentarios",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveComent(@RequestBody Comentario comentario){
		if(!comentService.addComentario(comentario).equals(null)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping(value= "comentarios",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comentario> updateComent(@RequestBody Comentario comentario){
		 Comentario updateComentario = comentService.upComentario(comentario);
		 if(!updateComentario.equals(null)){
			 return new ResponseEntity<>(updateComentario,HttpStatus.CREATED);
		 }else {
			 return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		 }
	}
	
	@DeleteMapping(value="eliminar/{cod}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comentario> deleteComent(@PathVariable("cod") int comId) {
		if(!comentService.deleteById(comId).equals(null)) {
			return new ResponseEntity<Comentario>(HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Comentario>(HttpStatus.NOT_ACCEPTABLE);
		}
    }
	
	
	
	

}
