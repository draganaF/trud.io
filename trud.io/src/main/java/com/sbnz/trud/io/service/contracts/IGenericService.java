package com.sbnz.trud.io.service.contracts;

import java.util.List;

import com.sbnz.trud.io.model.BaseEntity;

public interface IGenericService<T extends BaseEntity> {

	T findById(Integer id);
	List<T> findAll() throws Exception;
	T save(T entity) throws Exception;
	void delete(Integer id) throws Exception;	
}
