package com.pms.service;

import java.util.List;
import com.pms.model.T30004;

public interface T30004Service {
	T30004 findByTgencode(String tgencode);
	List<T30004> findAll();
	public void saveT30004(T30004 t30004);
	public void deleteT30004(T30004 t30004);
}
