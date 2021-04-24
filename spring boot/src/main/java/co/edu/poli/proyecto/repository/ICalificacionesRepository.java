package co.edu.poli.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.poli.proyecto.model.CalificacionesModel;


public interface ICalificacionesRepository extends JpaRepository<CalificacionesModel, Integer> {

}
