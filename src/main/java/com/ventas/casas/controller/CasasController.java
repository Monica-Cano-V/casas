package com.ventas.casas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.casas.Repository.RegistroRepository;
import com.ventas.casas.model.Registro;


@RestController
@RequestMapping("/casas")
public class CasasController {
	
	@Autowired
	private RegistroRepository registroRepository;
	
	@GetMapping("/registros")
	  public ResponseEntity<List<Registro>> getTutorial() {
	   List<Registro> listaRegistro =  registroRepository.findAll();
	   return new ResponseEntity<>(listaRegistro, HttpStatus.OK);
	  }
	
	@GetMapping("/registros/{id}")
	  public ResponseEntity<Registro> getTutorialById(@PathVariable String id) {
		Optional<Registro> registro;
		
		try {
			registro = registroRepository.findById(Integer.valueOf(id));
			return new ResponseEntity<>(registro.get(), HttpStatus.OK);
			   
		}
		catch(Exception e) {
			return new ResponseEntity<>(new Registro(), HttpStatus.NOT_FOUND);
		}
		
		
	  }
	
	@DeleteMapping("/registro")
	  public ResponseEntity<String> getTutorialBorrarById(@RequestBody Registro registro) {
		registroRepository.deleteById(registro.getId());
	   return new ResponseEntity<>("Se ha borrado correctamente", HttpStatus.OK);
	  }
	
	@PostMapping("/registro")
	  public ResponseEntity<Registro> getTutorialInsertarById(@RequestBody Registro registro) {
		registroRepository.save(registro);
		System.out.println(registro);
		return new ResponseEntity<>(registro, HttpStatus.OK);
	  }
	
	@PutMapping("/registro")
	  public ResponseEntity<Registro> getTutorialActualizaById(@RequestBody Registro registro) {
		Optional<Registro> registroEncontrado = registroRepository.findById(Integer.valueOf(registro.getId()));
		registroEncontrado.get().setNombre(registro.getNombre());
		registroEncontrado.get().setApellido(registro.getApellido());
		registroEncontrado.get().setPresupuesto(registro.getPresupuesto());
		System.out.println(registroEncontrado.get());
		return new ResponseEntity<>(registroRepository.save(registroEncontrado.get()), HttpStatus.OK);
	  }

}
