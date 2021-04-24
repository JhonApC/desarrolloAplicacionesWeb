package co.edu.poli.proyecto.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personas")
public class PersonaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String rol;
	private String password;
	private String correo;
	@Column(name = "numero_celular")
	private Long numeroCelular;
	private Long documento;
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	private String ficha;
	@OneToMany(mappedBy = "persona",cascade = CascadeType.ALL)
	private Set<TrabajosModel> trabajos;
	@Column(name = "fecha_creacion", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date fechaCreacion;

}
