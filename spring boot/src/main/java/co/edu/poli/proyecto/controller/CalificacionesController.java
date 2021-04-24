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

import co.edu.poli.proyecto.model.CalificacionesModel;
import co.edu.poli.proyecto.services.CalificacionesImpl;

@RestController
@RequestMapping("calificaciones")
public class CalificacionesController {

	@Autowired
	private CalificacionesImpl service;

	@GetMapping("findAll")
	public List<CalificacionesModel> findAll() {
		return this.service.findAll();
	}

	@GetMapping("findById")
	public CalificacionesModel findById(@RequestHeader(required = true) Integer id) {
		return this.service.findById(id);
	}

	@PostMapping("save")
	public CalificacionesModel save(@RequestBody CalificacionesModel entity) {
		return this.service.save(entity);
	}

	@PutMapping("update")
	public CalificacionesModel update(@RequestBody CalificacionesModel entity) {
		return this.service.update(entity);
	}

	@DeleteMapping("delete")
	public CalificacionesModel delete(@RequestHeader(required = true) Integer id) {
		CalificacionesModel entityDelete = this.service.findById(id);
		this.service.delete(id);
		return entityDelete;
	}
}
