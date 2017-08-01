package com.pms.service;

import java.util.List;
import com.pms.model.T30006;

public interface T30006Service {
	T30006 findByTdrugmastercode(String tdrugmastercode);
	T30006 findByT_trade_code(String t_trade_code);
	List<T30006> findAll();
	public void saveT30006(T30006 t30006);
	public void deleteT30006(T30006 t30006);
	List<T30006> getAllT30006();
}
