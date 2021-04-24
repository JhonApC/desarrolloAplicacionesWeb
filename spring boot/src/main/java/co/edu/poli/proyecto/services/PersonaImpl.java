package co.edu.poli.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.poli.proyecto.model.PersonaModel;
import co.edu.poli.proyecto.repository.IPersonaRepository;

@Service
public class PersonaImpl implements IGenericoCrud<PersonaModel> {

	@Autowired
	private IPersonaRepository repository;

	@Override
	public List<PersonaModel> findAll() {

		return this.repository.findAll();
	}

	@Override
	public PersonaModel save(PersonaModel entity) {
		return this.repository.save(entity);
	}

	@Override
	public PersonaModel update(PersonaModel entity) {
		return this.repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public PersonaModel findById(Integer id) {
		return repository.findById(id).get();
	}

}
