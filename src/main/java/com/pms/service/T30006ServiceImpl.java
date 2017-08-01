package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.model.T30006;
import com.pms.repository.T30006Repository;


@Service("t30006Service")
public class T30006ServiceImpl implements T30006Service{

	@Autowired
	private T30006Repository t30006Repository;
	
	@Override
	public T30006 findByTdrugmastercode(String tdrugmastercode) {
		return t30006Repository.findByTdrugmastercode(tdrugmastercode);
	}

	@Override
	public List<T30006> findAll() {
		return t30006Repository.findAll();
	}

	@Override
	public void saveT30006(T30006 t30006) {
		//set generic code
		if(t30006.getTdrugmastercode() == null || t30006.getTdrugmastercode().equals("")){
			String maxCode=t30006Repository.getMaxTdrugmastercode();
			System.out.println("max code "+maxCode);
			int newFormCode = Integer.parseInt(maxCode)+1;
			t30006.setTdrugmastercode(Integer.toString(newFormCode));
		}
				
		//set Active flag
		if(t30006.getT_active_flag()==null){
			t30006.setT_active_flag("0");
		}
		
		/*//set Generic name in Upper case
		t30006.setT_lang2_name(t30006.getT_lang2_name().toUpperCase());*/
		
		t30006Repository.save(t30006);
	}

	@Override
	public void deleteT30006(T30006 t30006) {
		t30006Repository.delete(t30006);
	}

	@Override
	public List<T30006> getAllT30006() {
		

		System.out.println("=================== data ========================");
		//List<T30006> list =(List<T30006>) t30006Repository.getAllT30006();
		
		
		/*for(T30006 t30006: list){
			System.out.println(t30006.getTdrugmastercode()+"\t"+t30006.getT30001().getT_lang2_name());
		}*/
		
		/*Iterator itr = list.iterator();
		while(itr.hasNext()){
		   Object[] obj = (Object[]) itr.next();
		   //now you have one array of Object for each row
		   //String client = String.valueOf(obj[0]); // don't know the type of column CLIENT assuming String 
		   //Integer service = Integer.parseInt(String.valueOf(obj[1])); //SERVICE assumed as int
		   //same way for all obj[2], obj[3], obj[4]
		   System.out.println(String.valueOf(obj[0])+"\t"+String.valueOf(obj[1]));
		}*/
		
		return null;
	}

	@Override
	public T30006 findByT_trade_code(String t_trade_code) {
		return t30006Repository.findByT_trade_code(t_trade_code);
	}

	
	

}
