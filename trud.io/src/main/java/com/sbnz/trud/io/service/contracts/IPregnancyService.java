package com.sbnz.trud.io.service.contracts;

import java.util.ArrayList;
import com.sbnz.trud.io.model.Pregnancy;

public interface IPregnancyService extends IGenericService<Pregnancy>{
    Pregnancy create(Pregnancy entity);
    Pregnancy addSymptom(Integer id, ArrayList<Integer> symptoms);
}
