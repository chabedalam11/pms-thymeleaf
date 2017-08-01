package com.pms.service;

import java.util.List;

import com.pms.model.T30118;

public interface T30118Service {
	T30118  findByTvendorcode(String tvendorcode);
	List<T30118> findAll();
	public void saveT30118(T30118 t30118);
	public void deleteT30118(T30118 t30118);
}
