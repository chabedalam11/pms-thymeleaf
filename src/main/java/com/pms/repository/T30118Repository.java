package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pms.model.T30118;

import java.lang.String;

@Repository("t30118Repository")
public interface T30118Repository extends JpaRepository<T30118, Long> {
	
	 T30118 findByTvendorcode(String tvendorcode);
	 @Query("SELECT max(CAST(tvendorcode AS integer)) FROM  T30118")
	 String getMaxTvendorcode();
}
