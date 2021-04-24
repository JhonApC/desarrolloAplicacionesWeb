package co.edu.poli.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.poli.proyecto.model.CalificacionesModel;
import co.edu.poli.proyecto.repository.ICalificacionesRepository;

@Service
public class CalificacionesImpl implements IGenericoCrud<CalificacionesModel> {

	@Autowired
	private ICalificacionesRepository repository;

	@Override
	public List<CalificacionesModel> findAll() {

		return this.repository.findAll();
	}

	@Override
	public CalificacionesModel save(CalificacionesModel entity) {
		return this.repository.save(entity);
	}

	@Override
	public CalificacionesModel update(CalificacionesModel entity) {
		return this.repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public CalificacionesModel findById(Integer id) {
		return repository.findById(id).get();
	}

}
