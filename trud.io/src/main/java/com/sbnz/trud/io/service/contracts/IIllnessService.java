package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.model.Illness;

public interface IIllnessService extends IGenericService<Illness>{
	Illness findByName(String name);
}
