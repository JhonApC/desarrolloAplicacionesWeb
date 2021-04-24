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

import co.edu.poli.proyecto.model.TrabajosModel;
import co.edu.poli.proyecto.services.TrabajosImpl;

@RestController
@RequestMapping("trabajos")
public class TrabajosController {

	@Autowired
	private TrabajosImpl service;

	@GetMapping("findAll")
	public List<TrabajosModel> findAll() {
		return this.service.findAll();
	}

	@GetMapping("findById")
	public TrabajosModel findById(@RequestHeader(required = true) Integer id) {
		return this.service.findById(id);
	}

	@PostMapping("save")
	public TrabajosModel save(@RequestBody TrabajosModel entity) {
		return this.service.save(entity);
	}

	@PutMapping("update")
	public TrabajosModel update(@RequestBody TrabajosModel entity) {
		return this.service.update(entity);
	}

	@DeleteMapping("delete")
	public TrabajosModel delete(@RequestHeader(required = true) Integer id) {
		TrabajosModel entityDelete = this.service.findById(id);
		this.service.delete(id);
		return entityDelete;
	}
}
