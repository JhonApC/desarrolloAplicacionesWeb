package co.edu.poli.proyecto.services;

import java.util.List;

public interface IGenericoCrud<T>  {

	public List<T> findAll();
	public T save(T entity);
	public T update(T entity);
	public void delete (Integer id);
	public T findById(Integer id);
}
