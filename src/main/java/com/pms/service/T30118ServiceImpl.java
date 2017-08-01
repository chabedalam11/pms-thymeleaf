package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.model.T30118;
import com.pms.repository.T30118Repository;

@Service("t30118Service")
public class T30118ServiceImpl implements T30118Service{

	@Autowired
	private T30118Repository t30118Repository;
	
	@Override
	public T30118 findByTvendorcode(String tvendorcode) {
		return t30118Repository.findByTvendorcode(tvendorcode);
	}

	@Override
	public List<T30118> findAll() {
		return t30118Repository.findAll();
	}

	@Override
	public void saveT30118(T30118 t30118) {
		//set generic code
		if(t30118.getTvendorcode().equals("")){
			String maxCode=t30118Repository.getMaxTvendorcode();
			System.out.println("max code "+maxCode);
			int newFormCode = Integer.parseInt(maxCode)+1;
			t30118.setTvendorcode(Integer.toString(newFormCode));
		}
		if(t30118.getT_vendor_active_flag_y()==null){
			t30118.setT_vendor_active_flag_y("0");
		}
		//set Generic name in Upper case
		t30118.setT_lang2_name(t30118.getT_lang2_name().toUpperCase());
		t30118Repository.save(t30118);
	}

	@Override
	public void deleteT30118(T30118 t30118) {
		t30118Repository.delete(t30118);
	}

	
}
