package edu.capstone_project.ViewQuote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.capstone_project.ViewQuote.model.ViewQuote;
import jakarta.transaction.Transactional;

import java.util.List;


public interface ViewQuoteRepository extends JpaRepository<ViewQuote, Integer> {
	
	List<ViewQuote> findByUserEmail(String userEmail);
	
	List<ViewQuote> findByPlanId(String planId);
	
	@Query(value="select * from view_quote where plan_id= :planId and user_email= :user_email",nativeQuery=true)
	List<ViewQuote> findByPlanIdAndEmailId(@Param("planId")String planId,@Param("user_email")String emailId);
	
	@Modifying
	@Transactional
	@Query(value="delete from view_quote where plan_id = :planId and user_email = :userEmail", nativeQuery = true)
	void deletePlanByPlanIdAndUserEmail(@Param("planId") String planId, @Param("userEmail") String userEmail);


}
