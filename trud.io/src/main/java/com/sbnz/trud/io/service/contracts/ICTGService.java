package com.sbnz.trud.io.service.contracts;

import java.util.Date;

import com.sbnz.trud.io.model.CTG;

public interface ICTGService extends IGenericService<CTG> {

	void monitorCtg(int pregnancyId, float value, Date timestamp) throws Exception;

	void startCtg(int pregnancyId) throws Exception;

	CTG endCtg(int pregnancyId) throws Exception;

	void monitorMother(int pregnancyId, int value, Date timestamp);
}
