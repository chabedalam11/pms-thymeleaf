package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pms.model.T30005;
import com.pms.repository.T30005Repository;

@Service("t30005Service")
public class T30005ServiceImpl implements T30005Service{

	
	@Autowired
	private T30005Repository t30005Repository;
	
	@Override
	public List<T30005> findAll() {
		return t30005Repository.findAll();
	}
	
	@Override
	public T30005 findByTtradecode(String ttradecode) {
		return t30005Repository.findByTtradecode(ttradecode);
	}
	
	@Override
	public List<T30005> findByT_gen_code(String t_gen_code) {
		return t30005Repository.findByT_gen_code(t_gen_code);
	}
	
	@Override
	public void saveT30005(T30005 t30005) {
		//set trade  code
		if(t30005.getTtradecode().equals("")){
			String maxCode=t30005Repository.getMaxTtradecode();
			int newTradeCode = Integer.parseInt(maxCode)+1;
			t30005.setTtradecode(Integer.toString(newTradeCode));
		}
		
		System.out.println("active flag "+t30005.getT_active_flag());
		//set Active flag
		if(t30005.getT_active_flag()==null){
			t30005.setT_active_flag("0");
		}
		
		//set Generic name in Upper case
		t30005.setT_lang2_name(t30005.getT_lang2_name().toUpperCase());
		
		
		t30005Repository.save(t30005);
	}

	
	
	@Override
	public void deleteT30005(T30005 t30005) {
		t30005Repository.delete(t30005);
		
	}

	
	
	
	
	
	
	/*@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}*/

}
