package com.pms.service;

import java.util.List;

import com.pms.model.T30002;

public interface T30002Service {
	T30002 findByTdrugroutecode(String tdrugroutecode);
	List<T30002> findAll();
	public void saveT30002(T30002 t30002);
	public void deleteT30002(T30002 t30002);
}
