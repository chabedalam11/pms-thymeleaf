package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.model.T30001;
import com.pms.repository.T30001Repository;

@Service("t30001Service")
public class T30001ServiceImpl implements T30001Service{

	@Autowired
	private T30001Repository t30001Repository;
	
	@Override
	public T30001 findByTdrugformcode(String tdrugformcode) {
		return t30001Repository.findByTdrugformcode(tdrugformcode);
	}

	@Override
	public List<T30001> findAll() {
		return t30001Repository.findAll();
	}

	@Override
	public void saveT30001(T30001 t30001) {
		//set generic code
				if(t30001.getTdrugformcode().equals("")){
					String maxCode=t30001Repository.getMaxTdrugformcode();
					System.out.println("max code "+maxCode);
					int newFormCode = Integer.parseInt(maxCode)+1;
					t30001.setTdrugformcode(Integer.toString(newFormCode));
				}
				
				//set Active flag
				/*if(t30004.getT_active_flag()==null){
					t30004.setT_active_flag("0");
				}*/
				
				//set Generic name in Upper case
				t30001.setT_lang2_name(t30001.getT_lang2_name().toUpperCase());
				
				
				t30001Repository.save(t30001);
	}

	@Override
	public void deleteT30001(T30001 t30001) {
		t30001Repository.delete(t30001);
	}

	
	

}
