package co.edu.poli.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.poli.proyecto.model.TrabajosModel;
import co.edu.poli.proyecto.repository.ITrabajosRepository;

@Service
public class TrabajosImpl implements IGenericoCrud<TrabajosModel> {

	@Autowired
	private ITrabajosRepository repository;

	@Override
	public List<TrabajosModel> findAll() {

		return this.repository.findAll();
	}

	@Override
	public TrabajosModel save(TrabajosModel entity) {
		return this.repository.save(entity);
	}

	@Override
	public TrabajosModel update(TrabajosModel entity) {
		return this.repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public TrabajosModel findById(Integer id) {
		return repository.findById(id).get();
	}

}
