package com.pms.service;

import java.util.List;
import com.pms.model.T30005;

public interface T30005Service {
	T30005 findByTtradecode(String ttradecode);
	 List<T30005> findByT_gen_code(String t_gen_code);
	List<T30005> findAll();
	public void saveT30005(T30005 t30005);
	public void deleteT30005(T30005 t30005);
}
