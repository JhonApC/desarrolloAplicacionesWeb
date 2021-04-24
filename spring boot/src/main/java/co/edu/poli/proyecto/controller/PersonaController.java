package co.edu.poli.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.proyecto.model.PersonaModel;
import co.edu.poli.proyecto.services.PersonaImpl;

@RestController
@RequestMapping(name = "/api/persona/")
public class PersonaController {

	@Autowired
	private PersonaImpl service;

	@GetMapping("findAll")
	public List<PersonaModel> findAll() {
		return this.service.findAll();
	}

	@GetMapping("findById")
	public PersonaModel findById(@RequestHeader(required = true) Integer id) {
		return this.service.findById(id);
	}

	@PostMapping("save")
	public PersonaModel save(@RequestBody PersonaModel entity) {
		return this.service.save(entity);
	}

	@PutMapping("update")
	public PersonaModel update(@RequestBody PersonaModel entity) {
		return this.service.update(entity);
	}

	@DeleteMapping("delete")
	public PersonaModel delete(@RequestHeader(required = true) Integer id) {
		PersonaModel entityDelete = this.service.findById(id);
		this.service.delete(id);
		return entityDelete;
	}
}
