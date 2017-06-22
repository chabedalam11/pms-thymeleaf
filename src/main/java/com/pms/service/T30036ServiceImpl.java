package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.model.T30036;
import com.pms.repository.T30036Repository;

@Service("t30036Service")
public class T30036ServiceImpl implements T30036Service{

	@Autowired
	private T30036Repository t30036Repository;
	
	@Override
	public T30036 findByTum(String tum) {
		return t30036Repository.findByTum(tum);
	}

	@Override
	public List<T30036> findAll() {
		return t30036Repository.findAll();
	}

	@Override
	public void saveT30036(T30036 t30036) {
		//set generic code
				if(t30036.getTum().equals("")){
					String maxCode=t30036Repository.getMaxTum();
					System.out.println("max code "+maxCode);
					int newFormCode = Integer.parseInt(maxCode)+1;
					t30036.setTum(Integer.toString(newFormCode));
				}
				
				//set Active flag
				/*if(t30004.getT_active_flag()==null){
					t30004.setT_active_flag("0");
				}*/
				
				//set Generic name in Upper case
				t30036.setT_lang2_name(t30036.getT_lang2_name().toUpperCase());
				
				
				t30036Repository.save(t30036);
	}

	@Override
	public void deleteT30036(T30036 t30036) {
		t30036Repository.delete(t30036);
	}

	
	

}
