package com.pms.service;

import java.util.List;

import com.pms.model.T30001;

public interface T30001Service {
	T30001 findByTdrugformcode(String tdrugformcode);
	List<T30001> findAll();
	public void saveT30001(T30001 t30001);
	public void deleteT30001(T30001 t30001);
}
