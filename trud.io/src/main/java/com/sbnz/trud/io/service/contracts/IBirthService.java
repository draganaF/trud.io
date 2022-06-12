package com.sbnz.trud.io.service.contracts;

import java.util.ArrayList;
import com.sbnz.trud.io.model.Birth;

public interface IBirthService extends IGenericService<Birth>{
	void abortion(Integer pregnancyId);
	Birth create(Birth birth, Integer id);
	ArrayList<Birth> findAll();

}
