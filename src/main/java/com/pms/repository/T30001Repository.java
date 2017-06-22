package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.model.T30001;
import java.lang.String;

@Repository("t30001Repository")
public interface T30001Repository extends JpaRepository<T30001, Long> {
	
	 T30001 findByTdrugformcode(String tdrugformcode);
	 @Query("SELECT max(CAST(tdrugformcode AS integer)) FROM  T30001")
	 String getMaxTdrugformcode();
}
