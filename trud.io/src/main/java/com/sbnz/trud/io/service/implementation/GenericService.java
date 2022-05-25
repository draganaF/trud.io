package com.sbnz.trud.io.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sbnz.trud.io.exeption.MissingEntityException;
import com.sbnz.trud.io.model.BaseEntity;
import com.sbnz.trud.io.repository.generic.GenericRepository;
import com.sbnz.trud.io.service.contracts.IGenericService;

public class GenericService<T extends BaseEntity> implements IGenericService<T> {

	@Autowired
	protected GenericRepository<T> genericRepository;
	
	@Override
	public T findById(Integer id) {
		 T entity = genericRepository.findById(id).orElse(null);
	        if (entity == null)
	            throw new MissingEntityException("Cook with given id does not exist in the system.");
	        return entity;
	}
	
	@Override
	public List<T> findAll() throws Exception {
		try {
			return genericRepository.findAll(); 
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public T save(T entity) throws Exception {
		try {
			return genericRepository.save(entity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Integer id) throws Exception {
		try {
			genericRepository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
	}
}
