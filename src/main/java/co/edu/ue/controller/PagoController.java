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

import co.edu.ue.model.Pago;

import co.edu.ue.service.IPagoService;

@RestController
@RequestMapping(value="api")
public class PagoController {

	@Autowired
	IPagoService pgService;
	
	//OBTENER TODOS LOS COMENTARIOS
		@GetMapping(value="pagos", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Pago>> getAllRegister(){
			List<Pago> pagos = pgService.allPago();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Cantidad_pagos", String.valueOf(pagos.size()));
			return new ResponseEntity<List<Pago>>(pagos,headers,HttpStatus.OK);
		}
		//OBTENERLO MEDIANTE EL ID
		@GetMapping(value="pagos/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Pago> getById(@PathVariable("cod") int pgId) {
			return new ResponseEntity<Pago>(pgService.searchById(pgId),HttpStatus.ACCEPTED);
		}
		
		//CREACION DEL COMENTARIO
		@PostMapping(value="pagos",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> saveComent(@RequestBody Pago pago){
			if(!pgService.registerPago(pago).equals(null)) {
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
	
		@PutMapping(value="pagos",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Pago> updateComent(@RequestBody Pago pago){
			Pago update_pago = pgService.updatePago(pago);
			if(!update_pago.equals(null)) {
				return new ResponseEntity<>(update_pago,HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
			}
			
		}
		
		@DeleteMapping(value="pagos/eliminar/{cod}",produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Pago> deleteComent(@PathVariable("cod") int pgId) {
	        if(!pgService.deleteById(pgId).equals(null)) {
	            return new ResponseEntity<Pago>(HttpStatus.CREATED);
	        }else {
	            return new ResponseEntity<Pago>(HttpStatus.NOT_ACCEPTABLE);
	        }
	    }
		
}
