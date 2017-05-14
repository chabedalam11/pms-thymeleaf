package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pms.model.T30004;
import com.pms.repository.T30004Repository;

@Service("t30004Service")
public class T30004ServiceImpl implements T30004Service{

	
	@Autowired
	private T30004Repository t30004Repository;
	
	@Override
	public List<T30004> findAll() {
		return t30004Repository.findAll();
	}
	
	@Override
	public List<T30004> findByTgencode(String tgencode) {
		return t30004Repository.findByTgencode(tgencode);
	}
	
	@Override
	public void saveT30004(T30004 t30004) {
		//set generic code
		if(t30004.getTgencode().equals("")){
			String maxCode=t30004Repository.getMaxTgencode();
			int newGenCode = Integer.parseInt(maxCode)+1;
			t30004.setTgencode(Integer.toString(newGenCode));
		}
		
		System.out.println("active flag "+t30004.getT_active_flag());
		//set Active flag
		if(t30004.getT_active_flag()==null){
			t30004.setT_active_flag("0");
		}
		
		//set Generic name in Upper case
		t30004.setT_lang2_nam(t30004.getT_lang2_nam().toUpperCase());
		
		
		t30004Repository.save(t30004);
	}

	@Override
	public void deleteT30004(T30004 t30004) {
		t30004Repository.delete(t30004);
		
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
