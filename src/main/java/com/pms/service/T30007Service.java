package com.pms.service;

import java.util.List;

import com.pms.model.T30007;

public interface T30007Service {
	T30007 findByTmanufacturercode(String tmanufacturercode);
	List<T30007> findAll();
	public void saveT30007(T30007 t30007);
	public void deleteT30007(T30007 t30007);
}
