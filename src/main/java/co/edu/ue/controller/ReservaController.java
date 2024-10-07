package co.edu.ue.controller;

import co.edu.ue.service.IReservaService;

import co.edu.ue.model.Reserva;

import java.util.List;

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


@RestController
@RequestMapping(value="api")
public class ReservaController {

	@Autowired
	IReservaService reservService;
	
	//OBTENER TODAS LAS RESERVAS
	@CrossOrigin(origins = "http://127.0.0.1:5500")
		@GetMapping(value="reservas", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Reserva>> getAllRegister(){
			List<Reserva> reservas = reservService.allReserva();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Cantidad_reservas", String.valueOf(reservas.size()));
			return new ResponseEntity<List<Reserva>>(reservas,headers,HttpStatus.OK);
		}
	
		//OBTENERLO MEDIANTE EL ID
	@CrossOrigin(origins = "http://127.0.0.1:5500")
		@GetMapping(value="reservas/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Reserva> getReservById(@PathVariable("cod") int rsId) {
			return new ResponseEntity<Reserva>(reservService.searchById(rsId),HttpStatus.ACCEPTED);
		}
		
		//CREACION DE LA RESERVA
	@CrossOrigin(origins = "http://127.0.0.1:5500")
		@PostMapping(value="reservas",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> saveComent(@RequestBody Reserva reserva){
			if(!reservService.registerReserva(reserva).equals(null)) {
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
	@CrossOrigin(origins = "http://127.0.0.1:5500")
		@PutMapping(value= "reservas",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Reserva> updateComent(@RequestBody Reserva reserva){
			Reserva updateReserva = reservService.updateReserva(reserva);
			 if(!updateReserva.equals(null)){
				 return new ResponseEntity<>(updateReserva,HttpStatus.CREATED);
			 }else {
				 return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			 }
		}
		
	@CrossOrigin(origins = "http://127.0.0.1:5500")
		@DeleteMapping(value="reservas/eliminar/{cod}",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Reserva> deleteComent(@PathVariable("cod") int rsId) {
			if(!reservService.deleteById(rsId).equals(null)) {
				return new ResponseEntity<Reserva>(HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<Reserva>(HttpStatus.NOT_ACCEPTABLE);
			}
	    }
}
