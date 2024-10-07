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

import co.edu.ue.model.Mesa;
import co.edu.ue.service.IMesaService;

@RestController
@RequestMapping(value="api")
public class MesaController {
	
	@Autowired
	IMesaService mesaService;
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping(value="mesas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Mesa>> getAllMesa(){
		List<Mesa> mesa = mesaService.allMesa();
		return new ResponseEntity<List<Mesa>>(mesa,HttpStatus.OK);
	}

}
