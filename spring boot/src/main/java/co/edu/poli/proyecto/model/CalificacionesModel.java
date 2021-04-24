package co.edu.poli.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="calificaciones")
public class CalificacionesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(mappedBy = "calificacion")
	@JsonIgnore
	private TrabajosModel trabajos;
	
	private String descripcion;
	
	@Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private String fecha_calificacion;
	
}
