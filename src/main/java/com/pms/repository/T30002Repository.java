package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.model.T30002;

import java.lang.String;

@Repository("t30002Repository")
public interface T30002Repository extends JpaRepository<T30002, Long> {
	
	 T30002 findByTdrugroutecode(String tdrugroutecode);
	 @Query("SELECT max(CAST(tdrugroutecode AS integer)) FROM  T30002")
	 String getMaxTdrugroutecode();
}
