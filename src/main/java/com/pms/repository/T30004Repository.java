package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.model.T30004;

import java.lang.String;

@Repository("t30004Repository")
public interface T30004Repository extends JpaRepository<T30004, Long> {
	 T30004 findByTgencode(String tgencode);
	 
	 @Query("SELECT max(CAST(tgencode AS integer)) FROM  T30004")
	 String getMaxTgencode();
}
