package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.model.Estado;
import co.edu.ue.service.IEstadoService;

@RestController
@RequestMapping(value="api")
public class EstadoController {
	
	@Autowired
	IEstadoService estService;
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping(value="estados", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estado>> getAllEstado(){
		List<Estado> estado = estService.allEstado();
		return new ResponseEntity<List<Estado>>(estado,HttpStatus.OK);
	}


}
