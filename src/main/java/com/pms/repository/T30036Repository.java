package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.model.T30036;

import java.lang.String;

@Repository("t30036Repository")
public interface T30036Repository extends JpaRepository<T30036, Long> {
	
	 T30036 findByTum(String tum);
	 @Query("SELECT max(CAST(tum AS integer)) FROM  T30036")
	 String getMaxTum();
}
