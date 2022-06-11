package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.apiContracts.request.UpdateAmniocentesis;
import com.sbnz.trud.io.model.Amniocentesis;

public interface IAmniocentesisService extends IGenericService<Amniocentesis>{
	Amniocentesis create(Amniocentesis amniocentesis);
	
	Amniocentesis addAmniocentesis(Integer pregnancyId, Amniocentesis amniocentesis);
	
	Amniocentesis update(Integer pregnancyId, UpdateAmniocentesis updateAmniocentesis);

}
