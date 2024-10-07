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

import co.edu.ue.model.FormaPago;
import co.edu.ue.service.IFormaPagoService;

@RestController
@RequestMapping(value="api")
public class FormaPagoController {
	
	@Autowired
	IFormaPagoService fpService;
	
	@CrossOrigin(origins = "http://127.0.0.1:5501")
	@GetMapping(value="formapagos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FormaPago>> getAllUsuario(){
		List<FormaPago> usuario = fpService.allFormaPago();
		return new ResponseEntity<List<FormaPago>>(usuario,HttpStatus.OK);
	}

}
