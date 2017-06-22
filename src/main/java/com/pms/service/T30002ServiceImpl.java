package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.model.T30002;
import com.pms.repository.T30002Repository;

@Service("t30002Service")
public class T30002ServiceImpl implements T30002Service{

	@Autowired
	private T30002Repository t30002Repository;
	
	@Override
	public T30002 findByTdrugroutecode(String tdrugroutecode) {
		return t30002Repository.findByTdrugroutecode(tdrugroutecode);
	}

	@Override
	public List<T30002> findAll() {
		return t30002Repository.findAll();
	}

	@Override
	public void saveT30002(T30002 t30002) {
		//set generic code
				if(t30002.getTdrugroutecode().equals("")){
					String maxCode=t30002Repository.getMaxTdrugroutecode();
					int newRuteCode = Integer.parseInt(maxCode)+1;
					t30002.setTdrugroutecode(Integer.toString(newRuteCode));
				}
				
				//set Active flag
				/*if(t30004.getT_active_flag()==null){
					t30004.setT_active_flag("0");
				}*/
				
				//set Generic name in Upper case
				t30002.setT_lang2_name(t30002.getT_lang2_name().toUpperCase());
				
				
				t30002Repository.save(t30002);
	}

	@Override
	public void deleteT30002(T30002 t30002) {
		t30002Repository.delete(t30002);
	}

	
	

}
