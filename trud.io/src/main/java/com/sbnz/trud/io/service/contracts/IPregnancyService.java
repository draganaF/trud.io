package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.model.Pregnancy;

public interface IPregnancyService extends IGenericService<Pregnancy>{
    Pregnancy create(Pregnancy entity);
}
