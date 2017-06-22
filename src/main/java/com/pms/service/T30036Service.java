package com.pms.service;

import java.util.List;

import com.pms.model.T30036;

public interface T30036Service {
	T30036 findByTum(String tum);
	List<T30036> findAll();
	public void saveT30036(T30036 t30036);
	public void deleteT30036(T30036 t30036);
}
