package co.edu.poli.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.proyecto.model.PersonaModel;

public interface IPersonaRepository extends JpaRepository<PersonaModel, Integer> {

}
