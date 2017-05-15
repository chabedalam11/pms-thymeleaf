package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pms.model.T30007;
import java.lang.String;
import java.util.List;

@Repository("t30007Repository")
public interface T30007Repository extends JpaRepository<T30007, Long> {
	 T30007 findByTmanufacturercode(String tmanufacturercode);
	 
	 @Query("select coalesce(max(tmanufacturercode), '0') from T30007")
	 String getMaxTmanufacturercode();
}
