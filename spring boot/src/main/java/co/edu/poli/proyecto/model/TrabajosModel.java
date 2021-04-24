package co.edu.poli.proyecto.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trabajos")
public class TrabajosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "persona_id")
	@JsonIgnore
	private PersonaModel persona;
	private String descripcion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "calificacion_id")
	private CalificacionesModel calificacion;
	@Column(name = "fecha_entrega")
	private String fechaEntrega;
	@Column(name = "fecha_asignacion", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private String fechaAsigancion;
}
