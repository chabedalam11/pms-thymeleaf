package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.model.T30007;
import com.pms.repository.T30007Repository;

@Service("t30007Service")
public class T30007ServiceImpl implements T30007Service{

	@Autowired
	private T30007Repository t30007Repository;
	
	@Override
	public List<T30007> findByTmanufacturercode(String tmanufacturercode) {
		return t30007Repository.findByTmanufacturercode(tmanufacturercode);
	}

	@Override
	public List<T30007> findAll() {
		return t30007Repository.findAll();
	}

	@Override
	public void saveT30007(T30007 t30007) {
		//set generic code
				if(t30007.getTmanufacturercode().equals("")){
					String maxCode=t30007Repository.getMaxTmanufacturercode();
					int newManuCode = Integer.parseInt(maxCode)+1;
					t30007.setTmanufacturercode(Integer.toString(newManuCode));
				}
				
				//set Active flag
				/*if(t30004.getT_active_flag()==null){
					t30004.setT_active_flag("0");
				}*/
				
				//set Generic name in Upper case
				t30007.setT_lang2_name(t30007.getT_lang2_name().toUpperCase());
				
				
				t30007Repository.save(t30007);
	}

	@Override
	public void deleteT30007(T30007 t30007) {
		t30007Repository.delete(t30007);
	}

	
	

}
