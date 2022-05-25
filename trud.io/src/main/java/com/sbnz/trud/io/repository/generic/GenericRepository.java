package com.sbnz.trud.io.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.trud.io.model.BaseEntity;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Integer> {

}
